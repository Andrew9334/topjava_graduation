package com.topjava.restaurantvoting.mapper;

import com.topjava.restaurantvoting.model.Restaurant;
import com.topjava.restaurantvoting.to.DishTo;
import com.topjava.restaurantvoting.to.RestaurantRequestTo;
import com.topjava.restaurantvoting.to.RestaurantResponseTo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RestaurantMapper {

    private final DishMapper dishMapper;

    public RestaurantRequestTo toRequest(Restaurant restaurant) {
        return new RestaurantRequestTo();
    }

    public RestaurantResponseTo toResponse(Restaurant restaurant) {
        RestaurantResponseTo response = new RestaurantResponseTo();

        List<DishTo> dishes = restaurant.getDishes().stream()
                        .map(dishMapper::toDto)
                                .toList();

        response.setId(restaurant.getId());
        response.setName(restaurant.getName());
        response.setDishes(dishes);
        return response;
    }

    public Restaurant toEntity(RestaurantRequestTo request) {
        return new Restaurant(null, request.getName(), new ArrayList<>());
    }
}
