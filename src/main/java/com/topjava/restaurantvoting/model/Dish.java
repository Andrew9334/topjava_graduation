package com.topjava.restaurantvoting.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.topjava.restaurantvoting.HasId;
import com.topjava.restaurantvoting.validation.NoHtmlValidator;
import io.swagger.v3.oas.annotations.media.Schema;
import com.topjava.restaurantvoting.HasIdAndEmail;
import jakarta.persistence.*;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.LocalDate;

@Entity
@Table(name = "dish")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
//@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = NoHtmlValidator.class)
public class Dish extends NamedEntity implements HasId {

    @Column(name = "local_date")
    @NotNull
    private LocalDate date = LocalDate.now();

    @Column(name = "price", nullable = false)
    @NotNull
    private Integer price;

    @ManyToOne(fetch = FetchType.EAGER)
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
}
