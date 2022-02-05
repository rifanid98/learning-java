package java17_lombok.lesson04_equals_dan_hashcode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Employee {

    private String id;

    private String name;
}
