package com.topjava.restrauntvoting.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import com.topjava.restrauntvoting.HasIdAndEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Table(name = "menu", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "name"}, name = "dishes_unique_restaurant_datetime_idx")})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
public class Dish extends NamedEntity implements HasIdAndEmail {

    @Column(name = "date")
    @NotNull
    private LocalDateTime date;

    @Column(name = "description", nullable = false)
    @NotNull
    private String description;

    @Column(name = "price", nullable = false)
    @NotNull
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    public Dish(Integer id, String name, LocalDateTime date, String description, Integer price) {
        super(id, name);
        this.date = date;
        this.description = description;
        this.price = price;
    }

    @Schema(hidden = true)
    public LocalDateTime getDateTime() {
        return date;
    }


    @Override
    public String getEmail() {
        return getEmail();
    }
}
