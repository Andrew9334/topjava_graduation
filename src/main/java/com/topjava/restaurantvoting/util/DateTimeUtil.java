package com.topjava.restaurantvoting.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class DateTimeUtil {

    public static boolean limitTimeForVoting(LocalDateTime currentDateTime, LocalDateTime createdDateTime) {
        LocalDateTime limitDateTime = LocalDateTime.of(
                currentDateTime.getYear(),
                currentDateTime.getMonth(),
                createdDateTime.getDayOfMonth() + 1,
                11,
                0
        );
        return currentDateTime.isBefore(limitDateTime);
    }
}