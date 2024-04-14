package com.topjava.restaurantvoting.mapper;

import com.topjava.restaurantvoting.model.Restaurant;
import com.topjava.restaurantvoting.model.Vote;
import com.topjava.restaurantvoting.to.VoteRequestTo;
import com.topjava.restaurantvoting.to.VoteResponseTo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VoteMapper {

    private final UserMapper userMapper;
    private final RestaurantMapper restaurantMapper;

    public VoteResponseTo toResponse(Vote vote) {
        VoteResponseTo dto = new VoteResponseTo();
        dto.setId(vote.getId());
        dto.setUser(userMapper.toResponse(vote.getUser()));
        dto.setRestaurant(restaurantMapper.toResponse(vote.getRestaurant()));
        dto.setCreatedDateTime(vote.getCreatedDateTime());
        dto.setUpdatedDateTime(vote.getUpdatedDateTime());
        return dto;
    }

    public Vote toEntity(VoteRequestTo request) {
        Vote dto = new Vote();
        Restaurant restaurant = new Restaurant();
        restaurant.setId(request.getRestaurantId());
        dto.setRestaurant(restaurant);
        return dto;
    }
}