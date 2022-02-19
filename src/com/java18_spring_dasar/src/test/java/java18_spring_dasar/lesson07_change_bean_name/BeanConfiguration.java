package java18_spring_dasar.lesson07_change_bean_name;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Slf4j
@Configuration
public class BeanConfiguration {

    @Primary
    @Bean(value = "fooFirst")
    public Foo foo1() {
        Foo foo = new Foo();
        log.info("Create new foo 1");
        return foo;
    }

    @Bean(value = "fooSecond")
    public Foo foo2() {
        Foo foo = new Foo();
        log.info("Create new foo 2");
        return foo;
    }
}
