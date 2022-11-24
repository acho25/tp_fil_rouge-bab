package fr.univtln.bab.project.annotations;

import fr.univtln.bab.project.entities.Personne;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class PersonneValidator implements ConstraintValidator<PersonneValidation, Personne> {

    @Override
    public void initialize(PersonneValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(Personne personne, ConstraintValidatorContext constraintValidatorContext) {
        if (personne.getId() > 900) return false;
        if (personne.getPrenom().length() < 2 || personne.getNom().length() < 2) return false;
        return true;
    }
}
