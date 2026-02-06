package examples.OrderFullFillment;

import java.sql.Timestamp;

public class Shipping {
    int id;
    int customerId;
    Order order;
    Timestamp startTime;
    int deliveryGuyId;
    boolean isCancelled;
}
