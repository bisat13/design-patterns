package examples.flipkart.bnpl;

public class BNPLPayment implements PaymentStrategy {

  @Override
  public void processPayment(User user, double amount) {
    if (user.blackListed) {
      throw new RuntimeException("User is blacklisted");
    }
    if (user.bnplCreditLimit < amount) {
      throw new RuntimeException("BNPL credit Exhausted");
    }
    user.bnplCreditLimit -= amount;
  }
}
