package com.topjava.restaurantvoting.to;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDate;

@Value
@EqualsAndHashCode(callSuper = true)
public class DishTo extends BaseTo {

    LocalDate date;

    int price;

    public DishTo(Integer id, LocalDate date, int price) {
        super(id);
        this.date = date;
        this.price = price;
    }
}
