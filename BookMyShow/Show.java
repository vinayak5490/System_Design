package BookMyShow;

import java.time.LocalDateTime;
import java.util.*;

public class Show {
    private String id;
    private Movie movie;
    private LocalDateTime startTime;
    private List<Seat> seats;
    private Map<SeatType, Double> priceMap;

    public Show(String id, Movie movie, LocalDateTime startTime, List<Seat> seats, Map<SeatType, Double> priceMap) {
        this.id = id;
        this.movie = movie;
        this.startTime = startTime;
        this.seats = seats;
        this.priceMap = priceMap;
    }

    public String getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public double getSeatPrice(Seat seat) {
        return priceMap.getOrDefault(seat.getType(), 100.0); // Default price if not found
    }

    public boolean reserveSeats(List<String> seatNumbers) {
        for (String sn : seatNumbers) {
            Seat seat = findSeatByNumber(sn);
            if (seat == null || seat.isBooked()) {
                return false; // If seat invalid or already booked
            }
        }
        for (String sn : seatNumbers) {
            Seat seat = findSeatByNumber(sn);
            seat.markBooked();
        }
        return true;
    }

    public void releaseSeats(List<String> seatNumbers) {
        for (String sn : seatNumbers) {
            Seat seat = findSeatByNumber(sn);
            if (seat != null)
                seat.markFree();
        }
    }

    private Seat findSeatByNumber(String seatNumber) {
        for (Seat s : seats) {
            if (s.getSeatNumber().equals(seatNumber))
                return s;
        }
        return null;
    }

    public void showSeatStatus() {
        System.out.println("Show: " + movie.getTitle() + " | " + startTime);
        for (Seat s : seats) {
            System.out.println(s);
        }
    }
}
