package java18_spring_dasar.lesson27_bean_factory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * Bean Factory
 * <p>
 * - ApplicationContext adalah interface turunan dari BeanFactory
 * - BeanFactory merupakan kontrak untuk management bean di Spring
 * - Method-method yang sebelumnya kita gunakan untuk mengambil bean, sebenarnya merupakan method kontrak dari interface
 * BeanFactory
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/BeanFactory.html
 * <p>
 * Listable Bean Factory
 * <p>
 * - Bean Factory hanya bisa digunakan untuk mengakses single bean, artinya jika terdapat bean dengan tipe yang sama,
 * kita harus sebutkan satu per satu nama bean nya
 * - Listable Bean Factory adalah turunan dari Bean Factory yang bisa kita gunakan untuk mengakses beberapa bean sekaligus
 * - Dalam beberapa kasus, ini sangat berguna, seperti misal kita ingin mengambil semua bean dengan tipe tertentu
 * - Application Context juga merupakan turunan dari interface Listable Bean Factory
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/ListableBeanFactory.html
 */
public class BeanFactoryTest {

    @Test
    void beanFactory() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        ObjectProvider<Foo> fooObjectProvider = context.getBeanProvider(Foo.class);
        Map<String, Foo> beans = context.getBeansOfType(Foo.class);

        System.out.println(fooObjectProvider);
        System.out.println(beans);
    }
}
