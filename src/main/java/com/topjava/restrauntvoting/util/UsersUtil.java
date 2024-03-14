package com.topjava.restrauntvoting.util;

import com.topjava.restrauntvoting.model.Role;
import com.topjava.restrauntvoting.model.User;
import com.topjava.restrauntvoting.to.UserTo;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsersUtil {
    public static final int DEFAULT_CALORIES_PER_DAY = 2000;

    public static User createNewFromTo(UserTo userTo) {
        return new User(null, userTo.getName(), userTo.getEmail().toLowerCase(), userTo.getPassword(), Role.USER);
    }

    public static User updateFromTo(User user, UserTo userTo) {
        user.setName(userTo.getName());
        user.setEmail(userTo.getEmail().toLowerCase());
        user.setPassword(userTo.getPassword());
        return user;
    }
}
