package java18_spring_dasar.lesson19_component;

import org.springframework.stereotype.Component;

// bisa ditambahkan annotation lainnya
//@Scope("prototype")
//@Lazy
@Component(value = "MyCustomerService")
public class CustomerService {
}
