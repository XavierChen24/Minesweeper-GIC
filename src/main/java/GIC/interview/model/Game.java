package GIC.interview.model;

import java.util.Random;

public class Game {
    private GameStatus gameStatus;
    private Grid grid;

    public Game(int size, int minesCount) {
        Random random = new Random();
        grid = new Grid(size, minesCount, random);
        gameStatus = GameStatus.CONTINUE;
    }

    //Print the game results for the user
    public void printResults(){}

    //print the entire grid for the fields that is revealed
    public void printGrid(){}

    //Checks if the game has been won/lost/continue
    public void processResults(){}

    //
}
