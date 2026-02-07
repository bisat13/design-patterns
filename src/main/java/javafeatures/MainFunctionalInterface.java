package javafeatures;
import java.util.*;
import java.util.stream.Collectors;

public class MainFunctionalInterface {

  public static void main(String[] args) {
    MyFunctionalInterface func = (msg) -> System.out.println(msg);
    func.doSomething("Hello");  // Output: Doing something!



    System.out.println("Hello world!");

    List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

    List<String> result = names.stream()                  // Source
        .filter(name -> name.length() > 3) // Intermediate
        .map(String::toUpperCase)         // Intermediate
        .collect(Collectors.toList());    // Terminal

    System.out.println(result);

    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    int sum = numbers.stream()
        .filter(n -> n % 2 == 1)     // Keep odd numbers
        .map(n -> n * n)             // Square them
        .reduce(0, Integer::sum);    // Sum them

    System.out.println(sum); // Output: 35 (1 + 9 + 25)

  }
}