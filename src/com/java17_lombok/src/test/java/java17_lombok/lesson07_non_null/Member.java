package java17_lombok.lesson07_non_null;

import lombok.Data;
import lombok.NonNull;

@Data
public class Member {

    @NonNull
    private String id;

    @NonNull
    private String name;

    public String sayHello(@NonNull String name) {
        return "Hello " + name + ", my name is " + this.name;
    }
}
