package com.topjava.restaurantvoting.web.dish;

import com.topjava.restaurantvoting.AbstractControllerTest;
import com.topjava.restaurantvoting.model.Dish;
import com.topjava.restaurantvoting.repository.DishRepository;
import com.topjava.restaurantvoting.util.JsonUtil;
import com.topjava.restaurantvoting.web.user.UserTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static com.topjava.restaurantvoting.web.dish.DishAdminController.REST_URL;
import static com.topjava.restaurantvoting.web.dish.DishTestData.*;
import static com.topjava.restaurantvoting.web.restaurant.RestaurantTestData.REST1;
import static com.topjava.restaurantvoting.web.restaurant.RestaurantTestData.REST1_ID;
import static com.topjava.restaurantvoting.web.user.UserTestData.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DishAdminControllerTest extends AbstractControllerTest {

    private static final String REST_URL_SLASH = REST_URL + '/';

    @Autowired
    private DishRepository dishRepository;

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get((REST_URL_SLASH + DISH_REST1_ID), REST1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(DISH_MATCHER.contentJson(DISH1_REST1));
    }

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete((REST_URL_SLASH + DISH_REST1_ID), REST1_ID))
                .andExpect(status().isNoContent());
        assertFalse(dishRepository.get(UserTestData.ADMIN_ID, DISH_REST1_ID).isPresent());
    }

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void getAll() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL, REST1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(DISH_MATCHER.contentJson(DISHES_REST1));
    }

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void update() throws Exception {
        Dish updated = DishTestData.getUpdated();
        perform(MockMvcRequestBuilders.put((REST_URL_SLASH + DISH_REST1_ID), REST1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isNoContent());

        DISH_MATCHER.assertMatch(dishRepository.getExisted(DISH_REST1_ID), updated);
    }

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void create() throws Exception {
        Dish newDish = DishTestData.getNew();
        ResultActions actions = perform(MockMvcRequestBuilders.post(REST_URL_SLASH, REST1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newDish)));

        Dish created = DISH_MATCHER.readFromJson(actions);
        int newId = created.id();
        newDish.setId(newId);
        DISH_MATCHER.assertMatch(created, newDish);
        DISH_MATCHER.assertMatch(dishRepository.getExisted(newId), newDish);
    }

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void createInvalid() throws Exception {
        Dish invalid = new Dish(null, null, LocalDate.now(), 20);
        perform(MockMvcRequestBuilders.post(REST_URL, REST1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonInvalid(invalid)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void updateInvalid() throws Exception {
        Dish invalid = new Dish(DISH_REST1_ID, null, null, 6000);
        perform(MockMvcRequestBuilders.put((REST_URL_SLASH + DISH_REST1_ID), REST1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void createDuplicate() throws Exception {
        Dish invalid = new Dish(null, DISH1_REST1.getName(), DISH1_REST1.getDate(), DISH1_REST1.getPrice());
        perform(MockMvcRequestBuilders.post(REST_URL, REST1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid)))
                .andDo(print())
                .andExpect(status().isConflict());
    }
}