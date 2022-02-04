package java15_validation.lesson13_message_internationalization;

import jakarta.validation.*;
import java15_validation.lesson12_message_interpolation.OrderWithResourceBundle;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Set;

/**
 * Message Internationalization
 * <p>
 * - Secara default saat kita menggunakan Resource Bundle, Locale yang akan dipilih adalah Locale.getDefault()
 * - Jadi jika kita ingin mengubah Locale untuk Resource Bundle, kita harus mengubah default Locale nya
 */
public class MessageInternationalizationTest {

    @Test
    void messageInternationalization() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Locale.setDefault(new Locale("id", "ID"));

        Set<ConstraintViolation<OrderWithResourceBundle>> violations = validator.validate(new OrderWithResourceBundle());

        for (ConstraintViolation<OrderWithResourceBundle> violation : violations) {
            System.out.println(violation.getMessageTemplate());
            System.out.println(violation.getMessage());
        }
    }

    /**
     * MessageInterpolator
     * <p>
     * - Salah satu yang cara lumayan sulit, namun lebih flexible adalah menggunakan MessageInterpolator secara langsung
     * - Cara ini sangat flexible, tapi sangat sulit karena kita harus membuat context secara manual untuk
     * MessageInterpolator
     * - Kita tidak perlu mengubah Default Locale, hanya cukup  gunakan parameter Locale di Message Interpolator
     * - https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/messageinterpolator
     */
    @Test
    void messageInterpolator() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        MessageInterpolator messageInterpolator = validatorFactory.getMessageInterpolator();
        Locale.setDefault(new Locale("id", "ID"));

        Set<ConstraintViolation<OrderWithResourceBundle>> violations = validator.validate(new OrderWithResourceBundle());

        for (ConstraintViolation<OrderWithResourceBundle> violation : violations) {
            System.out.println(violation.getMessageTemplate());
            MessageInterpolator.Context messageInterpolatorContext = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(),
                    violation.getInvalidValue(),
                    violation.getRootBeanClass(),
                    violation.getPropertyPath(),
                    violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES,
                    true
            );
            System.out.println(messageInterpolator.interpolate(
                    violation.getMessageTemplate(),
                    messageInterpolatorContext,
                    new Locale("id", "ID")
            ));
        }
    }
}
