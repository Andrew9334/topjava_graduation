package com.topjava.restaurantvoting.error;

import lombok.NonNull;

public class AppException extends RuntimeException {

    public AppException(@NonNull String message) {
        super(message);
    }
}
