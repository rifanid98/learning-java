package java15_validation.lesson16_class_level_constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CheckPasswordValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPassword {

    String message() default "password must same with retypePassword";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
