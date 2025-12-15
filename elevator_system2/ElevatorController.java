package elevator_system2;
import java.util.*;
public class ElevatorController {
    private final List<Elevator> elevators;

    public ElevatorController(int elevatorCount){
        elevators = new ArrayList<>();
        for(int i=0; i<elevatorCount; i++){
            elevators.add(new Elevator(i));
        }
    }

    public void requestElevator(int floor){
        Elevator elevator = selectElevator();
        elevator.addRequest(floor);
        System.out.println("Floor " + floor + " assigned to Elevator " + elevator.getId());
    }
    private Elevator selectElevator(){
        for(Elevator e : elevators){
            if(e.getDirection() == Direction.IDLE){
                return e;
            }
        }
        return elevators.get(0);
    }

    public void step(){
        for(Elevator e : elevators){
            e.move();
            System.out.println("Elevator " + e.getId() + " at floor " + e.getCurrentFloor());
        }
    }
}
