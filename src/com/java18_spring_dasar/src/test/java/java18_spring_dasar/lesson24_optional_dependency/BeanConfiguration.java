package java18_spring_dasar.lesson24_optional_dependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class BeanConfiguration {

    @Bean
    public Foo foo() {
        return new Foo();
    }

    @Bean
    public FooBar fooBar(Optional<Foo> foo, Optional<Bar> bar) {
        return new FooBar(foo.orElse(null), bar.orElse(null));
    }
}
