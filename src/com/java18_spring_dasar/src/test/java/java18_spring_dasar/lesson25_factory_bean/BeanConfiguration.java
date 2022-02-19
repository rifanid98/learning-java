package java18_spring_dasar.lesson25_factory_bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {
        PaymentGatewayClientFactoryBean.class
})
public class BeanConfiguration {
}
