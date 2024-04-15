package com.topjava.restaurantvoting.web.vote;

import com.topjava.restaurantvoting.AbstractControllerTest;
import com.topjava.restaurantvoting.model.Vote;
import com.topjava.restaurantvoting.repository.VoteRepository;
import com.topjava.restaurantvoting.util.Constants;
import com.topjava.restaurantvoting.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static com.topjava.restaurantvoting.web.restaurant.RestaurantTestData.*;
import static com.topjava.restaurantvoting.web.user.UserTestData.*;

import static com.topjava.restaurantvoting.web.vote.VoteController.REST_URL;
import static com.topjava.restaurantvoting.web.vote.VoteTestData.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class VoteControllerTest extends AbstractControllerTest {

    @Autowired
    private VoteRepository repository;

    static final String REST_URL_SLASH = REST_URL + "/";

    @Test
    @WithUserDetails(value = USER_MAIL)
    void getAllForUser() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(VOTE_MATCHER.contentJson(vote1));
    }

    @Test
    @WithUserDetails(value = USER_MAIL)
    void update() throws Exception {
        Vote updated = VoteTestData.getUpdated();
        perform(MockMvcRequestBuilders.put((REST_URL_SLASH + VOTE1_ID), USER_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isNoContent());

        VOTE_MATCHER.assertMatch(repository.getExisted(VOTE1_ID), updated);
    }

    @Test
    @WithUserDetails(value = USER_MAIL)
    void create() throws Exception {
        Vote newVote = VoteTestData.getNew();
        ResultActions actions = perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newVote)));

        Vote created = VOTE_MATCHER.readFromJson(actions);
        int newId = created.id();
        newVote.setId(newId);
        VOTE_MATCHER.assertMatch(created, newVote);
        VOTE_MATCHER.assertMatch(repository.getExisted(newId), newVote);
    }

    @Test
    @WithUserDetails(value = ADMIN_MAIL)
    void delete() throws Exception {
        perform(MockMvcRequestBuilders.delete(REST_URL, VOTE1_ID))
                .andDo(print())
                .andExpect(status().isNoContent());
        assertFalse(repository.findById(VOTE1_ID).isPresent());
    }
}