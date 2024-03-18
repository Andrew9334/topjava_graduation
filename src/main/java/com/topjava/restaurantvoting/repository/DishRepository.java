package com.topjava.restaurantvoting.repository;

import com.topjava.restaurantvoting.error.DataConflictException;
import com.topjava.restaurantvoting.model.Dish;
import com.topjava.restaurantvoting.to.DishesTo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface DishRepository extends BaseRepository<Dish> {

//    @Query("SELECT d FROM Dish d WHERE d.restaurant.id=:restaurantId ORDER BY d.date DESC")
//    List<DishesTo> getAll();


    @Query("SELECT d FROM Dish d WHERE d.id=:id AND d.restaurant.id=:restaurantId")
    Optional<Dish> get(int restaurantId, int id);

    @Query("SELECT d FROM Dish d JOIN FETCH d.restaurant WHERE d.id=:id and d.restaurant.id=:restaurantId")
    Optional<Dish> getWithRestaurant(int id, int restaurantId);



    default Dish getBelonged(int restaurantId, int id) {
        return get(restaurantId, id).orElseThrow(
                () -> new DataConflictException("Dish id=" + id + "   is not exist or doesn't belong to Restaurant id=" + restaurantId));
    }
}
