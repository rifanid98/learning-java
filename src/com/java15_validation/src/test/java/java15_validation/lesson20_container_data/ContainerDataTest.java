package java15_validation.lesson20_container_data;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;

/**
 * Container Data
 *
 * - Saat kita membuat class, kadang sering kita gunakan tipe data container, seperti misalnya Optional, Collection,
 *   List, Set, Map dan lain-lain
 * - Secara default, jika kita isi data tersebut dengan data Object, misal @Valid List<Address>, maka secara otomatis
 *   Bean Validation akan melakukan validasi semua data object Address sesuai dengan constraint yang ada di dalam class
 *   Address
 * - Tapi bagaimana jika kita memiliki misal field List<String>, atau Map<String, String>, bagaimana melakukan
 *   validasinya? Misal kita ingin semua data string di List tidak boleh kosong
 * - Untungnya, Bean Validation mendukung validasi terhadap data container seperti ini
 *
 * Validate Container Data
 *
 * - Untuk melakukan validasi data jenis container, Bean Validation membutuhkan yang namanya Value Extractor
 * - Value Extractor ini menjadikan Bean Validation bisa melakukan ekstraksi data dari container
 * - Secara default, Bean Validation mendukung semua data container yang tersedia di Java, seperti Optional, Collection,
 *   List, Iterable, Set dan Map
 * - Yang kita butuhkan, hanya dengan menambahkan Constraint pada generic type container tersebut
 */
public class ContainerDataTest {

    @Test
    void containerData() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Person person = new Person();
        person.setHobbies(new ArrayList<>());
        person.getHobbies().add("");
        person.getHobbies().add(" ");
        person.getHobbies().add("gaming");

        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }
}
