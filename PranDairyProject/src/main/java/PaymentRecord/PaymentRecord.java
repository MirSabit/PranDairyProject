package PaymentRecord;

public class PaymentRecord {

    private final String paymentId;
    private final String amount;
    private final String paymentDate;
    private final String result;

    public PaymentRecord(String paymentId, String amount, String paymentDate, String result) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.result = result;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getAmount() {
        return amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getResult() {
        return result;
    }
}
