package java18_spring_dasar.lesson11_depends_on;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Slf4j
@Configuration
public class BeanConfiguration {

    @Bean
    @DependsOn(value = {"bar"})
    public Foo foo() {
        log.info("create foo");
        return new Foo();
    }


    @Bean
    public Bar bar() {
        log.info("create bar");
        return new Bar();
    }

    @Bean
    public FooBar fooBar(Foo foo, Bar bar) {
        return new FooBar(foo, bar);
    }
}
