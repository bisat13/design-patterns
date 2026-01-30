package flipkart.bnpl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class UserService {
  private final AtomicInteger sequence = new AtomicInteger(1);
  private final Map<String, User> users = new HashMap<>();
  User register(String name, double limit) {
    String id = String.valueOf(sequence.getAndIncrement());
    User user = new User(id, name, limit);
    users.put(id, user);
    return user;
  }

  User get(String userId) {
    return users.get(userId);
  }
}
