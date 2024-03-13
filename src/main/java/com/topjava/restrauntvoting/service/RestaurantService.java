package com.topjava.restrauntvoting.service;

import com.topjava.restrauntvoting.model.Dish;
import com.topjava.restrauntvoting.model.Restaurant;
import com.topjava.restrauntvoting.repository.DishRepository;
import com.topjava.restrauntvoting.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
@AllArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
