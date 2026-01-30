package flipkart.bnpl;


public class PrePaidPayment implements PaymentStrategy {

  @Override
  public void processPayment(User user, double amount) {
    System.out.println("Payment is done via prepaid method...");
  }
}
