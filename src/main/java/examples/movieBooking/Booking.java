package examples.movieBooking;

import examples.movieBooking.enums.BookingStatus;
import java.util.List;

class Booking {
  String bookingId;
  Show show;
  List<Seat> seats;
  BookingStatus status;
  double amount;
}
