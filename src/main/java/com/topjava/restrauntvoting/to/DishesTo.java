package com.topjava.restrauntvoting.to;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
@EqualsAndHashCode(callSuper = true)
public class DishesTo extends BaseTo {

    LocalDateTime date;

    String description;

    int price;

    public DishesTo(Integer id, LocalDateTime date, String description, int price) {
        super(id);
        this.date = date;
        this.description = description;
        this.price = price;
    }
}
