package com.topjava.restaurantvoting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.topjava.restaurantvoting.HasId;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "vote")
@Getter
@Setter
@NoArgsConstructor()
@ToString(callSuper = true)
public class Vote extends BaseEntity implements HasId {

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    @Column(name = "created_date_time", nullable = false)
    private LocalDateTime createdDateTime;

    @Column(name = "updated_date_time", nullable = false)
    private LocalDateTime updatedDateTime;

    public Vote(Integer id, LocalDateTime updatedDateTime, User user, Restaurant restaurant) {
        super(id);
        this.updatedDateTime = updatedDateTime;
        this.user = user;
        this.restaurant = restaurant;
    }

    @Schema(hidden = true)
    public LocalDate getDate() {
        return updatedDateTime.toLocalDate();
    }

    @Schema(hidden = true)
    public LocalTime getTime() {
        return updatedDateTime.toLocalTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vote vote = (Vote) o;
        return Objects.equals(user, vote.user) && Objects.equals(restaurant, vote.restaurant) && Objects.equals(createdDateTime, vote.createdDateTime) && Objects.equals(updatedDateTime, vote.updatedDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user, restaurant, createdDateTime, updatedDateTime);
    }
}
