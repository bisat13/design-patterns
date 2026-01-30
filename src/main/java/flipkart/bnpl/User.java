package flipkart.bnpl;

import java.util.ArrayList;
import java.util.List;

public class User {

  final String userId;
  final String name;
  double bnplCreditLimit;
  boolean blackListed = false;
  final List<Order> orders = new ArrayList<>();
  User(String userId, String name, double bnplCreditLimit) {
    this.userId = userId;
    this.name = name;
    this.bnplCreditLimit = bnplCreditLimit;
  }

}
