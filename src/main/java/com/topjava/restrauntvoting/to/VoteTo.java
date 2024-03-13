package com.topjava.restrauntvoting.to;

import com.topjava.restrauntvoting.model.Restaurant;
import com.topjava.restrauntvoting.model.User;

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
