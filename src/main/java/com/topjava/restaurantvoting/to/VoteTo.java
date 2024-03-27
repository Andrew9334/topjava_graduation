package com.topjava.restaurantvoting.to;

import com.topjava.restaurantvoting.model.Restaurant;
import com.topjava.restaurantvoting.model.User;

import java.time.LocalDateTime;

public class VoteTo extends BaseTo {

    LocalDateTime localDateTime;

    User user;

    Restaurant restaurant;

    public VoteTo(Integer id, LocalDateTime localDateTime, User user, Restaurant restaurant) {
        super(id);
        this.localDateTime = localDateTime;
        this.user = user;
        this.restaurant = restaurant;
    }
}
