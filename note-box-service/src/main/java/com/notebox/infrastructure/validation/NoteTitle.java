package com.notebox.infrastructure.validation;

import com.notebox.infrastructure.validation.validator.NoteTitleValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Constraint(validatedBy = NoteTitleValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoteTitle {
    String message() default "Not allowed title (title shouldn't contain special characters and numbers)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
