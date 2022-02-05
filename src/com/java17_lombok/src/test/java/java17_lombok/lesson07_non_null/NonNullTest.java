package java17_lombok.lesson07_non_null;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Non Null
 *
 * - Sebelumnya, saat kita membuat constructor dengan @RequiredArgsConstructor, Lombok akan menjadi final field. Hal ini
 *   membuat field tersebut tidak bisa diubah lagi
 * - Lombok memiliki annotation @NonNull
 * - Jika @NonNull ditempatkan di field, maka secara otomatis juga akan di generate di @RequiredArgsConstructor,
 *   sekaligus dilakukan pengecekan tidak boleh null. Selain itu semua setter method nya juga akan dilakukan pengecekan null
 * - Jika @NonNull ditempatkan di parameter, maka parameter tersebut akan dilakukan pengecekan null
 * - Jika parameternya null, maka otomatis akan throw NullPointerException
 */
public class NonNullTest {

    @Test
    void nonNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Member member = new Member(null, null);
        });
    }

    @Test
    void setterNonNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Member member = new Member(null, null);
            member.setName(null);
        });
    }

    @Test
    void methodNonNull() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Member member = new Member(null, null);
            member.sayHello(null);
        });
    }
}
