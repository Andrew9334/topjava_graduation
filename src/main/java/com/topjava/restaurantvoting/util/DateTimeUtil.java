package com.topjava.restaurantvoting.util;

import lombok.experimental.UtilityClass;

import java.time.LocalTime;

@UtilityClass
public class DateTimeUtil {

    public static final LocalTime LIMIT_TIME = LocalTime.of(11, 0);

    public static LocalTime limitTimeForVoting(LocalTime localTime) {
        return localTime != null && !localTime.equals(LIMIT_TIME) ? LocalTime.now() : LIMIT_TIME;
    }
}