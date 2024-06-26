package com.topjava.restaurantvoting.web.user;

import com.topjava.restaurantvoting.AbstractControllerTest;
import com.topjava.restaurantvoting.model.User;
import com.topjava.restaurantvoting.repository.UserRepository;
import com.topjava.restaurantvoting.to.UserRequestTo;
import com.topjava.restaurantvoting.util.JsonUtil;
import com.topjava.restaurantvoting.util.UsersUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.topjava.restaurantvoting.web.user.ProfileController.REST_URL;
import static com.topjava.restaurantvoting.web.user.UserTestData.*;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProfileControllerTest extends AbstractControllerTest {

    @Autowired
    private UserRepository repository;

    @Test
    @WithUserDetails(value = USER_MAIL)
    void get() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(USER_MATCHER.contentJson(user));
    }

    @Test
    void getUnAuth() throws Exception {
        perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void register() throws Exception {
        UserRequestTo newTo = new UserRequestTo(null, "newName", "newemail@ya.ru", "newPassword");
        User newUser = UsersUtil.createNewFromTo(newTo);
        ResultActions action = perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newTo)))
                .andDo(print())
                .andExpect(status().isCreated());

        User created = USER_MATCHER.readFromJson(action);
        int newId = created.id();
        newUser.setId(newId);
        USER_MATCHER.assertMatch(created, newUser);
        USER_MATCHER.assertMatch(repository.getExisted(newId), newUser);
    }

    @Test
    @WithUserDetails(value = USER_MAIL)
    void update() throws Exception {
        UserRequestTo updatedTo = new UserRequestTo(null, "newName", USER_MAIL, "newPassword");
        perform(MockMvcRequestBuilders.put(REST_URL).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updatedTo)))
                .andDo(print())
                .andExpect(status().isNoContent());

        USER_MATCHER.assertMatch(repository.getExisted(USER_ID), UsersUtil.updateFromTo(new User(user), updatedTo));
    }

    @Test
    void registerInvalid() throws Exception {
        UserRequestTo newTo = new UserRequestTo(null, null, null, null);
        perform(MockMvcRequestBuilders.post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(newTo)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

//    @Test
//    @WithUserDetails(value = USER_MAIL)
//    void updateInvalid() throws Exception {
//        UserTo updatedTo = new UserTo(null, null, "password", null);
//        perform(MockMvcRequestBuilders.put(REST_URL)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(JsonUtil.writeValue(updatedTo)))
//                .andDo(print())
//                .andExpect(status().isUnprocessableEntity());
//    }

    @Test
    @WithUserDetails(value = USER_MAIL)
    void updateDuplicate() throws Exception {
        UserRequestTo updatedTo = new UserRequestTo(null, "newName", ADMIN_MAIL, "newPassword");
        perform(MockMvcRequestBuilders.put(REST_URL).contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updatedTo)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andExpect(content().string(containsString(UniqueMailValidator.EXCEPTION_DUPLICATE_EMAIL)));
    }
}