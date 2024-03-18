package com.topjava.restaurantvoting.util;

import com.topjava.restaurantvoting.model.Dish;
import com.topjava.restaurantvoting.to.DishesTo;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DishesUtil {

    public static DishesTo createTo(Dish dish) {
        return new DishesTo(dish.getId(), dish.getDate(), dish.getPrice());
    }
}
