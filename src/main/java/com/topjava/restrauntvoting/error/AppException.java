package com.topjava.restrauntvoting.error;

import lombok.NonNull;

public class AppException extends RuntimeException {

    public AppException(@NonNull String message) {
        super(message);
    }
}
