package patterns.creational.singleton.billPughSingleton;

public class Singleton {

  private Singleton() {}

  private static class SingletonHelper {
    private static final Singleton INSTANCE = new Singleton();
  }

  public static Singleton getInstance() {
    return SingletonHelper.INSTANCE;
  }
}

/*
Uses static inner class.
Bill Pugh Singleton (Best Practice)
Pros
1. Lazy-loaded
2. Thread-safe
3. No synchronization overhead
 */