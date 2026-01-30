package patterns.behavioral.strategy;

public class PayPalPayment implements PaymentStrategy {
  public void processPayment() {
    System.out.println("Processing PayPal payment...");
  }
}