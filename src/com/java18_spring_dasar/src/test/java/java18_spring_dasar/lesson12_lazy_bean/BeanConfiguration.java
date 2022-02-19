package java18_spring_dasar.lesson12_lazy_bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Slf4j
@Configuration
public class BeanConfiguration {

    @Bean
    @Lazy
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
}
