package examples.flipkart.bnpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

    Inventory inventory = new Inventory();
    inventory.seed("Shoes", 5, 200);
    inventory.seed("Watch", 10, 1000);
    inventory.seed("T-Shirt", 14, 2000);

    inventory.view();

    UserService userService = new UserService();
    User akshay = userService.register("Akshay", 50000);

    OrderService orderService = new OrderService(inventory);
    Map<String, Integer> items = new HashMap<>();
    items.put("Shoes", 2);
    items.put("Watch", 1);

    String orderId = orderService.buy(akshay, items, PaymentMethod.BNPL, LocalDate.parse("20-Oct-2021", dateTimeFormatter));

    inventory.view();
    orderService.orderStatus(akshay);

    DuesService duesService = new DuesService();
    duesService.viewDues(akshay, LocalDate.parse("02-Nov-2021", dateTimeFormatter));
    duesService.viewDues(akshay, LocalDate.parse("21-Nov-2021", dateTimeFormatter));

    Map<String, Integer> items1 = new HashMap<>();
    items1.put("T-Shirt", 2);
    String orderId1 = orderService.buy(akshay, items1, PaymentMethod.BNPL, LocalDate.parse("20-Oct-2021", dateTimeFormatter));

    duesService.clearDues(akshay, List.of(orderId), LocalDate.parse("19-Nov-2021", dateTimeFormatter));
    duesService.viewDues(akshay, LocalDate.parse("20-Nov-2021", dateTimeFormatter));

    inventory.remove("T-Shirt", 5);
    inventory.add("Shoes", 100);
    inventory.view();
    orderService.orderStatus(akshay);


  }
}
