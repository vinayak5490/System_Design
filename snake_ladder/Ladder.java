package snake_ladder;

public class Ladder {
    private int start;
    private int end;

    public Ladder(int start, int end){
        if(start >= end){
            throw new IllegalArgumentException("Ladder start must be below end!");
        }
        this.start = start;
        this.end = end;
    }

    public int getStart(){
        return start;
    }
    public int getEnd(){
        return end;
    }
}
