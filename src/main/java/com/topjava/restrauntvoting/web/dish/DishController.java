package com.topjava.restrauntvoting.web.dish;

import com.topjava.restrauntvoting.model.Dish;
import com.topjava.restrauntvoting.repository.DishRepository;
import com.topjava.restrauntvoting.to.DishesTo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = DishController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
public class DishController extends AbstractDishController {

    static final String REST_URL = "/api/profile/dishes";

    @Override
    @GetMapping("/{resturantId}/{id}")
    public ResponseEntity<Dish> get(int id, int restaurantId) {
        return super.get(id, restaurantId);
    }

    @Override
    @GetMapping
    public List<DishesTo> getAll(@PathVariable int id) {
        return super.getAll(id);
    }
}

