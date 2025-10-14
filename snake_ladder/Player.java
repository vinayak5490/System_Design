package snake_ladder;

public class Player {
    private String name;
    private int position;
    
    public Player(String name){
        this.name = name;
        this.position = 0;
    }

    public String getName(){
        return name;
    }
    public int getPosition(){
        return position;
    }

    public void move(int newPos){
        this.position = newPos;
    }
}
