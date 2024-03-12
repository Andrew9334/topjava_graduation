package com.topjava.restrauntvoting.web.dish;

import com.topjava.restrauntvoting.repository.DishRepository;
import com.topjava.restrauntvoting.to.DishesTo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = DishController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class DishController {

    static final String REST_URL = "/api/profile/dishes";

    private final DishRepository repository;

    public List<DishesTo> getAll(@PathVariable("restaurantId") int restaurantId) {
        log.info("getAll for restaurant {}", restaurantId);
        return repository.getAll(restaurantId);
    }
}

