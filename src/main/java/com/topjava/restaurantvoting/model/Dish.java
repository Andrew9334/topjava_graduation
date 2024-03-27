package com.topjava.restaurantvoting.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import com.topjava.restaurantvoting.HasIdAndEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "dish", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "name"}, name = "dishes_unique_restaurant_datetime_idx")})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
public class Dish extends NamedEntity implements HasIdAndEmail {

    @Column(name = "date")
    @NotNull
    private LocalDate date = LocalDate.now();

    @Column(name = "price", nullable = false)
    @NotNull
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    public Dish(Integer id, String name, LocalDate date, Integer price) {
        super(id, name);
        this.date = date;
        this.price = price;
    }

    public Dish(Integer id, String name, LocalDate date, Integer price, Restaurant restaurant) {
        super(id, name);
        this.date = date;
        this.price = price;
        this.restaurant = restaurant;
    }

    @Schema(hidden = true)
    public LocalDate getDate() {
        return date;
    }


    @Override
    public String getEmail() {
        return getEmail();
    }
}
