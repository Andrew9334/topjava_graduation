package com.topjava.restaurantvoting.error;

import lombok.NonNull;

public class VoteTimeException extends AppException {

    public VoteTimeException(@NonNull String message) {
        super(message);
    }
}
