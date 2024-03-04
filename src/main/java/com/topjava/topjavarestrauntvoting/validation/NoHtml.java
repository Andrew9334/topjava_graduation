package com.topjava.topjavarestrauntvoting.validation;

import jakarta.validation.Payload;

public @interface NoHtml {

    String message() default "{error.noHtml}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
