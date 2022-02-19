package java18_spring_dasar.lesson27_bean_factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public Foo foo() {
        return new Foo();
    }
}
