package com.notebox.infrastructure.validation.validator;

import com.notebox.infrastructure.validation.NoteTitle;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class NoteTitleValidator implements ConstraintValidator<NoteTitle, String> {
    private final String titleRegex = "^[A-Za-z]+$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(titleRegex);
        return pattern.matcher(value).matches();
    }
}
