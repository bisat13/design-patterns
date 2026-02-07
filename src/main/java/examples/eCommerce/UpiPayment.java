package examples.eCommerce;

class UpiPayment implements PaymentMethod {
    public boolean pay(double amount) {
        System.out.println("UPI payment success");
        return true;
    }

    public void refund(double amount) {
        System.out.println("UPI refund processed");
    }
}
