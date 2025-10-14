package elevator_system;
import java.util.*;
public class Elevator {
    private int id;
    private int currentFloor;
    private TreeSet<Integer> upStops;
    private TreeSet<Integer> downStops;
    private ElevatorState state;
    private Direction direction;

    public Elevator(int id){
        this.id = id;
        this.currentFloor = 0;
        this.upStops = new TreeSet<>();
        this.downStops = new TreeSet<>(Collections.reverseOrder());
        this.state = ElevatorState.IDLE;
        this.direction = Direction.NONE;
    }

    public int getId(){
        return id;
    }
    public int getCurrentFloor(){
        return currentFloor;
    }
    public ElevatorState getState(){
        return state;
    }

    public void addNewRequest(Request req){
        if(req.floor > currentFloor){
            upStops.add(req.floor);
        }
        else if(req.floor < currentFloor){
            downStops.add(req.floor);
        }
        move();
    }

    private void move(){
        while(!upStops.isEmpty() || !downStops.isEmpty()){
            if(direction == Direction.UP || state == ElevatorState.IDLE){
                moveUp();
            }else if(direction == Direction.DOWN){
                moveDown();
            }
        }
        direction = Direction.NONE;
        state = ElevatorState.IDLE;
        System.out.println("Elevator " + id + " is now IDLE at floor " + currentFloor);
    }

    private void moveUp(){
        state = ElevatorState.MOVING_UP;
        direction = Direction.UP;
        while(!upStops.isEmpty()){
            int next = upStops.pollFirst();
            currentFloor = next;
            System.out.println("Elevator " + id + " reached floor " + currentFloor);
        }
    }

    private void moveDown(){
        state = ElevatorState.MOVING_DOWN;
        direction = Direction.DOWN;
        while(!downStops.isEmpty()){
            int next = downStops.pollFirst();
            currentFloor = next;
            System.out.println("Elevator " + id + " reached floor " + currentFloor);
        }
    }
}

