package com.topjava.restaurantvoting.web.dish;

import com.topjava.restaurantvoting.model.Dish;
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

    static final String REST_URL = "/api/profile/restaurants/{restaurantId}/dishes";

    @Override
    @GetMapping("{id}")
    public ResponseEntity<Dish> get(int id, int restaurantId) {
        return super.get(id, restaurantId);
    }

    @Override
    @GetMapping
    public List<Dish> getAll() {
        return super.getAll();
    }
}

