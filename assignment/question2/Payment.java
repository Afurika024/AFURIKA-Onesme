package question2;

import java.time.LocalDate;

public class Payment {
    private String paymentId;

    public String getPaymentId() {
        return paymentId;
    }
    private String paymentMethod;
    private double amountPaid;
    private LocalDate transactionDate;

    public Payment(String paymentId, String paymentMethod, double amountPaid) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
        this.transactionDate = LocalDate.now();
    }

    public boolean validatePayment() {
        return (paymentMethod.equalsIgnoreCase("CreditCard") || paymentMethod.equalsIgnoreCase("PayPal")) && amountPaid > 0;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
}
