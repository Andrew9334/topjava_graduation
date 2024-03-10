package com.topjava.restrauntvoting.service;

import com.topjava.restrauntvoting.model.Vote;
import com.topjava.restrauntvoting.repository.RestaurantRepository;
import com.topjava.restrauntvoting.repository.UserRepository;
import com.topjava.restrauntvoting.repository.VoteRepository;
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
