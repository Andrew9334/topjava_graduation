package com.topjava.restaurantvoting.error;

import lombok.NonNull;

public class UserCannotChangeVoteException extends AppException {
    public UserCannotChangeVoteException(@NonNull String message) {
        super(message);
    }
}
