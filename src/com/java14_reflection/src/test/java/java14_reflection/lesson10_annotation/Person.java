package java14_reflection.lesson10_annotation;

import java14_reflection.lesson07_interface.Nameable;

public class Person implements Nameable {

    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    @NotBlank
    public String getFirstName() {
        return null;
    }

    @NotBlank
    @Override
    public String getLastName() {
        return null;
    }
}
