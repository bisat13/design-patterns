package examples.OrderFullFillment;

public class NotifyViaEmail implements Notification{

    @Override
    public void notifyCustomer() {
        System.out.println("Customer getting Notified via email");
    }
}
