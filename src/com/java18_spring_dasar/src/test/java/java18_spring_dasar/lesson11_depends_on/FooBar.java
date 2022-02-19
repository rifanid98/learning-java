package java18_spring_dasar.lesson11_depends_on;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FooBar {

    private Foo foo;

    private Bar bar;
}
