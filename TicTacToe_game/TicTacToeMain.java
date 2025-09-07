package TicTacToe_game;
import java.util.*;
class Player{
    String name;
    char symbol;

    Player(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }
}

class Board{
    char[][] grid;
    int size;
    Board(int size){
        this.size = size;
        grid = new char[size][size];
        for(char[]row : grid)Arrays.fill(row, ' ');
    }

    void printBoard(){
        for(int i=0; i<size; i++){
            System.out.println(" " + grid[i][0] + " | " + grid[i][1] + " | " + grid[i][2]);
            if(i< size -1) System.out.println("---+---+---");
        }
    }
    boolean makeMove(int row, int col, char symbol){
        if(row < 0 || col < 0 || row >= size || col>= size || grid[row][col] != ' '){
            return false;
        }
        grid[row][col] = symbol;
        return true;
    }

    boolean checkWin(char sym){
        for(int i=0; i<size; i++){
            if(grid[i][0] == sym && grid[i][1] == sym && grid[i][2] == sym) return true;
            if(grid[0][i] == sym && grid[1][i] == sym && grid[2][i] == sym) return true;
        }
        return (grid[0][0] == sym && grid[1][1] == sym && grid[2][2] == sym) || (grid[0][2] == sym && grid[1][1] == sym && grid[2][0] == sym);
    }

    boolean isFull(){
        for(char[] row : grid){
            for(char c : row){
                if(c == ' ') return false;
            }
        }
        return true;
    }
}
public class TicTacToeMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Player p1 = new Player("Player 1", 'X');
        Player p2 = new Player("Player 2", 'O');
        Board board = new Board(3);

        Player current = p1;
        while(true){
            board.printBoard();
            System.out.println(current.name + " (" + current.symbol +") enter row and col(0-2): ");
            int r = sc.nextInt();
            int c = sc.nextInt();

            if(!board.makeMove(r, c, current.symbol)){
                System.out.println("Invalid move, try again.");
                continue;
            }

            if(board.checkWin(current.symbol)){
                board.printBoard();
                System.out.println(current.name + "wins!");
                break;
            }
            current = (current == p1) ? p2 : p1;
        }
    }
}