package com.topjava.restrauntvoting.web.vote;

import com.topjava.restrauntvoting.model.Vote;
import com.topjava.restrauntvoting.repository.VoteRepository;
import com.topjava.restrauntvoting.service.VoteService;
import com.topjava.restrauntvoting.to.VoteTo;
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
        return ResponseEntity.of(repository.get(userId, id));
    }

    public List<VoteTo> getALl(int id) {
        log.info("getAll {}", id);
        return repository.getAll(id);
    }
}
