package elevator_system2;
import java.util.*;
public class Elevator {
    private final int id;
    private int currentFloor;
    private Direction direction;
    private final Queue<Integer> requests;

    public Elevator(int id){
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.requests = new LinkedList<>();
    }

    public int getId(){
        return id;
    }
    public int getCurrentFloor(){
        return currentFloor;
    }
    public Direction getDirection(){
        return direction;
    }

    public void addRequest(int floor){
        requests.offer(floor);
        updateDirection();
    }
    private void updateDirection(){
        if(requests.isEmpty()){
            direction = Direction.IDLE;
        }else if(currentFloor < requests.peek()){
            direction = Direction.UP;
        }else if(currentFloor > requests.peek()){
            direction = Direction.DOWN;
        }
    }

    public void move(){
        if(requests.isEmpty()){
            direction = Direction.IDLE;
            return;
        }
        int target = requests.peek();
        if(currentFloor < target){
            currentFloor++;
            direction = Direction.UP;
        }else if(currentFloor > target){
            currentFloor--;
            direction = Direction.DOWN;
        }else{
            requests.poll(); // reached
        }

    }
}
