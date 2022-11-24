package fr.univtln.bab.project.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.util.List;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckPositionValidator.class)
@Documented
public @interface CheckPosition {
    String message() default "{org.hibernate.validator.constraints.CheckPosition.message}";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
