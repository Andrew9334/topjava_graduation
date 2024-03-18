package com.topjava.restaurantvoting.to;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
@EqualsAndHashCode(callSuper = true)
public class DishesTo extends BaseTo {

    LocalDate date;

    int price;

    public DishesTo(Integer id, LocalDate date, int price) {
        super(id);
        this.date = date;
        this.price = price;
    }
}
