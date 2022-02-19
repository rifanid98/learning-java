package java18_spring_dasar.lesson13_scope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
public class BeanConfiguration {

    @Bean
    @Scope("prototype")
    public Foo foo() {
        log.info("create foo");
        return new Foo();
    }


    @Bean
    public Bar bar() {
        log.info("create bar");
        return new Bar();
    }
}
