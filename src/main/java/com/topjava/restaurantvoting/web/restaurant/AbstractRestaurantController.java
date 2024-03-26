package com.topjava.restaurantvoting.web.restaurant;

import com.topjava.restaurantvoting.model.Restaurant;
import com.topjava.restaurantvoting.repository.RestaurantRepository;
import com.topjava.restaurantvoting.service.RestaurantService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public abstract class AbstractRestaurantController {

    protected final Logger log = getLogger(getClass());

    @Autowired
    protected RestaurantRepository repository;

    @Autowired
    protected RestaurantService service;

    public ResponseEntity<Restaurant> get(int id) {
        log.info("get {}", id);
        return ResponseEntity.of(repository.get(id));
    }

    public List<Restaurant> getAll() {
        log.info("getAll restaurant");
        return repository.findAll();
    }
}
