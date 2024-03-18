package com.topjava.restaurantvoting.web.dish;

import com.topjava.restaurantvoting.model.Dish;
import com.topjava.restaurantvoting.repository.DishRepository;
import com.topjava.restaurantvoting.service.DishService;
import com.topjava.restaurantvoting.to.DishesTo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public abstract class AbstractDishController {

    protected final Logger log = getLogger(getClass());

    @Autowired
    protected DishRepository repository;

    @Autowired
    protected DishService service;

    public ResponseEntity<Dish> get(@PathVariable int restaurantId, @PathVariable int id) {
        log.info("get dish {} from restaurant {}", id, restaurantId);
        return ResponseEntity.of(repository.get(restaurantId, id));
    }

    public List<Dish> getAll() {
        log.info("getAll dishes");
        return repository.findAll();
    }
}
