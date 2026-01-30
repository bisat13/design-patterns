package patterns.behavioral.strategy;

public class StripePayment implements PaymentStrategy {
  public void processPayment() {
    System.out.println("Processing Stripe payment...");
  }
}
