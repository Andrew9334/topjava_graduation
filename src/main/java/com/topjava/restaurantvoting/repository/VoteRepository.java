package com.topjava.restaurantvoting.repository;

import com.topjava.restaurantvoting.error.DataConflictException;
import com.topjava.restaurantvoting.model.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface VoteRepository extends BaseRepository<Vote> {

    @Query("SELECT v FROM Vote v JOIN FETCH v.user AND JOIN FETCH v.restaurant WHERE v.id=:id AND v.restaurant.id=:restaurantId")
    Optional<Vote> getWithRestaurant(int id, int restaurantId);

    boolean existsByUserIdAndRestaurantId(int userId, int restaurantId);

    default Vote getBelonged(int id, int restaurantId) {
        return getWithRestaurant(id, restaurantId).orElseThrow(
                () -> new DataConflictException("Entity id=" + id + "   is not exist or doesn't belong to User id="));
    }

    boolean existsByUserId(Integer userId);

    List<Vote> findAllByUserId(Integer userId);
}
