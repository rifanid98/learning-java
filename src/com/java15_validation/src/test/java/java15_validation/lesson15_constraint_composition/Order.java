package java15_validation.lesson15_constraint_composition;

import org.hibernate.validator.constraints.Range;

public class Order {

    @CheckOrderId
    private String id;

    @Range(min = 1000, max = 100_000_000, message = "{order.amount.range}")
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
