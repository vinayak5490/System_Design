package Parking_lot_system;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSlot slot;
    private long entryTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSlot slot){
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = System.currentTimeMillis();
    }


    public String getTicketId(){
        return ticketId;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    public ParkingSlot getSlot(){
        return slot;
    }

    public long getParkingDuration(){
        return (System.currentTimeMillis() - entryTime) / 1000; // in seconds
    }
}
