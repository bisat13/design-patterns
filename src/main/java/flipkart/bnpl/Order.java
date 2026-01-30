package flipkart.bnpl;

import java.time.LocalDate;
import java.util.List;

public class Order {
  final String orderId;
  final LocalDate purchaseDate;
  final PaymentMethod method;
  final List<OrderItem> items;
  final double amount;
  boolean cleared = false;

  Order(String orderId, LocalDate purchaseDate, PaymentMethod method, List<OrderItem> items, double amount) {
    this.orderId = orderId;
    this.purchaseDate = purchaseDate;
    this.method = method;
    this.items = items;
    this.amount = amount;
  }
}
