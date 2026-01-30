package flipkart.bnpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderService {

  private Inventory inventory;
  private final AtomicInteger orderSequence = new AtomicInteger(1);

  OrderService(Inventory inventory) {
    this.inventory = inventory;
  }

  public String buy(User user, Map<String, Integer> items, PaymentMethod method, LocalDate date) {
    List<OrderItem> orderItems = new ArrayList<>();
    double total = 0;

    for (Map.Entry<String, Integer> item : items.entrySet()) {
      Product product = inventory.get(item.getKey());
      if (product.quantity < item.getValue()) {
        throw new RuntimeException("Insufficient stock");
      }
      total += product.price * item.getValue();
      orderItems.add(new OrderItem(product.name, item.getValue(), product.price));
    }

    PaymentFactory.get(method).processPayment(user, total);

    for (OrderItem orderItem : orderItems) {
      inventory.remove(orderItem.productName, orderItem.quantity);
    }

    String orderID = String.valueOf(orderSequence.getAndIncrement());
    Order order = new Order(orderID, date, method, orderItems, total);
    user.orders.add(order);
    return orderID;
  }

  void orderStatus(User user) {
    System.out.println(user.bnplCreditLimit + " (BNPL Credit limit available)");
    List<Order> toSort = new ArrayList<>();
    toSort.addAll(user.orders);
    toSort.sort(Comparator.comparing(order -> order.purchaseDate));
    for (Order order : toSort) {
      System.out.println(order.purchaseDate + " " + order.method + " " + order.amount);
    }
  }
}
