package com.topjava.restaurantvoting.repository;

import com.topjava.restaurantvoting.model.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface RestaurantRepository extends BaseRepository<Restaurant> {

    @Query("SELECT r FROM Restaurant r WHERE r.id=:id")
    Optional<Restaurant> get(int id);

    @Query("SELECT r FROM Restaurant r WHERE r.id=:restaurantId")
    List<Restaurant> getAll(int restaurantId);

//    @Query("SELECT r FROM Restaurant r LEFT JOIN FETCH r.dishes WHERE r.id=?1")
//    Optional<Restaurant> getWithDish(int id);
}
