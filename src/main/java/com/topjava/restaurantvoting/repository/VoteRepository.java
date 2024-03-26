package com.topjava.restaurantvoting.repository;

import com.topjava.restaurantvoting.error.DataConflictException;
import com.topjava.restaurantvoting.model.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface VoteRepository extends BaseRepository<Vote> {

    @Query("SELECT v FROM Vote v JOIN FETCH v.user AND JOIN FETCH v.restaurant WHERE v.id=:id AND v.user.id=:userId AND v.restaurant.id=:restaurantId")
    Optional<Vote> getWithUserAndRestaurant(int id, int userId, int restaurantId);

    default Vote getBelonged(int id, int userId, int restaurantId) {
        return getWithUserAndRestaurant(id, userId, restaurantId).orElseThrow(
                () -> new DataConflictException("Entity id=" + id + "   is not exist or doesn't belong to User id=" ));
    }
}
