package examples.flipkart.bnpl;

public class PaymentFactory {
  static PaymentStrategy get(PaymentMethod method) {
    return method == PaymentMethod.PREPAID ? new PrePaidPayment() : new BNPLPayment();
  }
}
