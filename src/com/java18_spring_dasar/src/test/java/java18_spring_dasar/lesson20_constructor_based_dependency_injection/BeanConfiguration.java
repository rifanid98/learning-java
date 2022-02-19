package java18_spring_dasar.lesson20_constructor_based_dependency_injection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "java18_spring_dasar.lesson20_constructor_based_dependency_injection"
})
public class BeanConfiguration {
}
