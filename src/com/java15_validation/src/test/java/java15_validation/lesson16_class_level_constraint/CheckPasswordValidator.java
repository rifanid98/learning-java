package java15_validation.lesson16_class_level_constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {
    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Register register, ConstraintValidatorContext constraintValidatorContext) {
        if (register.getPassword() == null || register.getRetypePassword() == null) {
            return true;
        }

        return register.getPassword().equals(register.getRetypePassword());
    }
}
