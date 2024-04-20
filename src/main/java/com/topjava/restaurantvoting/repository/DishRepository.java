package com.topjava.restaurantvoting.repository;

import com.topjava.restaurantvoting.error.DataConflictException;
import com.topjava.restaurantvoting.model.Dish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface DishRepository extends BaseRepository<Dish> {

    @Query("SELECT d FROM Dish d WHERE d.id=:id AND d.restaurant.id=:restaurantId")
    Optional<Dish> get(int restaurantId, int id);

    @Query("SELECT d FROM Dish d WHERE d.restaurant.id=:restaurantId AND d.date=:date")
    List<Dish> getAllByRestaurantIdAndLocalDate(int restaurantId, LocalDate date);

    default Dish getBelonged(int restaurantId, int id) {
        return get(restaurantId, id).orElseThrow(
                () -> new DataConflictException("Dish id=" + id + "   is not exist or doesn't belong to Restaurant id=" + restaurantId));
    }
}
