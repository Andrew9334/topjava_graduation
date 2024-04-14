package com.topjava.restaurantvoting.util;

import com.topjava.restaurantvoting.model.Role;
import com.topjava.restaurantvoting.model.User;
import com.topjava.restaurantvoting.to.UserRequestTo;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsersUtil {

    public static User createNewFromTo(UserRequestTo userRequestTo) {
        return new User(null, userRequestTo.getName(), userRequestTo.getEmail().toLowerCase(), userRequestTo.getPassword(), Role.USER);
    }

    public static User updateFromTo(User user, UserRequestTo userRequestTo) {
        user.setName(userRequestTo.getName());
        user.setEmail(userRequestTo.getEmail().toLowerCase());
        user.setPassword(userRequestTo.getPassword());
        return user;
    }
}
