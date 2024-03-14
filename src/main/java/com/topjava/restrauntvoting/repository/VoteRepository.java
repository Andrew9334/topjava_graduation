package com.topjava.restrauntvoting.repository;

import com.topjava.restrauntvoting.error.DataConflictException;
import com.topjava.restrauntvoting.model.Vote;
import com.topjava.restrauntvoting.to.VoteTo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface VoteRepository extends BaseRepository<Vote> {

    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId ORDER BY v.dateTime DESC")
    List<VoteTo> getAll(int userId);

    @Query("SELECT v FROM Vote v WHERE v.id=:id AND v.user.id=:userId")
    Optional<Vote> get(int userId, int id);

    @Query("SELECT v FROM Vote v JOIN FETCH v.user WHERE v.id=:id AND v.user.id=:userId")
    Optional<Vote> getWithUser(int userId, int id);

    @Query("SELECT v FROM Vote v JOIN FETCH v.user AND JOIN FETCH v.restaurant WHERE v.id=:id AND v.user.id=:userId AND v.restaurant.id=:restaurantId")
    Optional<Vote> getWithUserAndRestaurant(int id, int userId, int restaurantId);

    default Vote getBelonged(int userId, int restaurantId, int id) {
        return get(userId,  id).orElseThrow(
                () -> new DataConflictException("Entity id=" + id + "   is not exist or doesn't belong to User id=" + userId));
    }
}
