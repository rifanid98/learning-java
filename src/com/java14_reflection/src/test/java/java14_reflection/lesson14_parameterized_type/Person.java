package java14_reflection.lesson14_parameterized_type;

import java14_reflection.lesson07_interface.Nameable;
import java14_reflection.lesson12_primitive_type.NotBlank;

import java.util.List;

public class Person implements Nameable {

    @NotBlank
    private String firstName;

    @NotBlank(allowEmptyString = true)
    private String lastName;

    private int age;

    private List<String> hobbies;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
