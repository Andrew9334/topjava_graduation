package com.topjava.restaurantvoting.service;

import com.topjava.restaurantvoting.model.Vote;
import com.topjava.restaurantvoting.repository.RestaurantRepository;
import com.topjava.restaurantvoting.repository.UserRepository;
import com.topjava.restaurantvoting.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class VoteService {

    private VoteRepository voteRepository;
    private UserRepository userRepository;
    private RestaurantRepository restaurantRepository;

    @Transactional
    public Vote save(int userId, int restaurantId, Vote vote) {
        vote.setUser(userRepository.getExisted(userId));
        vote.setRestaurant(restaurantRepository.getExisted(restaurantId));
        return voteRepository.save(vote);
    }
}
