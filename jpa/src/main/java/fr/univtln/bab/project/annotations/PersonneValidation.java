package fr.univtln.bab.project.annotations;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PersonneValidator.class)
@Documented
public @interface PersonneValidation {
    String message() default "{org.hibernate.validator.constraints.PersonneValidation.message}";
    Class<?> [] groups() default {};
    Class<?>[] payload() default {};
}
