package java15_validation.lesson05_hibernate_validator_constraint;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Hibernate Validator Constraint
 *
 * - Selain Annotation Constraint yang terdapat di Bean Validation
 * - Hibernate Validator juga menyediakan Constraint tambahan
 * - Kita bisa melihat nya di package org.hibernate.validator.constraints
 * - https://docs.jboss.org/hibernate/stable/validator/api/org/hibernate/validator/constraints/package-summary.html
 */
public class HibernateValidatorConstraintTest {

    @Test
    void hibernateValidatorConstraint() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Payment payment = new Payment();
        payment.setCreditCard("wrong");

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);

        for (ConstraintViolation<Payment> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getLeafBean());
            System.out.println(violation.getConstraintDescriptor().getAnnotation());
            System.out.println(violation.getInvalidValue());
            violation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
        }
    }
}
