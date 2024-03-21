package com.topjava.restaurantvoting.repository;

import com.topjava.restaurantvoting.error.DataConflictException;
import com.topjava.restaurantvoting.model.Vote;
import com.topjava.restaurantvoting.to.VoteTo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface VoteRepository extends BaseRepository<Vote> {

//    @Query("SELECT v FROM Vote v WHERE v.restaurant.id=:restaurantId ORDER BY v.dateTime DESC")
//    List<VoteTo> getAll(int restaurantId);

    @Query("SELECT v FROM Vote v WHERE v.id=:id AND v.restaurant.id=:restaurantId")
    Optional<Vote> get(int id, int restaurantId);

    @Query("SELECT v FROM Vote v JOIN FETCH v.user WHERE v.id=:id AND v.user.id=:userId")
    Optional<Vote> getWithUser(int userId, int id);

    @Query("SELECT v FROM Vote v JOIN FETCH v.user AND JOIN FETCH v.restaurant WHERE v.id=:id AND v.user.id=:userId AND v.restaurant.id=:restaurantId")
    Optional<Vote> getWithUserAndRestaurant(int id, int userId, int restaurantId);

    default Vote getBelonged(int id, int restaurantId) {
        return get(id, restaurantId).orElseThrow(
                () -> new DataConflictException("Entity id=" + id + "   is not exist or doesn't belong to User id=" ));
    }
}
