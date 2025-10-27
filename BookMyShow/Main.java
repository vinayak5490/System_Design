package BookMyShow;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // create movie
        Movie movie = new Movie("m1", "The Great Escape", 130, "English");

        // create seats for a show
        List<Seat> seats = new ArrayList<>();
        for (char r = 'A'; r <= 'A'; r++) { // single row A for demo
            for (int c = 1; c <= 10; c++) {
                String sn = "" + r + c;
                SeatType type = (c > 7) ? SeatType.PREMIUM : SeatType.REGULAR;
                seats.add(new Seat(sn, type));
            }
        }

        // price map
        Map<SeatType, Double> priceMap = new HashMap<>();
        priceMap.put(SeatType.REGULAR, 100.0);
        priceMap.put(SeatType.PREMIUM, 200.0);

        // create show
        Show show = new Show("show1", movie, LocalDateTime.now().plusHours(2), seats, priceMap);

        // create screen and theatre
        Screen screen = new Screen("screen1", "Screen 1");
        screen.addShow(show);
        Theatre theatre = new Theatre("t1", "PVR Mall", "Mumbai");
        theatre.addScreen(screen);

        // create controller and register theatre
        BookMyShow service = new BookMyShow();
        service.addTheatre(theatre); // registers show's map too

        // print available shows
        System.out.println("Shows for movie: " + movie.getTitle());
        List<Show> found = service.searchShowsByMovie("Mumbai", "The Great Escape");
        service.printShows(found);

        // try booking seats
        List<String> seatsToBook = Arrays.asList("A1", "A2", "A8");
        Booking booking = service.bookTickets("show1", seatsToBook);
        if (booking != null) {
            System.out.println("Booked: " + booking.getId() + " Amount: " + booking.getTotalAmount());
        }

        // attempt conflicting booking for same seats
        Booking b2 = service.bookTickets("show1", Arrays.asList("A2", "A3"));
        // If A2 was already reserved, this should fail (return null)

        // cancel booking and free seats
        if (booking != null) {
            service.cancelBooking(booking.getId());
            // someone else can now book A1/A2/A8
            Booking b3 = service.bookTickets("show1", Arrays.asList("A1", "A2"));
            if (b3 != null) {
                System.out.println("New booking after cancellation: " + b3.getId() + " Amount: " + b3.getTotalAmount());
            }
        }
    }
}
