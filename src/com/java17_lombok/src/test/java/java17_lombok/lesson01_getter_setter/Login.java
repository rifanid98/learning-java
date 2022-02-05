package java17_lombok.lesson01_getter_setter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Login {

    @Setter(value = AccessLevel.PROTECTED)
    private String username;

    @Setter(value = AccessLevel.PROTECTED)
    private String password;

    @Setter(value = AccessLevel.PRIVATE)
    private boolean isAdmin;

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
