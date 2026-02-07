package examples.eCommerce;

class CreditCardPayment implements PaymentMethod {
    public boolean pay(double amount) {
        System.out.println("CreditCard payment success");
        return true;
    }

    public void refund(double amount) {
        System.out.println("CreditCard refund processed");
    }
}
