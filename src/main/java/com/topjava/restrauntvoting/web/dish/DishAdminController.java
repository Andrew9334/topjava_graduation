package com.topjava.restrauntvoting.web.dish;

import com.topjava.restrauntvoting.model.Dishes;
import com.topjava.restrauntvoting.repository.DishRepository;
import com.topjava.restrauntvoting.service.DishService;
import com.topjava.restrauntvoting.to.DishesTo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = DishAdminController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class DishAdminController {

    static final String REST_URL = "/api/admin/dishes";

    private DishRepository repository;
    private DishService service;

    public ResponseEntity<Dishes> get(@PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId) {
        log.info("get dish {} from restaurant {}", id, restaurantId);
        return ResponseEntity.of(repository.get(restaurantId, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId) {
        log.info("delete {} for user {}", id, restaurantId);
        Dishes dishes = repository.getBelonged(restaurantId, id);
        repository.delete(dishes);
    }

    @GetMapping
    public List<DishesTo> getAll(@PathVariable("restaurantId") int restaurantId) {
        log.info("getAll for restaurant {}", restaurantId);
        return repository.getAll(restaurantId);
    }

    public void update(@PathVariable("restaurantId") int restaurantId, @PathVariable("id") int id, @Valid @RequestBody Dishes dishes) {
        log.info("update {} for restaurant {}", dishes, restaurantId);
    }
}
