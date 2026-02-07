package examples.eCommerce;

class OrderItem {
    final Item item;
    final int quantity;

    OrderItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}
