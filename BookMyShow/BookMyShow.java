package BookMyShow;
import java.util.*;
import java.util.stream.Collectors;
public class BookMyShow {
    // city -> theatres
    private final Map<String, List<Theatre>> cityTheatres = new HashMap<>();
    //showId -> show
    private final Map<String, Show> shows = new HashMap<>();
    //bookingId -> Booking
    private final Map<String, Booking> bookings = new HashMap<>();

    public void addTheatre(Theatre theatre){
        cityTheatres.computeIfAbsent(theatre.getCity().toLowerCase(), k-> new ArrayList<>()).add(theatre);
        //register shows from theatre
        for(Screen sc : theatre.getScreens()){
            for(Show show : sc.getShows()){
                shows.put(show.getId(), show);
            }
        }
    }

    public List<Show> searchShowsByMovie(String city, String movieTitle) {
        List<Theatre> theatres = cityTheatres.getOrDefault(city.toLowerCase(), Collections.emptyList());
        List<Show> result = new ArrayList<>();
        for (Theatre t : theatres) {
            for (Screen s : t.getScreens()) {
                for (Show sh : s.getShows()) {
                    if (sh.getMovie().getTitle().equalsIgnoreCase(movieTitle)) {
                        result.add(sh);
                    }
                }
            }
        }
        return result;
    }

    public Booking bookTickets(String showId, List<String> seatNumbers) {
        Show show = shows.get(showId);
        if (show == null) {
            System.out.println("Show not found: " + showId);
            return null;
        }

        // Reserve seats atomically
        List<Seat> reserved = show.reserveSeats(seatNumbers);
        if (reserved == null) {
            System.out.println("Failed to reserve seats. They might be already booked.");
            return null;
        }
        // Calculate amount
        double total = 0.0;
        for (Seat s : reserved)
            total += show.getPriceForSeat(s);

        // Create booking
        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingId, show, seatNumbers, total);
        booking.setStatus(BookingStatus.CONFIRMED); // in real world would go through payment flow
        bookings.put(bookingId, booking);

        System.out.println("Booking confirmed: " + booking);
        return booking;
    }
    
    public Booking getBooking(String bookingId) {
        return bookings.get(bookingId);
    }

    public boolean cancelBooking(String bookingId) {
        Booking b = bookings.get(bookingId);
        if (b == null)
            return false;
        if (b.getStatus() == BookingStatus.CANCELLED)
            return false;

        // release seats on show
        Show show = b.getShow();
        show.releaseSeats(b.getSeatNumbers());
        b.setStatus(BookingStatus.CANCELLED);
        System.out.println("Booking cancelled: " + bookingId);
        return true;
    }
    
    public void printShows(Collection<Show> showList) {
        for (Show s : showList) {
            s.printSeatMap();
        }
    }
    
    // helper to register shows when manually creating theatre/screen before
    // addTheatre
    public void registerShow(Show show) {
        shows.put(show.getId(), show);
    }

}
