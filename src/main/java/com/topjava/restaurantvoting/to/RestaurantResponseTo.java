package com.topjava.restaurantvoting.to;

import lombok.Data;

import java.util.List;

@Data
public class RestaurantResponseTo {

    private int id;
    private String name;
    private List<DishTo> dishes;
}
