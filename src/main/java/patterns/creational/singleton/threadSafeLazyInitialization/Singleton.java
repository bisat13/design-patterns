package patterns.creational.singleton.threadSafeLazyInitialization;

public class Singleton {

  private static Singleton instance;

  private Singleton() {}

  public static synchronized Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}

/*
Pros
1. Thread-safe
Cons
1. Performance overhead due to synchronization
 */