package java14_reflection.lesson12_primitive_type;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlank {
    boolean allowEmptyString() default false;
}
