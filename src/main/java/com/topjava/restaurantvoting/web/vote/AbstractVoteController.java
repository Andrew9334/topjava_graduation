package com.topjava.restaurantvoting.web.vote;

import com.topjava.restaurantvoting.model.Vote;
import com.topjava.restaurantvoting.repository.VoteRepository;
import com.topjava.restaurantvoting.service.VoteService;
import com.topjava.restaurantvoting.to.VoteTo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class AbstractVoteController {
    protected final Logger log = getLogger(getClass());

    @Autowired
    protected VoteRepository repository;

    @Autowired
    protected VoteService service;

    public ResponseEntity<Vote> get(int userId, int id) {
        log.info("get vote {} by user {}", id, userId);
        return ResponseEntity.of(repository.get(id));
    }

    public List<VoteTo> getALl(int id) {
        log.info("getAll {}", id);
        return repository.getAll(id);
    }
}
