package com.topjava.restrauntvoting.util;

import com.topjava.restrauntvoting.model.Dish;
import com.topjava.restrauntvoting.to.DishesTo;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DishesUtil {

    public static DishesTo createTo(Dish dish) {
        return new DishesTo(dish.getId(), dish.getDateTime(), dish.getDescription(), dish.getPrice());
    }
}
