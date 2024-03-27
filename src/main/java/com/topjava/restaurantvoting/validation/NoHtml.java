package com.topjava.restaurantvoting.validation;

import jakarta.validation.Payload;

public @interface NoHtml {

    String message() default "{error.noHtml}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
