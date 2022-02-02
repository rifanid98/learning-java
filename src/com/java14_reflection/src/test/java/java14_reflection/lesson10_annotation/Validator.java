package java14_reflection.lesson10_annotation;

import java.lang.reflect.Field;

public class Validator {
    public static void validateNotBlank(Object person) throws IllegalAccessException {
        Class<?> aClass = person.getClass();
        for (Field field : aClass.getDeclaredFields()) {
            field.setAccessible(true);
            NotBlank notBlank = field.getAnnotation(NotBlank.class);
            if (notBlank != null) {
                String value = (String) field.get(person);
                if (!notBlank.allowEmptyString()) value = value.trim();
                if (value == null || value.equals("")) {
                    throw new RuntimeException("Field : " + field.getName() + " is blank");
                }
            }
        }
    }
}
