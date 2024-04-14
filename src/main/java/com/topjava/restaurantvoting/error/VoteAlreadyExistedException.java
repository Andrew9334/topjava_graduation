package com.topjava.restaurantvoting.error;

import lombok.NonNull;

public class VoteAlreadyExistedException extends AppException {
    public VoteAlreadyExistedException(@NonNull String message) {
        super(message);
    }
}
