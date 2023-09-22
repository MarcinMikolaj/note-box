package com.notebox.infrastructure.validation;

import com.notebox.infrastructure.validation.validator.NoteContentValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Constraint(validatedBy = NoteContentValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoteContent {
    String message() default "Not allowed content";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
