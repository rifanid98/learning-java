package java15_validation.lesson23_metadata;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Person {

    @NotBlank(message = "first name can not blank")
    @Size(max = 20, message = "first name length max must 100 characters")
    private String firstName;

    @NotBlank(message = "last name can not blank")
    @Size(max = 20, message = "last name length max must 100 characters")
    private String lastName;

    @NotNull(message = "address can not null")
    @Valid
    private Address address;

    private List<@NotBlank(message = "hobbies must not blank") String> hobbies;

    public Person() {
    }

    public Person(@NotBlank(message = "first name must not blank") String firstName,
                  @NotBlank(message = "last namemust not blank") String lastName,
                  @NotNull(message = "address must not null") Address address,
                  List<String> hobbies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void sayHello(@NotBlank(message = "name must not blank") String name) {
        System.out.println("Hi " + name + ", my name is " + this.firstName);
    }

    @NotBlank(message = "Not Blank!")
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", hobbies=" + hobbies +
                '}';
    }
}
