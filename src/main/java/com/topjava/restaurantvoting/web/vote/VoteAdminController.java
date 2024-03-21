package com.topjava.restaurantvoting.web.vote;

import com.topjava.restaurantvoting.model.Vote;
import com.topjava.restaurantvoting.to.VoteTo;
import com.topjava.restaurantvoting.web.AuthUser;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.topjava.restaurantvoting.validation.ValidationUtil.assureIdConsistent;
import static com.topjava.restaurantvoting.validation.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = VoteAdminController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class VoteAdminController extends AbstractVoteController {

    static final String REST_URL = "/api/admin/{userId}/{restaurantId}/vote";

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Vote> get(@PathVariable int restaurantId, @PathVariable int id) {
        return super.get(restaurantId, id);
    }

//    @Override
//    @GetMapping
//    public List<Vote> getAll() {
//        return super.getAll();
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id, @PathVariable int restaurantId) {
        log.info("delete {}", id);
        Vote vote = repository.getBelonged(id, restaurantId);
        repository.delete(vote);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@AuthenticationPrincipal AuthUser authUser, @Valid @RequestBody Vote vote, @PathVariable int id, @PathVariable int restaurantId) {
        int userId = authUser.id();
        log.info("update {} for user {}", vote, userId);
        assureIdConsistent(vote, id);
        repository.getBelonged(id, restaurantId);
        service.save(userId, restaurantId, vote);
    }
}
