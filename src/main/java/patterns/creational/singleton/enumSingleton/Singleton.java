package patterns.creational.singleton.enumSingleton;

public enum Singleton {
  INSTANCE;

  public void doSomething() {
    System.out.println("Singleton using enum");
  }
}

/*
Pros
1. Thread-safe
2. Prevents serialization and reflection attacks
3. Simplest implementation
Cons
1. Less flexible (cannot extend classes)
 */

