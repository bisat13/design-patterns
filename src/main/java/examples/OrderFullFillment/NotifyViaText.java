package examples.OrderFullFillment;

public class NotifyViaText implements Notification{
    @Override
    public void notifyCustomer() {
        System.out.println("Notification send on phone");
    }
}
