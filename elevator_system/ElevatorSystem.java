package elevator_system;
import java.util.*;
    class ElevatorSystem {
    private List<Elevator> elevators;

    public ElevatorSystem(int numElevators){
        elevators = new ArrayList<>();
        for(int i=0; i<numElevators; i++){
            elevators.add(new Elevator(i));
        }
    }
    public void requestElevator(int floor, Direction direction){
        Elevator chosen = findNearestElevator(floor);
        System.out.println("Assigned elevator " + chosen.getId() + " to floor " + floor);
        chosen.addNewRequest(new Request(floor, direction));
    }

    private Elevator findNearestElevator(int floor){
        Elevator best = elevators.get(0);
        int minDistance = Integer.MAX_VALUE;
        for(Elevator e : elevators){
            int dist = Math.abs(e.getCurrentFloor()-floor);
            if(dist < minDistance){
                minDistance = dist;
                best = e;
            }
        }
        return best;
    }
}
