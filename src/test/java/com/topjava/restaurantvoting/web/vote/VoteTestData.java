package com.topjava.restaurantvoting.web.vote;

import com.topjava.restaurantvoting.MatcherFactory;
import com.topjava.restaurantvoting.model.Restaurant;
import com.topjava.restaurantvoting.model.Vote;

import java.time.LocalDateTime;
import java.util.List;

import static com.topjava.restaurantvoting.web.restaurant.RestaurantTestData.*;
import static com.topjava.restaurantvoting.web.user.UserTestData.*;

public class VoteTestData {

    public static final MatcherFactory.Matcher<Vote> VOTE_MATCHER = MatcherFactory.usingEqualsComparator(Vote.class);

    public static final int VOTE1_ID = 1;
    public static final int VOTE2_ID = 2;
    public static final int VOTE3_ID = 3;

    public static final Vote VOTE1 = new Vote(VOTE1_ID, LocalDateTime.now(), user, REST1);
    public static final Vote VOTE2 = new Vote(VOTE2_ID, LocalDateTime.now(), user, REST2);
    public static final Vote VOTE3 = new Vote(VOTE3_ID, LocalDateTime.now(), user, REST3);

    public static final List<Vote> VOTES = List.of(VOTE1, VOTE2, VOTE3);

    public static Vote getNew() {
        return new Vote(null, LocalDateTime.now(), null, null);
    }

    public static Vote getUpdated() {
        return new Vote(VOTE1_ID, LocalDateTime.now(), admin, REST3);
    }
}
