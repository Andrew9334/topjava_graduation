package com.topjava.restaurantvoting.web.vote;

import com.topjava.restaurantvoting.MatcherFactory;
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

    public static final Vote vote1 = new Vote(VOTE1_ID, LocalDateTime.now(), user, rest1);
    public static final Vote vote2 = new Vote(VOTE2_ID, LocalDateTime.now(), user, rest2);
    public static final Vote vote3 = new Vote(VOTE3_ID, LocalDateTime.now(), user, rest3);

    public static final List<Vote> VOTES = List.of(vote1, vote2, vote3);

    public static Vote getNew() {
        return new Vote(null, LocalDateTime.of(2024, 04, 15, 10, 00), null, null);
    }

    public static Vote getUpdated() {
        return new Vote(VOTE1_ID, LocalDateTime.now(), admin, rest3);
    }
}
