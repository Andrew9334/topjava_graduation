package com.topjava.restaurantvoting.to;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDate;

@Value
@EqualsAndHashCode(callSuper = true)
public class DishTo extends BaseTo {

    private String name;

    private LocalDate date;

    private int price;

    public DishTo(Integer id, String name, LocalDate date, int price) {
        super(id);
        this.name = name;
        this.date = date;
        this.price = price;
    }
}
