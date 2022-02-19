package java18_spring_dasar.lesson28_bean_post_processor;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        Car.class,
        IdGeneratorBeanPostProcessor.class
})
public class BeanConfiguration {
}
