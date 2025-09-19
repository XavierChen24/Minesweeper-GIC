package GIC.interview.model;

import java.util.Random;

public class Grid {
    private Square[][] squares;
    private int size;
    private int spacesLeft;
    private int mines;

    public Grid(int size, int minesCount, Random random) {
        this.squares = generateGrid(size, minesCount, random);
        this.size = size;
        this.mines = minesCount;
        this.spacesLeft = size * size - minesCount;
    }

    public Square[][] generateGrid(int size, int mines, Random random) {
        //Create a the minefield grid
        Square[][] newGrid = new Square[size][size];

        //Initialize with empty fields
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newGrid[i][j] = new Square();
            }
        }

        int minesPlaced = 0;

        while (minesPlaced < mines) {
            int row = random.nextInt(size);
            int col = random.nextInt(size);

            // If this position doesn't already have a mine, place one
            if (!newGrid[row][col].getIsMine()) {
                newGrid[row][col].setIsMine();
                minesPlaced++;

                // Update adjacent cell counts
                updateAdjacentCells(newGrid, row, col);
            }
        }
        return newGrid;
    }

    private void updateAdjacentCells(Square[][] grid, int mineRow, int mineCol) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check all 8 adjacent cells
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Skip the mine cell itself

                int adjRow = mineRow + i;
                int adjCol = mineCol + j;

                // Check if adjacent cell is within bounds and not a mine
                if (adjRow >= 0 && adjRow < rows && adjCol >= 0 && adjCol < cols) {
                    if (!grid[adjRow][adjCol].getIsMine()) {
                        // Convert char to int, increment, and convert back to char
                        grid[adjRow][adjCol].setAdjacentMines(grid[adjRow][adjCol].getAdjacentMines() + 1);
                    }
                }
            }
        }
    }

    public Square[][] getSquares() {
        return squares;
    }

    public int getSize() {
        return size;
    }
}
