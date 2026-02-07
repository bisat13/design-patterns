package examples.eCommerce;

class PaymentService {
    boolean processPayment(Order order, double amount, PaymentMethod method) {
        order.updateStatus(OrderStatus.PAYMENT_PENDING);
        boolean success = method.pay(amount);
        order.updateStatus(success ? OrderStatus.PAYMENT_SUCCESS : OrderStatus.FAILED);
        return success;
    }

    void refund(PaymentMethod method, double amount) {
        method.refund(amount);
    }
}
