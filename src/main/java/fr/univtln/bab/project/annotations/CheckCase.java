package fr.univtln.bab.project.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckCaseValidator.class)
@Documented
public @interface CheckCase {
    String message() default "Modifier le format du texte saisi";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
    CaseMode value();
}
