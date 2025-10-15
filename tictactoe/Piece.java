package tictactoe;

public class Piece {
    private PieceType type;

    public Piece(PieceType type){
        this.type = type;
    }
    public PieceType getType(){
        return type;
    }
    // @Override
    public String toString(){
        return type.toString();
    }
}
