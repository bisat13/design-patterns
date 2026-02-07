package examples.eCommerce;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class InventoryService {
    private final Map<String, AtomicInteger> stock = new ConcurrentHashMap<>();

    void addItem(Item item, int quantity) {
        stock.putIfAbsent(item.itemId, new AtomicInteger(0));
        stock.get(item.itemId).addAndGet(quantity);
    }

    boolean reserveItems(List<OrderItem> items) {
        synchronized (this) {
            for (OrderItem oi : items) {
                if (stock.getOrDefault(oi.item.itemId, new AtomicInteger(0)).get() < oi.quantity) {
                    return false;
                }
            }
            for (OrderItem oi : items) {
                stock.get(oi.item.itemId).addAndGet(-oi.quantity);
            }
            return true;
        }
    }

    void releaseItems(List<OrderItem> items) {
        for (OrderItem oi : items) {
            stock.get(oi.item.itemId).addAndGet(oi.quantity);
        }
    }
}
