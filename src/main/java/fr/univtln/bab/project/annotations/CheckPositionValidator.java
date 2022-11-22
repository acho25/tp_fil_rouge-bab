package fr.univtln.bab.project.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckPositionValidator implements ConstraintValidator<CheckPosition, String> {
    @Override
    public void initialize(CheckPosition constraintAnnotation) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return false;
        for (PostionMode p:PostionMode.values()) {
            return p.toString().equals(s);
        }
        return false;
    }
}
