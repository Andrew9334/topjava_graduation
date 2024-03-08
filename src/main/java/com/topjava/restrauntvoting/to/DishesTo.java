package com.topjava.restrauntvoting.to;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDate;

@Value
@EqualsAndHashCode(callSuper = true)
public class DishesTo extends BaseTo {

    LocalDate date;

    String description;

    int price;

    public DishesTo(Integer id, LocalDate date, String description, int price) {
        super(id);
        this.date = date;
        this.description = description;
        this.price = price;
    }
}
