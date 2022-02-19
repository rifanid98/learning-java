package java18_spring_dasar.lesson15_lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Life Cycle
 * <p>
 * - Spring Container memiliki alur hidup, dan jika kita ingin berinteraksi dengan alur hidup nya Spring, kita juga bisa
 * lakukan
 * - Saat pertama kali Spring berjalan dan sudah selesai membuat bean, Spring akan memberitahu bean tersebut bahwa bean
 * tersebut sudah siap, artinya semua dependencies sudah dimasukkan.
 * - Dan ketika aplikasi Spring akan mati, Spring juga akan memberitahu semua bean bahwa bean tersebut akan dihancurkan
 * <p>
 * Life Cycle Callback
 * <p>
 * - Secara default, bean tidak bisa tahu alur hidup Spring ketika selesai membuat bean dan ketika akan menghancurkan bean
 * - Jika kita tertarik untuk bereaksi ketika alur hidup Spring terjadi, maka kita bisa implements interface InitializingBean
 * dan DisposableBean
 * - InitializingBean digunakan jika kita ingin bereaksi ketika Spring selesai membuat bean
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/InitializingBean.html
 * - DisposableBean digunakan jika kita ingin bereaksi ketika Spring akan menghancurkan bean
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/DisposableBean.html
 */
public class LifecycleTest {

    @Test
    void lifecycle() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Connection connection = context.getBean(Connection.class);
        context.close();
    }
}
