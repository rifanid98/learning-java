package java15_validation.lesson09_payload;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import java15_validation.lesson09_payload.group.CreditCardPaymentGroup;
import java15_validation.lesson09_payload.group.VirtualAccountPaymentGroup;
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
            groups = {Default.class, CreditCardPaymentGroup.class},
            payload = {EmailErrorPayload.class}
    )
    private String creditCard;

    @NotBlank(
            message = "virtual account must not be blank",
            groups = {Default.class, VirtualAccountPaymentGroup.class}
    )
    private String virtualAccount;

    @NotNull(groups = {
            VirtualAccountPaymentGroup.class,
            CreditCardPaymentGroup.class,
    }, message = "customer must not null")
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    @Valid
    private Customer customer;

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
                ", customer=" + customer +
                '}';
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
