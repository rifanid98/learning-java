package java17_lombok.lesson05_data;

import org.junit.jupiter.api.Test;

/**
 * Data
 *
 * - Saat membuat sebuah class Data/Model/Entity, kadang kita sering menggunakan annotation @Getter, @Setter,
 *   @RequiredArgsConstructor, @ToString, @EqualsAndHashCode
 * - Lombok memiliki annotation khusus untuk mempersingkatnya, yaitu menggunakan @Data
 */
public class DataTest {

    @Test
    void data() {
    }

    /**
     * Override Annotation
     *
     * - Jika kita ingin mengubah annotation atau menambah annotation setelah menggunakan Data, kita juga bisa lakukan
     * - Misal menambah @AllArgsContructor atau mengubah @ToString
     */
    @Test
    void overrideAnnotation() {
    }
}
