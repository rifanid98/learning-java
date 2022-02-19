package java18_spring_dasar.lesson15_lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public Connection connection() {
        return new Connection();
    }
}
