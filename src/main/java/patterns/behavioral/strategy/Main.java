package patterns.behavioral.strategy;

public class Main {

  public static void main(String[] args) {
    PaymentStrategy creditCard = new CreditCardPayment();
    PaymentStrategy payPal = new PayPalPayment();
    PaymentStrategy crypto = new CryptoPayment();
    PaymentStrategy stripe = new StripePayment();
    // Use the Strategy Pattern to process payments
    PaymentProcessor processor = new PaymentProcessor(creditCard);
    processor.processPayment();

    processor.setPaymentStrategy(payPal);
    processor.processPayment();
    // Switch to Crypto
    processor.setPaymentStrategy(crypto);
    processor.processPayment();
    // Switch to Stripe
    processor.setPaymentStrategy(stripe);
    processor.processPayment();
  }
}
