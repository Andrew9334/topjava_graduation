package com.topjava.restaurantvoting.repository;

import com.topjava.restaurantvoting.error.DataConflictException;
import com.topjava.restaurantvoting.model.Dishes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface DishesRepository extends BaseRepository<Dishes> {

    @Query("SELECT d FROM Dishes d WHERE d.restaurant.id=:restaurantId ORDER BY d.date DESC")
    List<Dishes> getAll(int restaurantId);

    @Query("SELECT d FROM Dishes d WHERE d.id =: id")
    Optional<Dishes> get(int restaurantId, int id);

    @Query("SELECT d FROM Dishes d JOIN FETCH d.restaurant WHERE d.id =: id and d.restaurant.id =: restaurantId")
    Optional<Dishes> getWithRestaurant(int id, int restaurantId);

    default Dishes getBelonged(int restaurantId, int id) {
        return get(restaurantId, id).orElseThrow(
                () -> new DataConflictException("Dish id=" + id + "   is not exist or doesn't belong to Restaurant id=" + restaurantId));
    }
}
