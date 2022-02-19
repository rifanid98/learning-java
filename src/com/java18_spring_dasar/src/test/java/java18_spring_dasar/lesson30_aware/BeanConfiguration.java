package java18_spring_dasar.lesson30_aware;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AuthService.class)
public class BeanConfiguration {
}
