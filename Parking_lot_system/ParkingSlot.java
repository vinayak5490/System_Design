package Parking_lot_system;

public class ParkingSlot {
    private int slotId;
    private SlotType type;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSlot(int slotId, SlotType type){
        this.slotId = slotId;
        this.type = type;
        this.occupied = false;
        this.vehicle = null;
    }

    public boolean isAvailable(){
        return !occupied;
    }

    public void parkVehicle(Vehicle v){
        this.vehicle = v;
        this.occupied = true;
        System.out.println("Vehicle " + v.getVehicleNumber() + " parked at slot " + slotId);
    }

    public void freeSlot(){
        System.out.println("Slot " + slotId + " is now free.");
        this.vehicle = null;
        this.occupied = false;
    }

    public SlotType getType(){
        return type;
    }

    public int getSlotId(){
        return slotId;
    }
}
