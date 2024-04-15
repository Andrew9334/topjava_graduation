package com.topjava.restaurantvoting.web.restaurant;

import com.topjava.restaurantvoting.MatcherFactory;
import com.topjava.restaurantvoting.model.Restaurant;
import com.topjava.restaurantvoting.util.JsonUtil;

import java.util.List;

import static java.time.LocalDateTime.of;
import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantTestData {

    public static MatcherFactory.Matcher<Restaurant> REST_MATCHER = MatcherFactory.usingEqualsComparator(Restaurant.class);


    public static final int REST1_ID = 1;
    public static final int REST2_ID = 2;
    public static final int REST3_ID = 3;

    public static final Restaurant rest1 = new Restaurant(REST1_ID, "Muse");
    public static final Restaurant rest2 = new Restaurant(REST2_ID, "Porto Bello");
    public static final Restaurant rest3 = new Restaurant(REST3_ID, "Oniro");

    public static final List<Restaurant> RESTAURANTS = List.of(rest1, rest3, rest2);

    public static Restaurant getNew() {
        return new Restaurant(null, "Porto");
    }

    public static Restaurant getUpdated() {
        return new Restaurant(REST1_ID, "Onr");
    }

    public static String jsonInvalid(Restaurant restaurant) {
        return JsonUtil.writeAdditionProps(restaurant, "newName", "restaurant");
    }
}
