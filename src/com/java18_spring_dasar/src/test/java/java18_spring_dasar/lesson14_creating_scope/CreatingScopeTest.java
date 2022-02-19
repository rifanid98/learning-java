package java18_spring_dasar.lesson14_creating_scope;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Membuat Scope
 * <p>
 * - Jika scope yang disediakan oleh Spring tidak bisa memenuhi kebutuhan kita, kita juga bisa membuat scope sendiri
 * - Caranya dengan membuat class yang implement interface Scope
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/Scope.html
 * - Selanjutnya untuk meregistrasikannya, kita bisa membuat bean CustomScopeConfigurer
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/CustomScopeConfigurer.html
 */
public class CreatingScopeTest {

    @Test
    void creatingScope() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class); // Foo belum dibuat
        Foo foo1 = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);
        Foo foo3 = context.getBean(Foo.class);
        Foo foo4 = context.getBean(Foo.class);

        Assertions.assertNotSame(foo1, foo2);
        Assertions.assertNotSame(foo3, foo4);
        Assertions.assertSame(foo1, foo3);
        Assertions.assertSame(foo2, foo4);
    }
}
