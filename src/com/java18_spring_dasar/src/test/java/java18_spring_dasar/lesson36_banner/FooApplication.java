package java18_spring_dasar.lesson36_banner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FooApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FooApplication.class, args);
    }
}
