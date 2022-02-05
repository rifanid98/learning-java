package java15_validation.lesson21_value_extraction;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * Value Extraction
 *
 * - Value Extraction merupakan proses melakukan ekstraksi nilai dari data jenis container (kumpulan data), sehingga
 *   nilai-nilai nya bisa di validasi
 * - Sebelumnya sudah dijelaskan bahwa secara default Bean Validation mendukung value extraction terdapat data container
 *   yang ada di Java
 * - Bagaimana jika kita misal menggunakan data container sendiri atau misal menggunakan library bukan bawaan Java? Maka
 *   secara otomatis Bean Validation tidak bisa melakukan ekstraksi nilai yang terdapat di container, perlu kita lakukan secara manual
 * - Cara untuk memberi tahu Bean Validation cara melakukan ekstraksi, adalah dengan cara membuat ValueExtractor sendiri
 * - https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/valueextraction/valueextractor
 */
public class ValueExtractionTest {

    @Test
    void valueExtraction() {
        ValidatorFactory validatorFactory = Validation.byDefaultProvider()
                .configure()
                .addValueExtractor(new DataValueExtractor())
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        SampleData sampleData = new SampleData();
        sampleData.setData(new Data<>());

        Set<ConstraintViolation<SampleData>> violations = validator.validate(sampleData);

        for (ConstraintViolation<SampleData> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("=================");
        }

    }
}
