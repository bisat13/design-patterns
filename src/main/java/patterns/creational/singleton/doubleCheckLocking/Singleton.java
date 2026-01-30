package patterns.creational.singleton.doubleCheckLocking;

public class Singleton {

  private static volatile Singleton instance;

  private Singleton() {}

  public static Singleton getInstance() {
    if (instance == null) {
      synchronized (Singleton.class) {
        if (instance == null) {
          instance = new Singleton();
        }
      }
    }
    return instance;
  }
}

/*
Why volatile?
1. Prevents instruction reordering
2. Ensures visibility across threads
 */