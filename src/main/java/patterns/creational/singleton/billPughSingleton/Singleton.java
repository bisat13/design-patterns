package patterns.creational.singleton.billPughSingleton;

public class Singleton {

  private Singleton() {}

  // Static inner class - loaded only when getInstance() is called
  private static class SingletonHelper {
    private static final Singleton INSTANCE = new Singleton();
  }

  public static Singleton getInstance() {
    return SingletonHelper.INSTANCE;
  }
}

class Main{
  public static void main(String[] args) {
    Singleton singleton = Singleton.getInstance();
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