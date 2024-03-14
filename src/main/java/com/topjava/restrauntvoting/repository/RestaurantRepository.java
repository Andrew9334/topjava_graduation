package com.topjava.restrauntvoting.repository;

import com.topjava.restrauntvoting.error.DataConflictException;
import com.topjava.restrauntvoting.model.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface RestaurantRepository extends BaseRepository<Restaurant> {

    @Query("SELECT r FROM Restaurant r WHERE r.id=:id")
    Optional<Restaurant> get(int id);

    @Query("SELECT r FROM Restaurant r WHERE r.id=:id")
    List<Restaurant> getAll(int id);

    @Query("SELECT r FROM Restaurant r LEFT JOIN FETCH r.dishes WHERE r.id=?1")
    Optional<Restaurant> getWithDish(int id);
}
