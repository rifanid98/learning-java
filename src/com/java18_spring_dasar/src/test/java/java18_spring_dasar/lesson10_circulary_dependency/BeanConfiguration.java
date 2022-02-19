package java18_spring_dasar.lesson10_circulary_dependency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class BeanConfiguration {

    @Bean
    public DependencyA dependencyA(DependencyB dependencyB) {
        return new DependencyA(dependencyB);
    }

    @Bean
    public DependencyB dependencyB(DependencyC dependencyC) {
        return new DependencyB(dependencyC);
    }

    @Bean
    public DependencyC dependencyC(DependencyA dependencyA) {
        return new DependencyC(dependencyA);
    }
}
