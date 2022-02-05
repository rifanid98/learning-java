package java17_lombok.lesson02_constructor;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class Merchant {

    private final String id;

    private String name;
}
