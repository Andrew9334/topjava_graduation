package com.topjava.restrauntvoting.web.restaurant;

import com.topjava.restrauntvoting.model.Restaurant;
import com.topjava.restrauntvoting.repository.RestaurantRepository;
import com.topjava.restrauntvoting.service.RestaurantService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

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

    public List<Restaurant> getAll(int id) {
        log.info("getAll restaurant {}", id);
        return repository.getAll(id);
    }

    public ResponseEntity<Restaurant> getWithDish(int id) {
        log.info("get with dish {}", id);
        return ResponseEntity.of(repository.getWithDish(id));
    }
}
