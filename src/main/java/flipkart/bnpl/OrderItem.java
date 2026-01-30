package flipkart.bnpl;

public class OrderItem {

  final String productName;
  final int quantity;
  final double price;

  OrderItem(String productName, int quantity, double price) {
    this.productName = productName;
    this.quantity = quantity;
    this.price = price;
  }
}
