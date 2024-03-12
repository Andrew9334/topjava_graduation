package com.topjava.restrauntvoting.web.dish;

import com.topjava.restrauntvoting.model.Dish;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.topjava.restrauntvoting.validation.ValidationUtil.assureIdConsistent;
import static com.topjava.restrauntvoting.validation.ValidationUtil.checkNew;

@RestController
@RequestMapping(value = DishAdminController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class DishAdminController {

    static final String REST_URL = "/api/admin/dishes";

    private DishRepository repository;
    private DishService service;

    public ResponseEntity<Dish> get(@PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId) {
        log.info("get dish {} from restaurant {}", id, restaurantId);
        return ResponseEntity.of(repository.get(restaurantId, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id, @PathVariable("restaurantId") int restaurantId) {
        log.info("delete {} for user {}", id, restaurantId);
        Dish dish = repository.getBelonged(restaurantId, id);
        repository.delete(dish);
    }

    @GetMapping
    public List<DishesTo> getAll(@PathVariable("restaurantId") int restaurantId) {
        log.info("getAll for restaurant {}", restaurantId);
        return repository.getAll(restaurantId);
    }

    @PutMapping(value = "{/id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("restaurantId") int restaurantId, @PathVariable("id") int id, @Valid @RequestBody Dish dish) {
        log.info("update {} for restaurant {}", dish, restaurantId);
        assureIdConsistent(dish, id);
        repository.getBelonged(restaurantId, id);
        service.save(restaurantId, dish);
    }

    public ResponseEntity<Dish> create(@PathVariable("restaurantId") int restaurantId, @Valid @RequestBody Dish dish) {
        log.info("create {} for restaurant {}", dish, restaurantId);
        checkNew(dish);
        Dish created = service.save(restaurantId, dish);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
