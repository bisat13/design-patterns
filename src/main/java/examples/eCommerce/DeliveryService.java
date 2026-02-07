package examples.eCommerce;

import java.util.UUID;

class DeliveryService {
    DeliveryPartner assignPartner(Order order) {
        DeliveryPartner partner = new DeliveryPartner(UUID.randomUUID().toString());
        order.updateStatus(OrderStatus.DELIVERY_PARTNER_ASSIGNED);
        return partner;
    }

    void updateDeliveryStatus(Order order, DeliveryStatus status) {
        if (status == DeliveryStatus.DELIVERED) {
            order.updateStatus(OrderStatus.DELIVERED);
        }
    }
}
