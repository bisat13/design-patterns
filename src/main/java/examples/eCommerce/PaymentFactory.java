package examples.eCommerce;

class PaymentFactory {
    static PaymentMethod getPaymentMethod(String type) {
        switch (type) {
            case "UPI": return new UpiPayment();
            case "CARD": return new CreditCardPayment();
            default: throw new IllegalArgumentException("Invalid payment type");
        }
    }
}