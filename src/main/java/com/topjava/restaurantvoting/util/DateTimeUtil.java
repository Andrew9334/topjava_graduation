package com.topjava.restaurantvoting.util;

import lombok.experimental.UtilityClass;

import java.time.LocalTime;

@UtilityClass
public class DateTimeUtil {

    private static final LocalTime CURRENT_DATE_TIME = LocalTime.of(11, 0);

    public static LocalTime limitTimeForVoting(LocalTime localTime) {
        return localTime != null && !localTime.equals(CURRENT_DATE_TIME) ? LocalTime.now() : CURRENT_DATE_TIME;
    }
}