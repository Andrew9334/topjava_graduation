package com.topjava.restrauntvoting.service;

import com.topjava.restrauntvoting.model.Dishes;
import com.topjava.restrauntvoting.model.Restaurant;
import com.topjava.restrauntvoting.repository.DishesRepository;
import com.topjava.restrauntvoting.repository.RestaurantRepository;
import com.topjava.restrauntvoting.repository.UserRepository;
import com.topjava.restrauntvoting.repository.VoteRepository;
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
