package com.topjava.restaurantvoting.to;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VoteResponseTo {

    private int id;

    private UserResponseTo user;

    private RestaurantResponseTo restaurant;

    private LocalDateTime createdDateTime;

    private LocalDateTime updatedDateTime;
}
