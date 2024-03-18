package com.topjava.restaurantvoting.web.vote;

import com.topjava.restaurantvoting.AbstractControllerTest;
import com.topjava.restaurantvoting.repository.VoteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.topjava.restaurantvoting.web.restaurant.RestaurantTestData.REST1_ID;
import static com.topjava.restaurantvoting.web.user.UserTestData.*;
import static com.topjava.restaurantvoting.web.vote.VoteAdminController.REST_URL;
import static com.topjava.restaurantvoting.web.vote.VoteTestData.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class VoteAdminControllerTest extends AbstractControllerTest {

    private static final String REST_URL_SLASH = REST_URL + '/';

    @Autowired
    private VoteRepository repository;

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get((REST_URL_SLASH + VOTE1_ID), USER_ID))
                .andExpect(status().isOk())
                .andDo(print())
                // https://jira.spring.io/browse/SPR-14472
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(VOTE_MATCHER.contentJson(VOTE1));
    }

    @Test
    void getALl() {
    }

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL_SLASH + VOTE1_ID))
                .andDo(print())
                .andExpect(status().isNoContent());
        assertFalse(repository.findById(VOTE1_ID).isPresent());
    }

    @Test
    void update() {
    }

    @Test
    void create() {
    }

    @Test
    void getWithUser() {
    }

    @Test
    void getWithUserAndRestaurant() {
    }
}