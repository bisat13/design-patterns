package patterns.structural.adapter;

public class PayPalService {
  public void makePayment(double amount) {
    System.out.println("Payment of $" + amount + " made using PayPal");
  }
}
