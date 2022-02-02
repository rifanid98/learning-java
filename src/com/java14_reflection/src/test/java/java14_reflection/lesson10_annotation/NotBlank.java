package java14_reflection.lesson10_annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlank {
    boolean allowEmptyString() default false;
}
