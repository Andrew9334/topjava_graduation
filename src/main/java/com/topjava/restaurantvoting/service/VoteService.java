package com.topjava.restaurantvoting.service;

import com.topjava.restaurantvoting.error.UserCannotChangeVoteException;
import com.topjava.restaurantvoting.error.VoteAlreadyExistedException;
import com.topjava.restaurantvoting.error.VoteNotFoundException;
import com.topjava.restaurantvoting.error.VoteTimeException;
import com.topjava.restaurantvoting.model.Restaurant;
import com.topjava.restaurantvoting.model.User;
import com.topjava.restaurantvoting.model.Vote;
import com.topjava.restaurantvoting.repository.RestaurantRepository;
import com.topjava.restaurantvoting.repository.UserRepository;
import com.topjava.restaurantvoting.repository.VoteRepository;
import com.topjava.restaurantvoting.util.DateTimeUtil;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VoteService {

    private VoteRepository voteRepository;
    private UserRepository userRepository;
    private RestaurantRepository restaurantRepository;
    private RestaurantService restaurantService;
    private UserService userService;

    @Transactional
    public Vote createVote(int userId, int restaurantId) {
        if (voteRepository.existsByUserIdAndRestaurantId(userId, restaurantId)) {
            throw new VoteAlreadyExistedException("Vote already existed");
        }
        Vote vote = new Vote();
        vote.setUser(userRepository.getExisted(userId));
        vote.setRestaurant(restaurantService.getById(restaurantId));
        vote.setCreatedDateTime(LocalDateTime.now());
        vote.setUpdatedDateTime(LocalDateTime.now());
        return voteRepository.save(vote);
    }

    @Transactional
    public Vote update(int userId, Vote vote) {
        Restaurant restaurant = restaurantService.getById(vote.getRestaurant().getId());
//        User user = userService.getById(userId);
        if (!voteRepository.existsByUserIdAndRestaurantId(userId, restaurant.getId())) {
            throw new VoteNotFoundException(String.format("Vote '%s' is not found", vote.id()));
        }
        return voteRepository.findById(vote.getId())
                .filter(v -> DateTimeUtil.limitTimeForVoting(LocalDateTime.now(), v.getCreatedDateTime()))
                .map(v -> {
                    Vote entity = voteRepository.save(v);
                    entity.setUpdatedDateTime(LocalDateTime.now());
                    return entity;
                })
                .orElseThrow(() -> new VoteTimeException("Current date or current time for voting is so late"));
    }

    @Transactional
    public void deleteVoteById(int id, User user) {
        Vote vote = voteRepository.findById(id)
                .orElseThrow(() -> new VoteNotFoundException(String.format("Vote '%s' is not found", id)));
        if (!voteRepository.existsByUserId(user.getId())) {
            throw new UserCannotChangeVoteException(
                    String.format("User '%s' has not permission to change the vote '%s'", user.getId(), id)
            );
        }
        if (!DateTimeUtil.limitTimeForVoting(LocalDateTime.now(), vote.getCreatedDateTime())) {
            throw new VoteTimeException("Current date or current time for voting is so late");
        }
        voteRepository.findById(id)
                .filter(v -> DateTimeUtil.limitTimeForVoting(LocalDateTime.now(), v.getCreatedDateTime()))
                .ifPresent(v -> voteRepository.deleteById(v.getId()));
    }

    public List<Vote> getAllUserVotes(Integer userId, boolean onlyActive) {
        List<Vote> votes = voteRepository.findAllByUserId(userId);
        if (onlyActive && Objects.nonNull(votes) && !votes.isEmpty()) {
            return votes.stream()
                    .filter((v -> DateTimeUtil.limitTimeForVoting(LocalDateTime.now(), v.getCreatedDateTime())))
                    .toList();
        }
        return votes;
    }
}
