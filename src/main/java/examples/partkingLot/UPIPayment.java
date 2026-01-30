package examples.partkingLot;

public class UPIPayment implements Payment{

  @Override
  public void processPayment(double amount) {
    System.out.println("Payment done by upi " + amount);
  }
}
