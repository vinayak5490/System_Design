package snake_ladder;
import java.util.*;
public class Game {
    private Queue<Player> players;
    private Board board;
    private Dice dice;
    private Player winner;

    public Game(List<Player> players, Board board, Dice dice){
        this.players = new LinkedList<>(players);
        this.board = board;
        this.dice = dice;
        this.winner = null;
    }

    public void startGame(){
        System.out.println("Starting snake and Ladder Game");

        while(winner == null){
            Player current = players.poll();
            movePlayer(current);
            if(winner == null){
                players.offer(current);
            }
        }
        System.out.println("winner: " + winner.getName());
    }

    private void movePlayer(Player player){
        int roll = dice.roll();
        System.out.println(player.getName() + " rolled a " + roll);

        int nextPos = player.getPosition() + roll;
        if(nextPos > board.getSize()){
            System.out.println(player.getName() + " needs exact roll to finish!");
            return;
        }

        nextPos = board.getNextPosition(nextPos);
        player.move(nextPos);

        System.out.println(player.getName() + " moved to " + nextPos);

        if(nextPos == board.getSize()){
            winner = player;
        }
    }
}
