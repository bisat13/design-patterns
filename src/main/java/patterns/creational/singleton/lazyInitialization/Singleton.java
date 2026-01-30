package patterns.creational.singleton.lazyInitialization;

public class Singleton {

  private static Singleton instance;

  private Singleton() {}

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}

// cons: Not safe in multi-threaded environments
