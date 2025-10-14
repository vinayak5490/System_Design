package snake_ladder;
import java.util.Random;
public class Dice {
    private int sides;
    private Random random;

    public Dice(int sides){
        this.sides = sides;
        this.random = new Random();
    }

    public int roll(){
        return random.nextInt(sides) + 1;
    }
}
