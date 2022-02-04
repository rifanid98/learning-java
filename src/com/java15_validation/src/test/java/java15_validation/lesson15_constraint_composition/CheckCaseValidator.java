package java15_validation.lesson15_constraint_composition;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation.mode();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }

        switch (caseMode) {
            case UPPER -> {
                return value.equals(value.toUpperCase());
            }
            case LOWER -> {
                return value.equals(value.toLowerCase());
            }
        }

        return false;
    }
}
