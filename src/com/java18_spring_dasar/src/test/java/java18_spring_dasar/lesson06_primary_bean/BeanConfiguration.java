package java18_spring_dasar.lesson06_primary_bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Slf4j
@Configuration
public class BeanConfiguration {

    @Primary
    @Bean
    public Foo foo1() {
        Foo foo = new Foo();
        log.info("Create new foo 1");
        return foo;
    }

    @Bean
    public Foo foo2() {
        Foo foo = new Foo();
        log.info("Create new foo 2");
        return foo;
    }
}
