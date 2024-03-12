package com.topjava.restrauntvoting.service;

import com.topjava.restrauntvoting.model.Dish;
import com.topjava.restrauntvoting.repository.DishRepository;
import com.topjava.restrauntvoting.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DishService {

    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Dish save(int restaurantId, Dish dish) {
        dish.setRestaurant(restaurantRepository.getExisted(restaurantId));
        return dishRepository.save(dish);
    }
}
