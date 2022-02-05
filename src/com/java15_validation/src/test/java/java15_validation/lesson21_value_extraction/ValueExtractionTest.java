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

    /**
     * Multiple Generic Parameter Type
     *
     * - Secara default, saat kita membuat Value Extractor, annotation @ExtractedValue hanya bisa digunakan satu kali
     * - Oleh karena itu, jika kita membuat container class generic yang menggunakan lebih dari satu generic parameter
     *   type, maka kita harus membuat Value Extractor nya sebanyak jumlah generic parameter type nya
     */
    @Test
    void multipleGenericParameterType() {
        ValidatorFactory validatorFactory = Validation.byDefaultProvider()
                .configure()
                .addValueExtractor(new EntryValueExtractorKey())
                .addValueExtractor(new EntryValueExtractorValue())
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        SampleEntry sampleEntry = new SampleEntry();
        sampleEntry.setEntry(new Entry<>());

        Set<ConstraintViolation<SampleEntry>> violations = validator.validate(sampleEntry);

        for (ConstraintViolation<SampleEntry> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("=================");
        }
    }

    /**
     * Container Non Generic
     *
     * - Rata-rata, biasanya data container itu adalah class generic, namun beberapa kasus mungkin ada juga container
     *   yang bukan tipe generic
     * - Bagaimana untuk menangani hal ini? Untuk menangani hal ini, kita tetap bisa menggunakan @ExtractedValue, namun
     *   kita perlu memberi tahu tipe data nilai dari container nya
     */
    @Test
    void containerNonGeneric() {
        ValidatorFactory validatorFactory = Validation.byDefaultProvider()
                .configure()
                .addValueExtractor(new DataIntegerValueExtractor())
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        SampleDataInteger sampleDataInteger = new SampleDataInteger();
        sampleDataInteger.setData(new DataInteger());
        sampleDataInteger.getData().setData(1);

        Set<ConstraintViolation<SampleDataInteger>> violations = validator.validate(sampleDataInteger);

        for (ConstraintViolation<SampleDataInteger> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("=================");
        }
    }
}
