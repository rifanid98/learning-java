package java18_spring_dasar.lesson38_spring_application_event;

import org.junit.jupiter.api.Test;

/**
 * Spring Application Event
 * <p>
 * - Sebelumnya kita sudah belajar tentang Event Listener <br>
 * - Di Spring Boot, terdapat banyak sekali Event yang dikirim ketika aplikasi Spring Boot berjalan <br>
 * - Jika kita ingin, kita bisa membuat Listener untuk menerima event tersebut <br>
 * - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/event/SpringApplicationEvent.html  <br>
 * <p>
 * Menambah Listener
 * <p>
 * - Beberapa Event di Spring Boot Application Event di trigger bahkan sebelum Spring membuat Application Context <br>
 * - Oleh karena itu, jika kita buat menggunakan bean, bisa saja beberapa listener tidak akan dipanggil, karena bean nya
 * belum dibuat <br>
 * - Agar lebih aman, kita bisa menambahkan listener ketika membuat SpringApplication  <br>
 */
public class SpringApplicationEventTest {

    @Test
    void name() {

    }
}
