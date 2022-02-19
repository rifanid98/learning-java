package java18_spring_dasar.lesson39_command_line_runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Command Line Runner
 * <p>
 * - Saat kita membuat aplikasi, kadang kita butuh argument yang diberikan pada main method <br>
 * - Spring Application bisa mengirim data argument tersebut secara otomatis ke bean yang kita buat <br>
 * - Kita hanya butuh membuat bean dari CommandLineRunner <br>
 * - CommandLineRunner secara otomatis akan di jalankan ketika Spring Application berjalan <br>
 * - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/CommandLineRunner.html  <br>
 */
@SpringBootApplication
public class FooApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FooApplication.class);
        ApplicationContext context = application.run(args);
    }
}
