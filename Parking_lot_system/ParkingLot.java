package Parking_lot_system;
import java.util.*;
public class ParkingLot {
    private List<ParkingFloor> floors;
    private Map<String, Ticket> activeTickets = new HashMap<>();

    public ParkingLot(int numFloors, int slotsPerFloor){
        this.floors = new ArrayList<>();
        for(int i=0; i<numFloors; i++){
            List<ParkingSlot> slots = new ArrayList<>();
            for(int j=1; j<=slotsPerFloor; j++){
                SlotType type = (j%3 == 0)? SlotType.LARGE: (j%2 == 0) ? SlotType.COMPACT : SlotType.BIKE;
                slots.add(new ParkingSlot(j, type));
            }
            floors.add(new ParkingFloor(i+1, slots));
        }
    }

    public Ticket parkVehicle(Vehicle vehicle){
        for(ParkingFloor floor : floors){
            ParkingSlot slot = floor.getAvailableSlot(vehicle.getType());
            if(slot != null){
                slot.parkVehicle(vehicle);
                Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, slot);
                activeTickets.put(ticket.getTicketId(), ticket);
                System.out.println("Ticket issued: " + ticket.getTicketId());
                return ticket;
            }
        }
        System.out.println("No available slot for " + vehicle.getVehicleNumber());
        return null;
    }

    public void unparkVehicle(String ticketId){
        Ticket ticket = activeTickets.remove(ticketId);
        if(ticket == null){
            System.out.println("Invalid ticket!");
            return;
        }

        ParkingSlot slot = ticket.getSlot();
        slot.freeSlot();

        long duration = ticket.getParkingDuration();
        double charge = Payment.calculateCharges(duration, ticket.getVehicle().getType());
        System.out.println("Parking duration: " + duration + "s | Charges: ₹" + charge);
    }

    public void showAvailability(){
        for(ParkingFloor floor : floors){
            floor.displayAvailability();
        }
    }
}
