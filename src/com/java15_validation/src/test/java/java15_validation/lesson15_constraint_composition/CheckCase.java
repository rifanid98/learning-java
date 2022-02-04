package java15_validation.lesson15_constraint_composition;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckCaseValidator.class})
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {

    CaseMode mode();

    String message() default "value is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
