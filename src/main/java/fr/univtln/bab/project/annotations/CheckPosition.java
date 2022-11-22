package fr.univtln.bab.project.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.List;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckPositionValidator.class)
@Documented
public @interface CheckPosition {
    String message() default "Position saisie est non valide\n";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
