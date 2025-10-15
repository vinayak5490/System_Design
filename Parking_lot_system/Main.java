package Parking_lot_system;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot lot = new ParkingLot(2, 6);

        Vehicle car = new Vehicle("MH12AB1234", VehicleType.CAR);
        Vehicle bike = new Vehicle("MH14XY5678", VehicleType.BIKE);

        Ticket t1 = lot.parkVehicle(car);
        Ticket t2 = lot.parkVehicle(bike);

        Thread.sleep(3000); // simulate parking time

        lot.unparkVehicle(t1.getTicketId());
        lot.unparkVehicle(t2.getTicketId());

        lot.showAvailability();
    }
}
