package com.topjava.restaurantvoting.mapper;

import com.topjava.restaurantvoting.model.User;
import com.topjava.restaurantvoting.to.UserRequestTo;
import com.topjava.restaurantvoting.to.UserResponseTo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public UserRequestTo toRequest(User user) {
        return new UserRequestTo(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }

    public UserResponseTo toResponse(User user) {
        return new UserResponseTo(user.getId(), user.getName(), user.getEmail());
    }

    public User toEntity(UserRequestTo userRequestTo) {
        return new User(userRequestTo.getId(), userRequestTo.getName(), userRequestTo.getEmail(), null);
    }
}
