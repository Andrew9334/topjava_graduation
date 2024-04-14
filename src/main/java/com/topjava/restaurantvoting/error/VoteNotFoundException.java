package com.topjava.restaurantvoting.error;

import lombok.NonNull;

public class VoteNotFoundException extends AppException {
    public VoteNotFoundException(@NonNull String message) {
        super(message);
    }
}
