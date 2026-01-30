package patterns.creational.singleton.eagerInitialization;

public class Singleton {

  private static final Singleton INSTANCE = new Singleton();

  private Singleton() {
    // private constructor
  }

  public static Singleton getInstance() {
    return INSTANCE;
  }
}

/*
Pros
1. Simple
2. Thread-safe (class loading guarantees)
Cons
1. Instance created even if never used
* */