package examples.OrderFullFillment;

public class UPIPayment implements Payment{
    @Override
    public void makePayment() {
        System.out.println("Making payment via UPI");
    }
}
