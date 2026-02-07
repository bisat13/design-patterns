package examples.eCommerce;

import java.util.List;

class Order {
    final String orderId;
    final User user;
    final List<OrderItem> items;
    volatile OrderStatus status;
    final long createdAt;

    Order(String orderId, User user, List<OrderItem> items) {
        this.orderId = orderId;
        this.user = user;
        this.items = items;
        this.status = OrderStatus.CREATED;
        this.createdAt = System.currentTimeMillis();
    }

    synchronized void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
        System.out.println("Order " + orderId + " -> " + newStatus);
    }
}
