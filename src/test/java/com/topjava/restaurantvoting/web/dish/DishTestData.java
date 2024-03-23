package com.topjava.restaurantvoting.web.dish;

import com.topjava.restaurantvoting.MatcherFactory;
import com.topjava.restaurantvoting.model.Dish;
import com.topjava.restaurantvoting.model.User;
import com.topjava.restaurantvoting.to.DishesTo;
import com.topjava.restaurantvoting.util.JsonUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.topjava.restaurantvoting.web.restaurant.RestaurantTestData.*;
import static java.time.LocalDateTime.of;

public class DishTestData {

    public static MatcherFactory.Matcher<Dish> DISH_MATCHER = MatcherFactory.usingEqualsComparator(Dish.class);
    public static final int DISH_RESTAURANT1_ID = 1;
    public static final int DISH_RESTAURANT2_ID = 8;

    public static final Dish DISH1_RESTAURANT1 = new Dish(DISH_RESTAURANT1_ID, "Beef steak", LocalDate.now(),  500, REST1);
    public static final Dish DISH2_RESTAURANT1 = new Dish(DISH_RESTAURANT1_ID + 1, "Margarita", LocalDate.now(),  300, REST1);
    public static final Dish DISH3_RESTAURANT1 = new Dish(DISH_RESTAURANT1_ID + 2, "Salad", LocalDate.now(),  200, REST1);
    public static final Dish DISH4_RESTAURANT1 = new Dish(DISH_RESTAURANT1_ID + 3, "Bread", LocalDate.now(),  150, REST1);
    public static final Dish DISH5_RESTAURANT1 = new Dish(DISH_RESTAURANT1_ID + 4, "Soup", LocalDate.now(),  250, REST1);
    public static final Dish DISH6_RESTAURANT1 = new Dish(DISH_RESTAURANT1_ID + 5, "Grilled ribs", LocalDate.now(),  250, REST1);


//
    public static final List<Dish> DISHES_RESTAURANT1 = List.of(DISH1_RESTAURANT1, DISH2_RESTAURANT1, DISH3_RESTAURANT1, DISH4_RESTAURANT1, DISH5_RESTAURANT1, DISH6_RESTAURANT1);
//
//    public static final Dish DISH1_RESTAURANT2 = new Dish(DISH_RESTAURANT2_ID, "Soup", LocalDateTime.now(), "Soup", 50, REST2);
//    public static final Dish DISH2_RESTAURANT2 = new Dish(DISH_RESTAURANT2_ID + 1, "Salad", LocalDateTime.now(), "Salad", 10, REST2);
//    public static final Dish DISH3_RESTAURANT2 = new Dish(DISH_RESTAURANT2_ID + 2, "Grilled ribs", LocalDateTime.now(), "Grilled ribs", 300, REST2);
//
//    public static final List<Dish> DISHES_RESTAURANT2 = List.of(DISH1_RESTAURANT2, DISH2_RESTAURANT2, DISH3_RESTAURANT2);

    public static MatcherFactory.Matcher<DishesTo> DISH_TO_MATCHER = MatcherFactory.usingEqualsComparator(DishesTo.class);

    public static Dish getNew() {
        return new Dish(null, "Created dish", LocalDate.now(), 100, null);
    }

    public static Dish getUpdated() {
        return new Dish(DISH_RESTAURANT1_ID, "Updated dish", DISH1_RESTAURANT1.getDate(), 20, REST3);
    }

    public static String jsonInvalid(Dish dish) {
        return JsonUtil.writeAdditionProps(dish, "newName", "dish");
    }
}
