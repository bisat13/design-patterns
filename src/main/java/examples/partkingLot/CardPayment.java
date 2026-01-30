package examples.partkingLot;

public class CardPayment implements Payment{

  @Override
  public void processPayment(double amount) {
    System.out.println("Payment done by card " + amount);
  }
}
