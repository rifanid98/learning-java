package java18_spring_dasar.lesson33_event_listener_annotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Event Listener Annotation
 * <p>
 * - Selain menggunakan interface ApplicationListener, kita juga bisa menggunakan Annotation untuk membuat Listener
 * - Ini lebih flexible dibanding menggunakan interface ApplicationListener
 * - Kita bisa menggunakan annotation @EventListener
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/event/EventListener.html
 * <p>
 * Cara Kerja Event Listener Annoation?
 * <p>
 * - Annotation @EventListener bekerja dengan menggunakan Bean Post Processor bernama EventListenerMethodProcessor
 * - EventListenerMethodProcessor mendeteksi jika ada bean yang memiliki method dengan annotation @EventListener, maka
 * secara otomatis akan membuat listener baru, lalu meregistrasikannya ke ApplicationContext.addApplicationListener(listener)
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/event/EventListenerMethodProcessor.html
 */
public class EventListenerAnnotationTest {

    @Test
    void eventListenerAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        UserService userService = context.getBean(UserService.class);
        userService.login("eko", "eko");
        userService.login("adnin", "adnin");
        userService.login("pzn", "pzn");
    }
}
