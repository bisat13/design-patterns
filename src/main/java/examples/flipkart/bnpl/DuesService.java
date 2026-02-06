package examples.flipkart.bnpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DuesService {

  void viewDues(User user, LocalDate date) {
    List<Order> toSort = new ArrayList<>();
    for (Order order : user.orders) {
      if (order.method == PaymentMethod.BNPL && !order.cleared && !order.purchaseDate.isAfter(date)) {
        toSort.add(order);
      }
    }
    toSort.sort(Comparator.comparing(order -> order.purchaseDate));

    if (toSort.size() == 0) {
      System.out.println("No dues left");
      return;
    }

    for (Order order : toSort) {
      LocalDate dueDate = order.purchaseDate.plusDays(30);
      DueStatus status = date.isAfter(dueDate) ? DueStatus.DELAYED : DueStatus.PENDING;
      System.out.println("Order purchasing date: " + order.purchaseDate + " Order amount: " + order.amount);
      System.out.println("Due By: " + dueDate + " Status: " +status);
    }
  }

  void clearDues(User user, List<String> orderIDs, LocalDate date) {
    for (Order order  : user.orders) {
      if (orderIDs.contains(order.orderId) && !order.cleared) {
        order.cleared = true;
        user.bnplCreditLimit += order.amount;
      }
    }

    long defaults = 0L;
    for (Order order : user.orders) {
      if (order.method == PaymentMethod.BNPL && !order.cleared
          && date.isAfter(order.purchaseDate.plusDays(30))) {
        defaults++;
      }
    }
    if (defaults >= 3) user.blackListed = true;
  }
}
