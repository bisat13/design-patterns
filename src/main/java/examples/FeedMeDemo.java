package examples;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/* ======================= DEMO ======================= */
//Link for the problem statement: https://leetcode.com/discuss/post/6614846/flipkart-machine-coding-round-by-anonymo-pt3b/

public class FeedMeDemo {
  public static void main(String[] args) {

    RestaurantService rs = new RestaurantService();
    OrderService os = new OrderService(rs);

    // Onboard Restaurants
    Restaurant r1 = new Restaurant("R1", 4.5, 5);
    r1.menu.put("Veg Biryani", new MenuItem("Veg Biryani", 100));
    r1.menu.put("Chicken Biryani", new MenuItem("Chicken Biryani", 150));

    Restaurant r2 = new Restaurant("R2", 4.0, 5);
    r2.menu.put("Chicken Biryani", new MenuItem("Chicken Biryani", 175));
    r2.menu.put("Idli", new MenuItem("Idli", 10));
    r2.menu.put("Dosa", new MenuItem("Dosa", 50));
    r2.menu.put("Veg Biryani", new MenuItem("Veg Biryani", 80));

    Restaurant r3 = new Restaurant("R3", 4.9, 1);
    r3.menu.put("Gobi Manchurian", new MenuItem("Gobi Manchurian", 150));
    r3.menu.put("Idli", new MenuItem("Idli", 15));
    r3.menu.put("Chicken Biryani", new MenuItem("Chicken Biryani", 175));
    r3.menu.put("Dosa", new MenuItem("Dosa", 30));

    rs.onboardRestaurant(r1);
    rs.onboardRestaurant(r2);
    rs.onboardRestaurant(r3);

    // Orders
    Order o1 = os.placeOrder("Ashwin",
        Arrays.asList(new OrderItem("Idli", 3), new OrderItem("Dosa", 1)),
        new LowestCostStrategy());
    System.out.println("Order1 -> " + o1.restaurant.name);

    Order o2 = os.placeOrder("Harish",
        Arrays.asList(new OrderItem("Idli", 3), new OrderItem("Dosa", 1)),
        new LowestCostStrategy());
    System.out.println("Order2 -> " + o2.restaurant.name);

    Order o3 = os.placeOrder("Shruthi",
        Arrays.asList(new OrderItem("Veg Biryani", 3)),
        new HighestRatingStrategy());
    System.out.println("Order3 -> " + o3.restaurant.name);

    // Complete order
    r3.completeOrder(o1.orderId);

    Order o4 = os.placeOrder("Harish",
        Arrays.asList(new OrderItem("Idli", 3), new OrderItem("Dosa", 1)),
        new LowestCostStrategy());
    System.out.println("Order4 -> " + o4.restaurant.name);

    try {
      os.placeOrder("xyz",
          Arrays.asList(new OrderItem("Paneer Tikka", 1), new OrderItem("Idli", 1)),
          new LowestCostStrategy());
    } catch (Exception e) {
      System.out.println("Order5 -> " + e.getMessage());
    }
  }
}



/* ======================= ENTITIES ======================= */

class MenuItem {
  String name;
  double price;

  MenuItem(String name, double price) {
    this.name = name;
    this.price = price;
  }
}

enum OrderStatus {
  ACCEPTED, COMPLETED
}

class OrderItem {
  String name;
  int quantity;

  OrderItem(String name, int quantity) {
    this.name = name;
    this.quantity = quantity;
  }
}

class Order {
  static AtomicInteger ID_GEN = new AtomicInteger(1);

  int orderId;
  String user;
  List<OrderItem> items;
  OrderStatus status;
  Restaurant restaurant;

  Order(String user, List<OrderItem> items) {
    this.orderId = ID_GEN.getAndIncrement();
    this.user = user;
    this.items = items;
    this.status = OrderStatus.ACCEPTED;
  }
}

class Restaurant {
  String name;
  double rating;
  int maxCapacity;
  int currentOrders = 0;
  Map<String, MenuItem> menu = new HashMap<>();
  List<Order> activeOrders = new ArrayList<>();

  Restaurant(String name, double rating, int maxCapacity) {
    this.name = name;
    this.rating = rating;
    this.maxCapacity = maxCapacity;
  }

  synchronized boolean canAcceptOrder() {
    return currentOrders < maxCapacity;
  }

  synchronized void acceptOrder(Order order) {
    if (!canAcceptOrder())
      throw new IllegalStateException("Capacity full");
    activeOrders.add(order);
    currentOrders++;
    order.restaurant = this;
  }

  synchronized void completeOrder(int orderId) {
    Order order = activeOrders.stream()
        .filter(o -> o.orderId == orderId)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    order.status = OrderStatus.COMPLETED;
    activeOrders.remove(order);
    currentOrders--;
  }

  boolean canFulfill(List<OrderItem> items) {
    return items.stream().allMatch(i -> menu.containsKey(i.name));
  }

  double calculateCost(List<OrderItem> items) {
    return items.stream()
        .mapToDouble(i -> menu.get(i.name).price * i.quantity)
        .sum();
  }

  int remainingCapacity() {
    return maxCapacity - currentOrders;
  }
}

/* ======================= STRATEGY ======================= */

interface RestaurantSelectionStrategy {
  Optional<Restaurant> select(List<Restaurant> restaurants, List<OrderItem> items);
}

class LowestCostStrategy implements RestaurantSelectionStrategy {
  public Optional<Restaurant> select(List<Restaurant> restaurants, List<OrderItem> items) {
    return restaurants.stream()
        .filter(r -> r.canAcceptOrder() && r.canFulfill(items))
        .min(Comparator.comparingDouble(r -> r.calculateCost(items)));
  }
}

class HighestRatingStrategy implements RestaurantSelectionStrategy {
  public Optional<Restaurant> select(List<Restaurant> restaurants, List<OrderItem> items) {
    return restaurants.stream()
        .filter(r -> r.canAcceptOrder() && r.canFulfill(items))
        .max(Comparator.comparingDouble(r -> r.rating));
  }
}

class MaxRemainingCapacityStrategy implements RestaurantSelectionStrategy {
  public Optional<Restaurant> select(List<Restaurant> restaurants, List<OrderItem> items) {
    return restaurants.stream()
        .filter(r -> r.canAcceptOrder() && r.canFulfill(items))
        .max(Comparator.comparingInt(Restaurant::remainingCapacity));
  }
}

/* ======================= SERVICES ======================= */

class RestaurantService {
  Map<String, Restaurant> restaurants = new HashMap<>();

  void onboardRestaurant(Restaurant r) {
    restaurants.put(r.name, r);
  }

  void addOrUpdateMenu(String restaurantName, String item, double price) {
    Restaurant r = restaurants.get(restaurantName);
    if (r == null) throw new IllegalArgumentException("Restaurant not found");
    r.menu.put(item, new MenuItem(item, price));
  }

  void updateCapacity(String restaurantName, int newCapacity) {
    Restaurant r = restaurants.get(restaurantName);
    if (r == null) throw new IllegalArgumentException("Restaurant not found");
    r.maxCapacity = newCapacity;
  }
}

class OrderService {
  RestaurantService restaurantService;

  OrderService(RestaurantService restaurantService) {
    this.restaurantService = restaurantService;
  }

  synchronized Order placeOrder(String user, List<OrderItem> items, RestaurantSelectionStrategy strategy) {
    List<Restaurant> candidates = new ArrayList<>(restaurantService.restaurants.values());
    Optional<Restaurant> selected = strategy.select(candidates, items);

    if (!selected.isPresent())
      throw new IllegalStateException("Order can’t be fulfilled");

    Order order = new Order(user, items);
    selected.get().acceptOrder(order);
    return order;
  }
}