package com.topjava.topjavarestrauntvoting.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "restaurant", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "restaurant_unique_idx")})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant extends NamedEntity{

    @OneToMany(fetch = FetchType.LAZY)
    private List<Menu> menus;

    public Restaurant(Integer id, String name, List<Menu> menus) {
        super(id, name);
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
