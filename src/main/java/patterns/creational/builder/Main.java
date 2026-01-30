package patterns.creational.builder;

public class Main {

  public static void main(String[] args) {
    Car.CarBuilder builder = new Car.CarBuilder();
    Car car1 = builder.setEngine("V8").setColor("Red").setSeats(5).setSunroof(true).build();
    System.out.println(car1.toString());

    Car car2 = builder.setEngine("V6").setColor("Blue").setSeats(4).build();
    System.out.println(car2);
  }
}
