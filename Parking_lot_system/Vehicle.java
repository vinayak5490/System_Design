package Parking_lot_system;

public class Vehicle {
    private String vehicleNumber;
    private VehicleType type;

    public Vehicle(String vehicleNumber, VehicleType type){
        this.vehicleNumber = vehicleNumber;
        this.type = type;
    }

    public String getVehicleNumber(){
        return vehicleNumber;
    }

    public VehicleType getType(){
        return type;
    }
}
