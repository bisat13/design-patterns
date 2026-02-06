package multithreading;

class A {
    synchronized void methodA(B b) {
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        b.last();
    }
    synchronized void last() {}
}

class B {
    synchronized void methodB(A a) {
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        a.last();
    }
    synchronized void last() {}
}

class MainMultiThreading {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        Thread t1 = new Thread(() -> a.methodA(b));
        Thread t2 = new Thread(() -> b.methodB(a));
        t1.start();
        t2.start();
    }
}
