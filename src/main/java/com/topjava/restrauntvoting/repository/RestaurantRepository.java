package com.topjava.restrauntvoting.repository;

import com.topjava.restrauntvoting.model.Restaurant;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface RestaurantRepository extends BaseRepository<Restaurant> {
}
