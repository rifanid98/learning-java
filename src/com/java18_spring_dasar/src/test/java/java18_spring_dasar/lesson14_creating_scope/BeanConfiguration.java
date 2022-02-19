package java18_spring_dasar.lesson14_creating_scope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
public class BeanConfiguration {

    @Bean
    @Scope("doubleton")
    public Foo foo() {
        log.info("create foo");
        return new Foo();
    }

    @Bean
    @Scope("doubleton")
    public Bar bar() {
        log.info("create bar");
        return new Bar();
    }

    @Bean
    public CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("doubleton", new DoubletonScope());
        return configurer;
    }
}
