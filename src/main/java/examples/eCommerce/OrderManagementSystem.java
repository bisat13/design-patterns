package examples.eCommerce;

import java.util.*;

public class OrderManagementSystem {
    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();
        PaymentService payment = new PaymentService();
        DeliveryService delivery = new DeliveryService();
        NotificationService notification = new NotificationService();

        notification.addChannel(new EmailNotification());

        OrderService orderService = new OrderService(
                inventory, payment, delivery, notification
        );

        Item item = new Item("1", "Laptop");
        inventory.addItem(item, 10);

        User user = new User("U1", "user@email.com");

        List<OrderItem> items = Arrays.asList(new OrderItem(item, 1));

        orderService.placeOrder(user, items, 1000.0, "CARD");
    }
}
