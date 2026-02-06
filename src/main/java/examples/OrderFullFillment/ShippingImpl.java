package examples.OrderFullFillment;

public class ShippingImpl {
    Shipping shipping;

    // schedule Pickup
    public void schedulePickUp(int customerId, int orderId, int deliveryGuyId) {
        System.out.println("Scheduling the pickup");
    }

    // cron
    public void timeoutHandling() {
        if (shipping.startTime.after(null)) {
            System.out.println("Cancel order");
        }

    }
}
