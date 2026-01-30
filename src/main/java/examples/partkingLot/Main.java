package examples.partkingLot;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    List<ParkingSpot> parkingSpots = new ArrayList<>();
    parkingSpots.add(new CarParkingSpot(1, "Car"));
    parkingSpots.add(new CarParkingSpot(2, "Car"));
    parkingSpots.add(new BikeParkingSpot(3, "Bike"));
    parkingSpots.add(new BikeParkingSpot(4, "Bike"));

    ParkingLot parkingLot = new ParkingLot(parkingSpots);

    ParkingFee twoVehilerStrategy = new TwoVehilerParkingFee();
    ParkingFee fourVehilerStrategy = new FourVehilerParkingFee();

    Vehicle car1 = VehicleFactory.createVehicle("Car", "CAR123", fourVehilerStrategy);
    Vehicle car2 = VehicleFactory.createVehicle("Car", "CAR345", fourVehilerStrategy);

    Vehicle bike1 = VehicleFactory.createVehicle("Bike", "BIKE456", twoVehilerStrategy);
    Vehicle bike2 = VehicleFactory.createVehicle("Bike", "BIKE123", twoVehilerStrategy);

    ParkingSpot carSpot = parkingLot.parkVehicle(car1);
    ParkingSpot bikeSpot = parkingLot.parkVehicle(bike1);

    Scanner scanner = new Scanner(System.in);
//    int x  = scanner.nextInt();

    double carFee = car1.calculateParkingFee(7);
    double bikeFee = bike1.calculateParkingFee(4);

    Payment payment1 = new UPIPayment();
    Payment payment2 = new CardPayment();

    PaymentProcessor processor = new PaymentProcessor(payment1);
    processor.processPayment(carFee);
    processor.setPayment(payment2);
    parkingLot.vacateSpot(carSpot, car1);

    ParkingSpot bikeSpot2 = parkingLot.parkVehicle(bike2);
    ParkingSpot bikeSpot4 = parkingLot.parkVehicle(car1);

    processor.processPayment(bikeFee);
    parkingLot.vacateSpot(bikeSpot, bike1);
  }
}
