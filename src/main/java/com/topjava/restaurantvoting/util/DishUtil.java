package com.topjava.restaurantvoting.util;

import com.topjava.restaurantvoting.to.DishTo;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DishUtil {

    public static DishTo createTo(DishTo dishTo) {
        return new DishTo(dishTo.getId(), dishTo.getName(), dishTo.getDate(), dishTo.getPrice());
    }
}
