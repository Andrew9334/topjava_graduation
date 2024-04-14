package com.topjava.restaurantvoting.web.vote;

import com.topjava.restaurantvoting.mapper.VoteMapper;
import com.topjava.restaurantvoting.model.Vote;
import com.topjava.restaurantvoting.service.VoteService;
import com.topjava.restaurantvoting.to.VoteRequestTo;
import com.topjava.restaurantvoting.to.VoteResponseTo;
import com.topjava.restaurantvoting.util.Constants;
import com.topjava.restaurantvoting.web.AuthUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = VoteController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@RequiredArgsConstructor
public class VoteController {

    static final String REST_URL = "/api/votes";

    private final VoteService voteService;
    private final VoteMapper voteMapper;

    @GetMapping
    public List<Vote> getAllForUser(boolean onlyActive, @AuthenticationPrincipal AuthUser authUser) {
        return voteService.getAllUserVotes(authUser.getUser().getId(), onlyActive);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id, @AuthenticationPrincipal AuthUser authUser) {
        log.info("delete {}", id);
        voteService.deleteVoteById(id, authUser.getUser());
    }

    @PutMapping(value = "/{id}")
    public VoteResponseTo update(@Valid @RequestBody VoteRequestTo request, @PathVariable int id, @AuthenticationPrincipal AuthUser authUser) {
        int userId = authUser.id();
        log.info("update {} for user {}", request, userId);
//        assureIdConsistent(request, id);
        Vote vote = voteMapper.toEntity(request);
        vote.setId(id);
        Vote updatedVote = voteService.update(userId, vote);
        return voteMapper.toResponse(updatedVote);
    }

    @PostMapping
    public ResponseEntity<Vote> create(@Valid @RequestBody VoteRequestTo vote, @AuthenticationPrincipal AuthUser authUser) {
        log.info("create {} for user", vote);
//        checkNew(vote);
        Vote created = voteService.createVote(authUser.getUser().getId(), vote.getRestaurantId());
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(Constants.VOTE_URL + "/{id}")
                .buildAndExpand(authUser.getUser().getId(), vote.getRestaurantId(), created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
