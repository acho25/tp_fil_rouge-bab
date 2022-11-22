package fr.univtln.bab.project.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckCaseValidator.class)
@Documented
public @interface CheckCase {
    String message() default "Modifier le format du texte saisi\n";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
    CaseMode value();
}
