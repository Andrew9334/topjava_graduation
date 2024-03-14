package com.topjava.restrauntvoting.web.dish;

import com.topjava.restrauntvoting.model.Dish;
import com.topjava.restrauntvoting.repository.DishRepository;
import com.topjava.restrauntvoting.service.DishService;
import com.topjava.restrauntvoting.to.DishesTo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public abstract class AbstractDishController {

    protected final Logger log = getLogger(getClass());

    @Autowired
    protected DishRepository repository;

    @Autowired
    protected DishService service;

    public ResponseEntity<Dish> get(int id, int restaurantId) {
        log.info("get dish {} from restaurant {}", id, restaurantId);
        return ResponseEntity.of(repository.get(restaurantId, id));
    }

    public List<DishesTo> getAll(int id) {
        log.info("getAll for restaurant {}", id);
        return repository.getAll(id);
    }
}
