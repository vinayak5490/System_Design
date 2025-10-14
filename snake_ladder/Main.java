package snake_ladder;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Snake> snakes = Arrays.asList(
                new Snake(14, 7),
                new Snake(31, 10),
                new Snake(38, 20),
                new Snake(84, 28),
                new Snake(96, 42)
        );

        List<Ladder> ladders = Arrays.asList(
            new Ladder(3, 22),
            new Ladder(5, 8),
            new Ladder(11, 26),
            new Ladder(20, 29),
            new Ladder(27, 56)
        );

        List<Player> players = Arrays.asList(
                new Player("Alice"),
                new Player("Bob"));

        Board board = new Board(100, snakes, ladders);
        Dice dice = new Dice(6);

        Game game = new Game(players, board, dice);
        game.startGame();
    }
}
