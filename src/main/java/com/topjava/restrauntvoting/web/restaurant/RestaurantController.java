package com.topjava.restrauntvoting.web.restaurant;

import com.topjava.restrauntvoting.model.Restaurant;
import com.topjava.restrauntvoting.model.Vote;
import com.topjava.restrauntvoting.repository.RestaurantRepository;
import com.topjava.restrauntvoting.repository.VoteRepository;
import com.topjava.restrauntvoting.service.RestaurantService;
import com.topjava.restrauntvoting.service.VoteService;
import com.topjava.restrauntvoting.to.VoteTo;
import com.topjava.restrauntvoting.web.AuthUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = RestaurantController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class RestaurantController extends AbstractRestaurantController {

    static final String REST_URL = "/api/profile/restaurant";

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> get(@PathVariable int id) {
        return super.get(id);
    }

    @Override
    @GetMapping
    public List<Restaurant> getAll(@PathVariable int id) {
        return super.getAll(id);
    }

    @Override
    @GetMapping("/{id}/with-dish")
    public ResponseEntity<Restaurant> getWithDish(@PathVariable int id) {
        return super.getWithDish(id);
    }
}
