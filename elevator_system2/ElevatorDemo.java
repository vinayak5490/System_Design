package elevator_system2;

public class ElevatorDemo {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(2);

        controller.requestElevator(5);
        controller.requestElevator(3);

        for(int i=0; i<7; i++){
            controller.step();
        }
    }
}
