package java15_validation.lesson12_message_interpolation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public class Order {

    @NotBlank(message = "id must not blank")
    @Size(min = 1, max = 10, message = "order id must between {min} and {max} characters")
    private String id;

    @Range(min = 1000, max = 100_000_000, message = "order amount must between {min} and {max}")
    private Long amount;

    public Order() {
    }

    public Order(String id, Long amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                '}';
    }
}
