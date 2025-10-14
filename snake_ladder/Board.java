package snake_ladder;
import java.util.*;
public class Board {
    private int size;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(int size, List<Snake> snakes, List<Ladder> ladders){
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSize(){
        return size;
    }

    public int getNextPosition(int pos){
        for(Snake s : snakes){
            if(s.getHead() == pos){
                System.out.println("Oops ! Bitten by a snake");
                return s.getTail();
            }
        }

        for (Ladder l : ladders) {
            if (l.getStart() == pos) {
                System.out.println("Yay! climbed a Ladder");
                return l.getEnd();
            }
        }
        return pos;
    }

}
