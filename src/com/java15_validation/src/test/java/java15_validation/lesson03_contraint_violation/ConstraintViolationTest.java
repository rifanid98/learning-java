package java15_validation.lesson03_contraint_violation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.*;

import java.util.Set;

/**
 * Constraint Violation
 *
 * - Setelah kita menambahkan annotation Constraint ke class yang akan kita validasi, selanjutnya kita bisa mulai
 *   melakukan validasi terhadap object class tersebut menggunakan method validate() milik class Validator
 * - Hasil kembalian dari method validate() adalah Set<ConstraintViolation>, dimana ConstraintViolation tersebut
 *   merupakan representasi kesalaha dari constraint
 * - Jika terdapat kesalahan, otomatis terdapat ConstraintViolation, namun jika tidak ada kesalahan, maka tidak akan
 *   terdapat ConstraintViolation, alias Set nya akan berisi data kosong
 * - https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraintviolation
 */
public class ConstraintViolationTest {

    private ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void constraintViolation() {
        Person person = new Person();
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        Assertions.assertEquals(2, constraintViolations.size());

        for (ConstraintViolation<Person> constraintViolation : constraintViolations) {
            System.out.println(constraintViolation.getMessage());
        }
    }

    /**
     * Object Metadata
     *
     * - Jika kita perhatikan, pada Constraint Violation, tidak hanya message error yang bisa kita lihat, kita juga bisa
     *   melihat field mana yang error, dari object mana, dan lain-lain
     * - Ini sangat bagus ketika kita ingin melakukan debugging field mana yang error
     */
    @Test
    void objectMetadata() {
        Person person = new Person();
        Set<ConstraintViolation<Person>> constraintViolations = validator.validate(person);
        Assertions.assertEquals(2, constraintViolations.size());

        for (ConstraintViolation<Person> constraintViolation : constraintViolations) {
            System.out.println("Message :" + constraintViolation.getMessage());
            System.out.println("LeafBean :" + constraintViolation.getLeafBean());
            System.out.println("ConstraintDescriptor :" + constraintViolation.getConstraintDescriptor().getAnnotation());
            System.out.println("InvalidValue :" + constraintViolation.getInvalidValue());
            constraintViolation.getPropertyPath().forEach(node -> System.out.println(node.getName()));
        }
    }
}
