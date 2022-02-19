package java18_spring_dasar.lesson40_application_runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Application Runner
 * <p>
 * - Selain CommandLineRunner, Spring Boot menyediakan fitur ApplicationRunner <br>
 * - Penggunaan ApplicationRunner sama seperti CommandLineRunnnner, hanya saja argument nya sudah di wrap dalam object ApplicationArguments <br>
 * - Yang menarik dari ApplicationArguments adalah, memiliki fitur parsing untuk command line argument <br>
 * - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/ApplicationArguments.html  <br>
 * - https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/ApplicationRunner.html  <br>
 */
@SpringBootApplication
public class FooApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FooApplication.class);
        ApplicationContext context = application.run(args);
    }
}
