package tictactoe;

public class Board {
    private int size;
    private Piece[][] grid;

    public Board(int size){
        this.size = size;
        grid = new Piece[size][size];
    }

    public boolean placePiece(int row, int col, Piece piece){
        if(row<0 || col<0 || row>=size || col>=size || grid[row][col] != null){
            return false;
        }
        grid[row][col] = piece;
        return true;
    }

    public boolean checkWin(Piece piece){
        PieceType type = piece.getType();

        //check rows
        for(int i=0; i<size; i++){
            boolean rowWin = true;
            for(int j=0; j<size; j++){
                if(grid[i][j] == null || grid[i][j].getType() != type){
                    rowWin = false;
                    break;
                }
            }
            if(rowWin) return true;
        }

        //check columns
        for(int j=0; j<size; j++){
            boolean colWin = true;
            for(int i=0; i<size; i++){
                if(grid[i][j] == null || grid[i][j].getType() != type){
                    colWin = false;
                    break;
                }
            }
            if(colWin) return true;
        }

        //check diagonals
        boolean diag1 = true, diag2 = true;
        for(int i=0; i<size; i++){
            if(grid[i][i] == null || grid[i][i].getType() != type) diag1 = false;
            if(grid[i][size-i-1] == null || grid[i][size-i-1].getType() != type) diag2 = false;
        }
        return diag1 || diag2;
    }

    public boolean isFull(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(grid[i][j] == null) return false;
            }
        }
        return true;
    }

    public void printBoard(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print(grid[i][j] == null ? "-" : grid[i][j].getType());
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
