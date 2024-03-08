package com.topjava.restrauntvoting.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "restaurant", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"}, name = "restaurant_unique_idx")})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant extends NamedEntity{

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    @OrderBy("name asc")
//    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Dishes> dishes;

    public Restaurant(Integer id, String name, List<Dishes> dishes) {
        super(id, name);
        this.dishes = dishes;
    }

    public List<Dishes> getDishes() {
        return dishes;
    }
}
