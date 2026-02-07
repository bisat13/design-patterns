package examples.eCommerce;

import java.util.List;
import java.util.UUID;

class OrderService {
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final DeliveryService deliveryService;
    private final NotificationService notificationService;

    OrderService(InventoryService i, PaymentService p, DeliveryService d, NotificationService n) {
        this.inventoryService = i;
        this.paymentService = p;
        this.deliveryService = d;
        this.notificationService = n;
    }

    Order placeOrder(User user, List<OrderItem> items, double amount, String paymentType) {
        Order order = new Order(UUID.randomUUID().toString(), user, items);

        PaymentMethod paymentMethod = PaymentFactory.getPaymentMethod(paymentType);

        if (!paymentService.processPayment(order, amount, paymentMethod)) {
            notificationService.notify(user, "Payment failed");
            return order;
        }

        if (!inventoryService.reserveItems(items)) {
            paymentService.refund(paymentMethod, amount);
            order.updateStatus(OrderStatus.CANCELLED);
            notificationService.notify(user, "Inventory unavailable, order cancelled");
            return order;
        }

        order.updateStatus(OrderStatus.INVENTORY_RESERVED);

        deliveryService.assignPartner(order);
        notificationService.notify(user, "Order placed successfully");

        return order;
    }

    void cancelOrder(Order order, PaymentMethod method, double amount) {
        order.updateStatus(OrderStatus.CANCELLED);
        inventoryService.releaseItems(order.items);
        paymentService.refund(method, amount);
        notificationService.notify(order.user, "Order cancelled & refunded");
    }
}