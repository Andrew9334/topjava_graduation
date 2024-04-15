package com.topjava.restaurantvoting.web.restaurant;

import com.topjava.restaurantvoting.AbstractControllerTest;
import com.topjava.restaurantvoting.model.Restaurant;
import com.topjava.restaurantvoting.repository.RestaurantRepository;
import com.topjava.restaurantvoting.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.topjava.restaurantvoting.web.restaurant.RestaurantController.REST_URL;
import static com.topjava.restaurantvoting.web.restaurant.RestaurantTestData.*;
import static com.topjava.restaurantvoting.web.user.UserTestData.ADMIN_MAIL;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RestaurantAdminControllerTest extends AbstractControllerTest {

    static final String REST_URL_SLASH = REST_URL + "/";

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    @WithUserDetails(ADMIN_MAIL)
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL_SLASH + REST1_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(REST_MATCHER.contentJson(rest1));
    }

    @Test
    @WithUserDetails(ADMIN_MAIL)
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL_SLASH + REST1_ID))
                .andExpect(status().isNoContent());
        assertFalse(restaurantRepository.get(REST1_ID).isPresent());
    }

    @Test
    @WithUserDetails(ADMIN_MAIL)
    void update() throws Exception {
        Restaurant updated = RestaurantTestData.getUpdated();
        perform(MockMvcRequestBuilders.put(REST_URL_SLASH + REST1_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isNoContent());

        REST_MATCHER.assertMatch(restaurantRepository.getExisted(REST1_ID), updated);
    }

    @Test
    @WithUserDetails(ADMIN_MAIL)
    void create() throws Exception {
        Restaurant newRest = RestaurantTestData.getNew();
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newRest)));

        Restaurant created = REST_MATCHER.readFromJson(action);
        int newId = created.id();
        newRest.setId(newId);
        REST_MATCHER.assertMatch(created, newRest);
        REST_MATCHER.assertMatch(restaurantRepository.getExisted(newId), newRest);
    }

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void createInvalid() throws Exception {
        Restaurant invalid = new Restaurant(null, null);
        perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(RestaurantTestData.jsonInvalid(invalid)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void updateInvalid() throws Exception {
        Restaurant invalid = new Restaurant(REST1_ID, null);
        perform(MockMvcRequestBuilders.put((REST_URL_SLASH + REST1_ID))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void createDuplicate() throws Exception {
        Restaurant invalid = new Restaurant(null, rest1.getName());
        perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(invalid)))
                .andDo(print())
                .andExpect(status().isConflict());
    }
}