package java18_spring_dasar.lesson25_factory_bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Factory Bean
 * <p>
 * - Kadang ada kasus dimana sebuah class misal bukanlah milik kita, misal class third party library
 * - Sehingga agak sulit jika kita harus menambahkan annotation pada class tersebut
 * - Pada kasus seperti ini, cara terbaik untuk membuat bean nya adalah dengan menggunakan @Bean method
 * - Atau di Spring, kita juga bisa menggunakan @Component, namun kita perlu wrap dalam class Factory Bean
 * - https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/FactoryBean.html
 */
public class FactoryBeanTest {

    @Test
    void factoryBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        PaymentGatewayClient client = context.getBean("paymentGatewayClient", PaymentGatewayClient.class);

        Assertions.assertEquals("https://payment/", client.getEndpoint());
        Assertions.assertEquals("private key", client.getPrivateKey());
        Assertions.assertEquals("public key", client.getPublickKey());
    }
}
