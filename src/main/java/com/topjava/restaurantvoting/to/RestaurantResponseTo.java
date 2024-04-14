package com.topjava.restaurantvoting.to;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantResponseTo {

    private int id;
    private String name;
    private List<DishTo> dishes;
}
