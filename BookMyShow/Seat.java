package BookMyShow;

public class Seat {
    private final String seatNumber;
    private final SeatType type;
    private boolean booked;

    public Seat(String seatNumber, SeatType type){
        this.seatNumber = seatNumber;
        this.type = type;
        this.booked = false;
    }

    public String getSeatNumber(){
        return seatNumber;
    }
    public SeatType getType(){
        return type;
    }
    public boolean isBooked(){
        return booked;
    }
    void markBooked(){
        this.booked = true;
    }
    void markFree(){
        this.booked = false;
    }

    @Override
    public String toString(){
        return seatNumber + "[" + type + (booked ? ",X" : ",O") + "]";
    }
}
