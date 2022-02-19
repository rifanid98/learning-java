package java18_spring_dasar.lesson26_inheritance;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MerchantServiceImpl.class)
public class BeanConfiguration {
}
