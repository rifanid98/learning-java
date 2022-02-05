package java17_lombok.lesson03_to_string;

import lombok.*;

@Getter
@NoArgsConstructor(staticName = "createEmpty")
@AllArgsConstructor(staticName = "create")
@ToString
public class Login {

    @Setter(value = AccessLevel.PROTECTED)
    private String username;

    @Setter(value = AccessLevel.PROTECTED)
    private String password;

    @Setter(value = AccessLevel.PRIVATE)
    private boolean isAdmin;
}
