package com.topjava.restaurantvoting.web.vote;

import com.topjava.restaurantvoting.model.Vote;
import com.topjava.restaurantvoting.repository.VoteRepository;
import com.topjava.restaurantvoting.service.VoteService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public abstract class AbstractVoteController {
    protected final Logger log = getLogger(getClass());

    @Autowired
    protected VoteRepository repository;

    @Autowired
    protected VoteService service;

    public ResponseEntity<Vote> get(int restaurantId, int id) {
        log.info("get vote {} by user {}", id, restaurantId);
        return ResponseEntity.of(repository.get(id, restaurantId));
    }

    public List<Vote> getAll() {
//        log.info("getAll by restaurant {}", restaurantId);
        return repository.findAll();
    }
}
