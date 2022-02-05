package java17_lombok.lesson09_with;

import lombok.Value;
import lombok.With;

@Value
@With
public class Register {

    String name;

    String password;
}
