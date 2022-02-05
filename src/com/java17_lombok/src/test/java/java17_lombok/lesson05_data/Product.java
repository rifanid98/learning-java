package java17_lombok.lesson05_data;

import lombok.Data;

@Data
public class Product {

    private final String id;

    private String name;

    private Long price;
}
