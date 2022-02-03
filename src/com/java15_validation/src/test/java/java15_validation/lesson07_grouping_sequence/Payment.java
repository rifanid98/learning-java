package java15_validation.lesson07_grouping_sequence;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import java15_validation.lesson06_grouping_constraint.group.CreditCardPaymentGroup;
import java15_validation.lesson06_grouping_constraint.group.VirtualAccountPaymentGroup;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class Payment {

    @NotBlank(
            message = "order id must not be blank",
            groups = {Default.class, CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}
    )
    private String orderId;

    @NotNull(
            message = "amount must not be null",
            groups = {Default.class, CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}
    )
    @Range(min = 10000, max = 100_000_000, message = "amount must be range from 1000 to 100.000.000", groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
    private Long amount;

    @NotBlank(
            message = "credit card must not be blank",
            groups = {Default.class, CreditCardPaymentGroup.class}
    )
    @LuhnCheck(
            message = "credit card must valid number",
            groups = {Default.class, CreditCardPaymentGroup.class}
    )
    private String creditCard;

    @NotBlank(
            message = "virtual account must not be blank",
            groups = {Default.class, VirtualAccountPaymentGroup.class}
    )
    private String virtualAccount;

    public Payment() {
    }

    public Payment(String orderId, Long amount, String creditCard, String virtualAccount) {
        this.orderId = orderId;
        this.amount = amount;
        this.creditCard = creditCard;
        this.virtualAccount = virtualAccount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                '}';
    }
}
