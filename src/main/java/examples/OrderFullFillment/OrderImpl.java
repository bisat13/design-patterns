//package OrderFullFillment;
//import java.util.*;
//public class OrderImpl {
//
//    InventoryImpl invertoryImpl;
//
//    public OrderImpl(Invertory invertory) {
//        invertoryImpl = new InventoryImpl(invertory);
//    }
//
//    //placeOrder
//    public void placeOrder(int orderID, int userId, Payment payment, Notification notification) {
//        for(Product product : products) {
//            invertoryImpl.removeProduct(product, 1);
//        }
//        payment.makePayment();
//        System.out.println("Order is placed");
//        notification.notifyCustomer();
//    }
//}
