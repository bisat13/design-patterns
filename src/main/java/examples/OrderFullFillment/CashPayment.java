package examples.OrderFullFillment;

public class CashPayment implements Payment{
    @Override
    public void makePayment() {
        System.out.println("Making payment via cash");
    }
}
