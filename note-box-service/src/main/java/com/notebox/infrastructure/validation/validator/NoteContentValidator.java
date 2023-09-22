package com.notebox.infrastructure.validation.validator;

import com.notebox.infrastructure.validation.NoteContent;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class NoteContentValidator implements ConstraintValidator<NoteContent, String> {
    private final String contentRegex = "^[A-Za-z0-9\\s]+$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile(contentRegex);
        return pattern.matcher(value).matches();
    }
}
