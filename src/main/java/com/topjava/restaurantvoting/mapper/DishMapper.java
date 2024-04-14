package com.topjava.restaurantvoting.mapper;

import com.topjava.restaurantvoting.model.Dish;
import com.topjava.restaurantvoting.to.DishTo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DishMapper {

    public DishTo toDto(Dish dish) {
        return new DishTo(dish.getId(), dish.getName(), dish.getDate(), dish.getPrice());
    }

    public Dish toEntity(DishTo dishTo) {
        return new Dish(dishTo.getId(), dishTo.getName(), dishTo.getDate(), dishTo.getPrice());
    }
}
