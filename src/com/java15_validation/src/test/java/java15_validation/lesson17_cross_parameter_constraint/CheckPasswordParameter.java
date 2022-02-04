package java15_validation.lesson17_cross_parameter_constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckPasswordParameterValidator.class})
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPasswordParameter {

    int passwordParam();

    int retypePasswordParam();

    String message() default "password must same with retypePassword";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
