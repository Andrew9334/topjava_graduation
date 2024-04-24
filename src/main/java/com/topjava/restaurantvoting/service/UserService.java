package com.topjava.restaurantvoting.service;

import com.topjava.restaurantvoting.error.UserNotFoundException;
import com.topjava.restaurantvoting.model.User;
import com.topjava.restaurantvoting.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public User getUserByEmail(String email) {
        User user = userRepository.getExistedByEmail(email);
        if (Objects.isNull(user)) {
            throw new UserNotFoundException(String.format("User '%s' is not found", email));
        }
        return userRepository.getExistedByEmail(email);
    }

    public User getById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User '%s' is not found", userId)));
    }
}
