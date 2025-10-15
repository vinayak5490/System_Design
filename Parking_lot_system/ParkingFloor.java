package Parking_lot_system;
import java.util.*;
public class ParkingFloor {
    private int floorNumber;
    private List<ParkingSlot> slots;

    public ParkingFloor(int floorNumber, List<ParkingSlot> slots){
        this.floorNumber = floorNumber;
        this.slots = slots;
    }

    public ParkingSlot getAvailableSlot(VehicleType type){
        for(ParkingSlot slot : slots){
            if(slot.isAvailable() && matchesType(slot, type)){
                return slot;
            }
        }
        return null;
    }

    private boolean matchesType(ParkingSlot slot, VehicleType type){
        return (type == VehicleType.BIKE && slot.getType() == SlotType.BIKE)
        || (type == VehicleType.CAR && slot.getType() == SlotType.COMPACT)
        || (type == VehicleType.TRUCK && slot.getType() == SlotType.LARGE);
    }

    public void displayAvailability(){
        long available =0;
        for(ParkingSlot slot : slots){
            if(slot.isAvailable()){
                available++;
            }
        }
        System.out.println("Floor " + floorNumber + " has " + available + " available slots.");
    }
}
