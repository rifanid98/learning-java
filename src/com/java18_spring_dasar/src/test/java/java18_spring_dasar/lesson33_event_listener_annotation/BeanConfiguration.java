package java18_spring_dasar.lesson33_event_listener_annotation;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        UserListener.class,
        UserService.class
})
public class BeanConfiguration {
}
