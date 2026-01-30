package examples.movieBooking;

import examples.movieBooking.enums.SeatStatus;
import java.time.LocalDateTime;
import java.util.Map;

class Show {
  String showId;
  Movie movie;
  Screen screen;
  LocalDateTime startTime;
  Map<Seat, SeatStatus> seatStatusMap;
}

