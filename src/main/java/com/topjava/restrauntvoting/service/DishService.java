package com.topjava.restrauntvoting.service;

import com.topjava.restrauntvoting.model.Dishes;
import com.topjava.restrauntvoting.repository.DishRepository;
import com.topjava.restrauntvoting.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class DishService {

    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Dishes save(int restaurantId, Dishes dishes) {
        dishes.setRestaurant(restaurantRepository.getExisted(restaurantId));
        return dishRepository.save(dishes);
    }
}
