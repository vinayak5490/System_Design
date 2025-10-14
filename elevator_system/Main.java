package elevator_system;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem system = new ElevatorSystem(2);
        system.requestElevator(3, Direction.UP);
        system.requestElevator(5, Direction.DOWN);
        system.requestElevator(1, Direction.UP);
    }
}
