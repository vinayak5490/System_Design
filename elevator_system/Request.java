package elevator_system;

public class Request {
    int floor;
    Direction direction;

    public Request(int floor, Direction direction){
        this.floor = floor;
        this.direction = direction;
    }
}
