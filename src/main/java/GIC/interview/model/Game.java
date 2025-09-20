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
    public void printGrid() {
        StringBuilder sb = new StringBuilder();

        int size = this.grid.getSize();
        sb.append("  ");
        for (int i = 0; i < size; i++) {
            sb.append(i + 1).append(" ");
        }
        sb.append("\n");
        Square[][] grid = this.grid.getSquares();
        for (int i = 0; i < grid.length; i++) {
            sb.append((char) ('A' + i));
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].isRevealed()) {
                    String adjacentMines = String.valueOf(grid[i][j].getAdjacentMines());
                    sb.append(" ").append(adjacentMines);
                }else {
                    sb.append(" ").append('-');
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    //Checks if the game has been won/lost/continue
    public void processResults(){}

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void playGame(SquareSelection selectedSquare) {

    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    //When the user selects a 0, the surrounding should open up till it reaches a non-zero number
    //Recursively flood fill algorithm
    public void floodFill(){

    }

    //Checks if the row and column is within the dimensions of the grid.
    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < grid.getSize() && col >= 0 && col < grid.getSize();
    }


}
