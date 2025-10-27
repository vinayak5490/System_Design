package BookMyShow;
import java.time.LocalDateTime;
import java.util.*;
public class Booking {
    private final String id;
    private final Show show;
    private final List<String> seatNumbers;
    private final double totalAmount;
    private BookingStatus status;
    private final LocalDateTime createdAt;

    public Booking(String id, Show show, List<String> seatNumbers, double totalAmount){
        this.id = id;
        this.show = show;
        this.seatNumbers = new ArrayList<>(seatNumbers);
        this.totalAmount = totalAmount;
        this.status = BookingStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }
    public String getId(){
        return id;
    }
    public Show getShow(){
        return show;
    }
    public List<String> getSeatNumbers(){
        return Collections.unmodifiableList(seatNumbers);
    }
    public double getTotalAmount(){
        return totalAmount;
    }
    public BookingStatus geStatus(){
        return status;
    }
    public void setStatus(BookingStatus status){
        this.status = status;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    @Override
    public String toString(){
        return "Booking{" + "id='" + id + '\'' + ", show=" + show.getId() + ", seats=" + seatNumbers + ", amount=" + totalAmount + ", status=" + status + '}';
    }
}

