package java17_lombok.lesson06_builder;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonSingular {

    private String id;

    private String name;

    private Integer age;

    @Singular
    private List<String> hobbies;
}
