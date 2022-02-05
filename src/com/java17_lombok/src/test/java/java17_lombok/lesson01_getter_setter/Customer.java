package java17_lombok.lesson01_getter_setter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private String id;

    private String name;

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
