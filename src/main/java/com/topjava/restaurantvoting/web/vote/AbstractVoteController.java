package com.topjava.restaurantvoting.web.vote;

import com.topjava.restaurantvoting.model.Vote;
import com.topjava.restaurantvoting.repository.VoteRepository;
import com.topjava.restaurantvoting.service.VoteService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.slf4j.LoggerFactory.getLogger;

public abstract class AbstractVoteController {
    protected final Logger log = getLogger(getClass());

    @Autowired
    protected VoteRepository repository;

    @Autowired
    protected VoteService service;

    public ResponseEntity<Vote> get(int restaurantId, int userId, int id) {
        log.info("get vote {} by user {}", id, restaurantId);
        return ResponseEntity.of(repository.getWithUserAndRestaurant(id, userId, restaurantId));
    }
}
