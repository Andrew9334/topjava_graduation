package com.topjava.restaurantvoting.model;

import com.topjava.restaurantvoting.validation.NoHtml;
import com.topjava.restaurantvoting.validation.NoHtmlValidator;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NamedEntity extends BaseEntity {

    @NotBlank
    @Size(min = 2, max = 120)
    @Column(name = "name", nullable = false)
    @NoHtml
    protected String name;

    public NamedEntity(Integer id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + '[' + name + ']';
    }
}

