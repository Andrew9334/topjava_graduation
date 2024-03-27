package com.topjava.restaurantvoting.repository;

import com.topjava.restaurantvoting.error.DataConflictException;
import com.topjava.restaurantvoting.model.Vote;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VoteRepository extends BaseRepository<Vote> {

    @Query("SELECT v FROM Vote v WHERE v.id=:voteId ORDER BY v.dateTime DESC")
    List<Vote> getAll(int voteId);

    @Query("SELECT v FROM Vote v WHERE v.id=:id AND v.user.id=:userId")
    Optional<Vote> get(int userId, int id);

    @Query("SELECT v FROM Vote v JOIN FETCH v.user WHERE v.id=:id AND v.user.id=:userId")
    Optional<Vote> getWithUser(int userId, int id);

    @Query("SELECT v FROM Vote v JOIN FETCH v.user AND JOIN FETCH v.restaurant WHERE v.id=:id AND v.user.id=:userId AND v.restaurant.id=:restaurantId")
    Optional<Vote> getWithUserAndRestaurant(int id, int userId, int restaurantId);

    default Vote getBelonged(int userId, int id) {
        return get(userId, id).orElseThrow(
                () -> new DataConflictException("Meal id=" + id + "   is not exist or doesn't belong to User id=" + userId));
    }
}
