package Parking_lot_system;

public class Payment {
    public static double calculateCharges(long duration, VehicleType type){
        double ratePerSecond;
        switch(type){
            case BIKE : ratePerSecond = 0.2; break;
            case CAR : ratePerSecond = 0.5; break;
            case TRUCK : ratePerSecond = 1.0; break;
            default: ratePerSecond = 0.5;
        }
        return duration * ratePerSecond;
    }
}
