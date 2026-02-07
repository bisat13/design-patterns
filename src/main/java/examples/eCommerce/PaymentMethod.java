package examples.eCommerce;

interface PaymentMethod {
    boolean pay(double amount);

    void refund(double amount);
}
