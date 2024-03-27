package com.topjava.restaurantvoting.web.dish;

import com.topjava.restaurantvoting.MatcherFactory;
import com.topjava.restaurantvoting.model.Dish;
import com.topjava.restaurantvoting.util.JsonUtil;

import java.time.LocalDate;
import java.util.List;

import static com.topjava.restaurantvoting.web.restaurant.RestaurantTestData.*;
import static java.time.LocalDateTime.of;

public class DishTestData {

    public static MatcherFactory.Matcher<Dish> DISH_MATCHER = MatcherFactory.usingEqualsComparator(Dish.class);
    public static final int DISH_REST1_ID = 1;
    public static final int DISH_REST2_ID = 8;

    public static final Dish DISH1_REST1 = new Dish(DISH_REST1_ID, "Beef steak", LocalDate.now(),  500, REST1);
    public static final Dish DISH2_REST1 = new Dish(DISH_REST1_ID + 1, "Margarita", LocalDate.now(),  300, REST1);
    public static final Dish DISH3_REST1 = new Dish(DISH_REST1_ID + 2, "Salad", LocalDate.now(),  200, REST1);
    public static final Dish DISH4_REST1 = new Dish(DISH_REST1_ID + 3, "Bread", LocalDate.now(),  150, REST1);
    public static final Dish DISH5_REST1 = new Dish(DISH_REST1_ID + 4, "Soup", LocalDate.now(),  250, REST1);
    public static final Dish DISH6_REST1 = new Dish(DISH_REST1_ID + 5, "Grilled ribs", LocalDate.now(),  250, REST1);

    public static final List<Dish> DISHES_REST1 = List.of(DISH1_REST1, DISH2_REST1, DISH3_REST1, DISH4_REST1, DISH5_REST1, DISH6_REST1);

    public static final Dish DISH1_REST2 = new Dish(DISH_REST2_ID, "Soup", LocalDate.now(), 50, REST2);
    public static final Dish DISH2_REST2 = new Dish(DISH_REST2_ID + 1, "Salad", LocalDate.now(), 10, REST2);
    public static final Dish DISH3_REST2 = new Dish(DISH_REST2_ID + 2, "Grilled ribs", LocalDate.now(), 300, REST2);
    public static final List<Dish> DISHES_REST2 = List.of(DISH1_REST2, DISH2_REST2, DISH3_REST2);

    public static Dish getNew() {
        return new Dish(null, "Created dish", LocalDate.now(), 100, null);
    }

    public static Dish getUpdated() {
        return new Dish(DISH_REST1_ID, "Updated dish", DISH1_REST1.getDate(), 20, REST3);
    }

    public static String jsonInvalid(Dish dish) {
        return JsonUtil.writeAdditionProps(dish, "newName", "dish");
    }
}
