package com.topjava.restaurantvoting.error;

import lombok.NonNull;

public class UserNotFoundException extends AppException {
    public UserNotFoundException(@NonNull String message) {
        super(message);
    }
}
