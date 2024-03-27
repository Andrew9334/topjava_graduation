package com.topjava.restaurantvoting.service;

import com.topjava.restaurantvoting.model.Dishes;
import com.topjava.restaurantvoting.repository.DishesRepository;
import com.topjava.restaurantvoting.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DishesService {

    private final DishesRepository dishesRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Dishes save(int restaurantId, Dishes dishes) {
        dishes.setRestaurant(restaurantRepository.getExisted(restaurantId));
        return dishesRepository.save(dishes);
    }
}
