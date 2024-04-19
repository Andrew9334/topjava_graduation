package com.topjava.restaurantvoting.web.dish;

import com.topjava.restaurantvoting.MatcherFactory;
import com.topjava.restaurantvoting.model.Dish;
import com.topjava.restaurantvoting.model.Restaurant;
import com.topjava.restaurantvoting.to.DishTo;
import com.topjava.restaurantvoting.util.JsonUtil;
import com.topjava.restaurantvoting.web.restaurant.RestaurantTestData;

import java.time.LocalDate;
import java.util.List;

import static com.topjava.restaurantvoting.web.restaurant.RestaurantTestData.*;
import static java.time.LocalDateTime.of;

public class DishTestData {

    public static MatcherFactory.Matcher<Dish> DISH_MATCHER = MatcherFactory.usingEqualsComparator(Dish.class);
    public static final int DISH_REST1_ID = 1;
    public static final int DISH_REST2_ID = 8;
    public static final int DISH_REST3_ID = 16;

    public static final Dish dish1Rest1 = new Dish(DISH_REST1_ID, "Beef steak",  LocalDate.of(2024, 4, 20), 500, null);
    public static final Dish dish2Rest1 = new Dish(DISH_REST1_ID + 3, "Bread", LocalDate.of(2024, 4, 20), 150, null);
    public static final Dish dish1Rest2 = new Dish(DISH_REST2_ID, "Margarita", LocalDate.of(2024, 4, 20), 300, rest2);
    public static final Dish dish2Rest2 = new Dish(DISH_REST2_ID, "Soup", LocalDate.of(2024, 4, 20), 250, rest2);
    public static final Dish dish1Rest3 = new Dish(DISH_REST3_ID, "Salad", LocalDate.of(2024, 4, 20), 200, rest2);
    public static final Dish dish2Rest3 = new Dish(DISH_REST3_ID, "Grilled ribs", LocalDate.of(2024, 4, 20), 250, rest2);

    public static MatcherFactory.Matcher<DishTo> DISH_TO_MATCHER = MatcherFactory.usingEqualsComparator(DishTo.class);

    public static final List<Dish> DISHES_REST1 = List.of(dish1Rest1, dish2Rest1);
    public static final List<Dish> DISHES_REST2 = List.of(dish1Rest2, dish2Rest2);
    public static final List<Dish> DISHES_REST3 = List.of(dish1Rest3, dish2Rest3);

    public static Dish getNew() {
        return new Dish(null, "Created dish", LocalDate.of(2024, 4, 10), 100, null);
    }

    public static Dish getUpdated() {
        return new Dish(DISH_REST1_ID, "Updated dish", dish1Rest1.getDate(), 20, rest3);
    }

    public static String jsonInvalid(Dish dish) {
        return JsonUtil.writeAdditionProps(dish, "newName", "dish");
    }
}
