package patterns.behavioral.strategy;

public class CryptoPayment implements PaymentStrategy {
  public void processPayment() {
    System.out.println("Processing crypto payment...");
  }
}