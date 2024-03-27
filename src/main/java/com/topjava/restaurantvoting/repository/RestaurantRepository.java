package com.topjava.restaurantvoting.repository;

import com.topjava.restaurantvoting.model.Restaurant;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface RestaurantRepository extends BaseRepository<Restaurant> {
}
