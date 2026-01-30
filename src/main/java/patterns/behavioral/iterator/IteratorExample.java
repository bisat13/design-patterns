package patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {

  public static void main(String[] args) {
    ArrayList<String> fruits = new ArrayList<>();
    fruits.add("Apple");
    fruits.add("Banana");
    fruits.add("Orange");

    Iterator<String> iterator = fruits.iterator(); // Using Iterator to access the list
    while (iterator.hasNext()) {
      System.out.println(iterator.next()); // Access the next element in the collection
    }
  }
}
