package java18_spring_dasar.lesson32_event_listener;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Event Listener
 * <p>
 * - Spring memiliki fitur Event Listener yang bisa kita gunakan untuk komunikasi antar class menggunakan Event
 * - Event di Spring merupakan object turunan dari ApplicationEvent, sedangkan Listener di Spring merupakan turunan dari
 * ApplicationListener
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationEvent.html
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationListener.html
 * <p>
 * Application Even Publisher
 * <p>
 * - Ketika kita ingin mengirimkan event ke listener, kita bisa menggunakan object ApplicationEventPublisher, dimana
 * ApplicationEventPublisher juga merupakan super interface dari ApplicationContext
 * - Atau kita bisa menggunakan ApplicationEventPublisherAware untuk mendapatkan object ApplicationEventPublisher
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationEventPublisher.html
 */
public class EventListenerTest {

    @Test
    void eventListener() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        UserService userService = context.getBean(UserService.class);
        userService.login("eko", "eko");
        userService.login("adnin", "adnin");
        userService.login("pzn", "pzn");
    }
}
