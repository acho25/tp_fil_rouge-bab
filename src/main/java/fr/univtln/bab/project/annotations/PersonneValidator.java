package fr.univtln.bab.project.annotations;

import fr.univtln.bab.project.entities.Personne;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class PersonneValidator implements ConstraintValidator<PersonneValidation, Personne> {

    @Override
    public void initialize(PersonneValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(Personne personne, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.equals(personne.getPrenom(), personne.getNom())) return false;
        return true;
    }
}
