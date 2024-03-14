package com.topjava.restrauntvoting.web.vote;

import com.topjava.restrauntvoting.model.Vote;
import com.topjava.restrauntvoting.to.VoteTo;
import com.topjava.restrauntvoting.web.AuthUser;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.topjava.restrauntvoting.validation.ValidationUtil.assureIdConsistent;
import static com.topjava.restrauntvoting.validation.ValidationUtil.checkNew;

public class VoteAdminController extends AbstractVoteController {

    static final String REST_URL = "/api/admin/vote";

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Vote> get(int userId, int id) {
        return super.get(userId, id);
    }

    @Override
    @GetMapping
    public List<VoteTo> getALl(int id) {
        return super.getALl(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@AuthenticationPrincipal AuthUser authUser, @PathVariable int id, @PathVariable int restaurantId) {
        log.info("delete {} for user {} and restaurant {}", id, authUser.id(), restaurantId);
        Vote vote = repository.getBelonged(authUser.id(), restaurantId, id);
        repository.delete(vote);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@AuthenticationPrincipal AuthUser authUser, @Valid @RequestBody Vote vote, @PathVariable int id, @PathVariable int restaurantId) {
        int userId = authUser.id();
        log.info("update {} for user {}", vote, userId);
        assureIdConsistent(vote, id);
        repository.getBelonged(userId, restaurantId, id);
        service.save(userId, restaurantId, vote);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> create(@AuthenticationPrincipal AuthUser authUser, @PathVariable int restaurantId, @Valid @RequestBody Vote vote) {
        int userId = authUser.id();
        log.info("create {} for user {}", vote, userId);
        checkNew(vote);
        Vote created = service.save(userId, restaurantId, vote);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vote> getWithUser(@AuthenticationPrincipal int userId, @PathVariable int id) {
        log.info("get {} with user {}", id, userId);
        return ResponseEntity.of(repository.getWithUser(id, userId));
    }

    @GetMapping("/{restaurantId}/{id}")
    public ResponseEntity<Vote> getWithUserAndRestaurant(@AuthenticationPrincipal int userId, @PathVariable int id, @PathVariable int restaurantId) {
        log.info("get {} with user {} and with restaurant {}", id, userId, restaurantId);
        return ResponseEntity.of(repository.getWithUserAndRestaurant(userId, restaurantId, id));
    }
}
