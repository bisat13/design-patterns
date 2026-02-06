package examples.flipkart.bnpl;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
  private Map<String, Product> products = new HashMap<>();
  void seed(String name, int quantity, double price) {
    products.put(name, new Product(name, quantity, price));
  }
  void add(String name, int quantity) {
    products.get(name).quantity += quantity;
  }

  void remove(String name, int quantity) {
    Product product = products.get(name);
    if (product.quantity < quantity) {
      throw new RuntimeException("Not enough inventory");
    }
    product.quantity -= quantity;
  }

  Product get(String name) {
    return products.get(name);
  }

  void view() {
    int count = 1;
    for (Product product : products.values()) {
      System.out.println(count++ + ". " + product.name + " " + product.quantity + " " + product.price);
    }
  }
}
