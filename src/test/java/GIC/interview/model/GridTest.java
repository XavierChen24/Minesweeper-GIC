package GIC.interview.model;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    //Providing a seed for the random feature
    final Random notRandom = new Random(1);

    @Test
    public void testGenerateGridDimensions() {
        int size = 5;
        int mines = 3;

        Grid grid = new Grid(size, mines, notRandom);

        assertEquals(size = grid.getSquares().length, size, "Grid rows should be the same as size");
        assertEquals(size = grid.getSquares()[0].length, size, "Grid columns should be the same as size");

    }

    @Test
    public void testMinesCount() {
        int size = 5;
        int mines = 3;
        Grid grid = new Grid(size, mines, notRandom);
        int count = 0;
        for (int i = 0; i < grid.getSquares().length; i++) {
            for (int j = 0; j < grid.getSquares()[0].length; j++) {
                if (grid.getSquares()[i][j].getIsMine()) {
                    count++;
                }
            }
        }
        assertEquals(mines, count, "Mines count should be the same as the number generated");

        size = 10;
        mines = 35;
        grid = new Grid(size, mines, notRandom);
        count = 0;
        for (int i = 0; i < grid.getSquares().length; i++) {
            for (int j = 0; j < grid.getSquares()[0].length; j++) {
                if (grid.getSquares()[i][j].getIsMine()) {
                    count++;
                }
            }
        }
        assertEquals(mines, count, "Mines count should be the same as the number generated");
    }

}