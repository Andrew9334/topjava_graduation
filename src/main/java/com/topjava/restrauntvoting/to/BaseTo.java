package com.topjava.restrauntvoting.to;

import com.topjava.restrauntvoting.HasId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class BaseTo implements HasId {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    protected Integer id;

    public String toString() {
        return getClass().getSimpleName() + ":" + id;
    }
}