package tictactoe;
import java.util.*;
public class TicTacToe {
    private Board board;
    private Queue<Player> players;
    private GameStatus status;

    public TicTacToe(){
        board = new Board(3);
        players = new LinkedList<>();
        players.add(new Player("Player 1", new Piece(PieceType.X)));
        players.add(new Player("Player 2", new Piece(PieceType.O)));
        status = GameStatus.IN_PROGRESS;
    }

    public void startGame(){
        Scanner sc = new Scanner(System.in);
        while(status == GameStatus.IN_PROGRESS){
            board.printBoard();
            Player current = players.poll();
            System.out.println(current.getName() + "'s turn (" + current.getPiece().getType() + "):");
            System.out.print("Enter row and column (0-based): ");
            int row = sc.nextInt(), col = sc.nextInt();

            boolean placed = board.placePiece(row, col, current.getPiece());
            if(!placed){
                System.out.println("Invalid move! Try again.");
                players.add(current);
                continue;
            }

            if(board.checkWin(current.getPiece())){
                board.printBoard();
                System.out.println(current.getName() + " wins!");
                status = GameStatus.WIN;
                break;
            }

            if(board.isFull()){
                board.printBoard();
                System.out.println("It's a draw!");
                status = GameStatus.DRAW;
                break;
            }
            players.add(current);
        }
    }
}
