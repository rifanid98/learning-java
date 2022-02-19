package java18_spring_dasar.lesson20_constructor_based_dependency_injection;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Constructor-based Dependency Injection
 */
@Component
public class ProductService {

    @Getter
    private ProductRepository productRepository;

    @Getter
    private String name;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService(ProductRepository productRepository, String name) {
        this.productRepository = productRepository;
        this.name = name;
    }
}
