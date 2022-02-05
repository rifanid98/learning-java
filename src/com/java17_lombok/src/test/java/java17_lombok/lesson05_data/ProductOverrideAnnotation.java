package java17_lombok.lesson05_data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "price")
@AllArgsConstructor
public class ProductOverrideAnnotation {

    private final String id;

    private String name;

    private Long price;
}
