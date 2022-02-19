package java18_spring_dasar.lesson31_bean_factory_post_processor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean Factory Post Processor
 * <p>
 * - Secara default, mungkin kita tidak akan pernah sama sekali membuat Application Context secara manual
 * - Namun kadang ada keadaan kita ingin memodifikasi secara internal Application Context
 * - Spring merekomendasikan kita untuk membuat Bean Factory Post Processor
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/BeanFactoryPostProcessor.html
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/support/BeanDefinitionRegistryPostProcessor.html
 */
public class BeanFactoryPostProcessorTest {

    @Test
    void beanFactoryPostProcessor() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Foo foo = context.getBean(Foo.class);

        Assertions.assertNotNull(foo);
    }
}
