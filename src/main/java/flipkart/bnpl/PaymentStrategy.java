package flipkart.bnpl;

public interface PaymentStrategy {
  void processPayment(User user, double amount);
}
