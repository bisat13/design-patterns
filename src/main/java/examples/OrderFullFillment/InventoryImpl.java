package examples.OrderFullFillment;

public class InventoryImpl {
    Invertory invertory;

    public InventoryImpl(Invertory invertory) {
        this.invertory = invertory;
    }

    // add product
    public void addProduct(Product product, int quantity) {
        invertory.productsMap.put(product, quantity);
    }

    public void removeProduct(Product product, int quantity) {
        int existingQuantity = invertory.productsMap.get(product);
        invertory.productsMap.put(product, existingQuantity-quantity);
    }

}
