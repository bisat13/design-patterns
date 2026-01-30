package patterns.structural.adapter;

public class ShoppingCart {

  public static void main(String[] args) {
    PaymentProcessor processor = new PayPalAdapter(new PayPalService());

    processor.pay(250.75);
  }
}
