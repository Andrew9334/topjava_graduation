package com.topjava.restaurantvoting.web.dish;

import com.topjava.restaurantvoting.AbstractControllerTest;
import com.topjava.restaurantvoting.repository.DishRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.topjava.restaurantvoting.web.dish.DishController.REST_URL;
import static com.topjava.restaurantvoting.web.dish.DishTestData.*;
import static com.topjava.restaurantvoting.web.restaurant.RestaurantTestData.REST1_ID;
import static com.topjava.restaurantvoting.web.user.UserTestData.USER_MAIL;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DishControllerTest extends AbstractControllerTest {

    private static final String REST_URL_SLASH = REST_URL + '/';

    @Autowired
    private DishRepository dishRepository;

    @Test
    @WithUserDetails(value = USER_MAIL)
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get((REST_URL_SLASH + DISH_REST1_ID), REST1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(DISH_MATCHER.contentJson(DISH1_REST1));
    }

    @Test
    @WithUserDetails(value = USER_MAIL)
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(DishController.REST_URL, REST1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(DISH_MATCHER.contentJson(DISHES_REST1));
    }
}