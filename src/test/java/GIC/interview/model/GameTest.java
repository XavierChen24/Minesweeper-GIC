package GIC.interview.model;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void printGridSizeEquals5() {
        int size = 5;
        int minesCount = 5;
        // Arrange: Set up a stream to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Game game = new Game(size, minesCount);
        // Act: Call method that prints
        game.printGrid();

        // Restore original System.out
        System.setOut(originalOut);

        // Assert: Compare output
        String expectedOutput = "  1 2 3 4 5 \n" +
                "A - - - - -\n" +
                "B - - - - -\n" +
                "C - - - - -\n" +
                "D - - - - -\n" +
                "E - - - - -\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void printGridSizeEquals26() {
        int size = 26;
        int minesCount = 5;
        // Arrange: Set up a stream to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Game game = new Game(size, minesCount);
        // Act: Call method that prints
        game.printGrid();

        // Restore original System.out
        System.setOut(originalOut);

        // Assert: Compare output
        String expectedOutput = "  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 \n" +
                "A - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "B - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "C - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "D - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "E - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "F - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "G - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "H - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "I - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "J - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "K - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "L - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "M - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "N - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "O - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "P - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "Q - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "R - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "S - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "T - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "U - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "V - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "W - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "X - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "Y - - - - - - - - - - - - - - - - - - - - - - - - - -\n" +
                "Z - - - - - - - - - - - - - - - - - - - - - - - - - -\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void floodFillTest_positiveFlow() {
        //The following test case is for the flood fill for squares where it contains a 0
        int size = 4;
        int minesCount = 1;
        Random notRandom = new Random(1);

        Grid nonRandomGrid = new Grid(size, minesCount, notRandom);

        printRevealedGrid(nonRandomGrid);

        //declare a new game a set a seeded grid for same grid generation.
        Game newGame = new Game(size, minesCount);
        newGame.setGrid(nonRandomGrid);

        //Displays the entire hidden grid.
        System.out.println("Current unrevealed grid is below");
        newGame.printGrid();

        //Act of flood filling the grid
        newGame.floodFill(0, 0);

        //Print the output for debugging purposes
        newGame.printGrid();

        // Assert: Compare output
        String expectedOutput = "  1 2 3 4 \n" +
                "A 0 0 0 0\n" +
                "B 1 1 0 0\n" +
                "C - 1 0 0\n" +
                "D - 1 0 0\n";
        assertEquals(expectedOutput, captureAssert(newGame), "All fields should be revealed except 2 squares.");
        assertEquals(1, nonRandomGrid.getSpacesLeft(), "Expected 1 space left and 1 mine left.");
    }

    @Test
    void floodFillTest_positiveFlow2() {
        //The following is a test case for flood fill where the field selected is a non 0 value
        int size = 4;
        int minesCount = 1;
        Random notRandom = new Random(1);

        Grid nonRandomGrid = new Grid(size, minesCount, notRandom);

        printRevealedGrid(nonRandomGrid);

        //declare a new game a set a seeded grid for same grid generation.
        Game newGame = new Game(size, minesCount);
        newGame.setGrid(nonRandomGrid);

        //Displays the entire hidden grid.
        System.out.println("Current unrevealed grid is below");
        newGame.printGrid();

        //Act of flood filling the grid
        newGame.floodFill(3, 0);

        //Print the output for debugging purposes
        newGame.printGrid();

        // Assert: Compare output
        String expectedOutput = "  1 2 3 4 \n" +
                "A - - - -\n" +
                "B - - - -\n" +
                "C - - - -\n" +
                "D 1 - - -\n";
        assertEquals(expectedOutput, captureAssert(newGame), "All fields should be hidden except 1");
        assertEquals(14, nonRandomGrid.getSpacesLeft(), "Expected 14 space left and 1 mine left.");
    }


    @Test
    void floodFillTest_negativeFlow() {
        //FloodFill should not reveal the grid when it hits a bomb
        int size = 4;
        int minesCount = 1;
        Random notRandom = new Random(1);

        Grid nonRandomGrid = new Grid(size, minesCount, notRandom);

        printRevealedGrid(nonRandomGrid);

        //declare a new game a set a seeded grid for same grid generation.
        Game newGame = new Game(size, minesCount);
        newGame.setGrid(nonRandomGrid);

        //Displays the entire hidden grid.
        System.out.println("Current unrevealed grid is below");
        newGame.printGrid();

        //Selected a field with a bomb
        newGame.floodFill(2, 0);


        //Print the output for debugging purposes
        newGame.printGrid();

        // Assert: Compare output
        String expectedOutput = "  1 2 3 4 \n" +
                "A - - - -\n" +
                "B - - - -\n" +
                "C - - - -\n" +
                "D - - - -\n";
        assertEquals(expectedOutput, captureAssert(newGame), "All fields should not be revealed or changed");
        assertEquals(15, nonRandomGrid.getSpacesLeft(), "Expected all fields to be closed and 1 mine. Thus its 4X4-1");
    }

    @Test
    void floodFillTest_negativeFlow2() {
        //Floodfill should do nothing when it hit an already revealed square
        int size = 4;
        int minesCount = 1;
        Random notRandom = new Random(1);

        Grid nonRandomGrid = new Grid(size, minesCount, notRandom);
        //Set one square to be revealed that is non 0
        nonRandomGrid.getSquares()[1][0].reveal();
        nonRandomGrid.reduceSpacesLeft(1);

        printRevealedGrid(nonRandomGrid);

        //declare a new game a set a seeded grid for same grid generation.
        Game newGame = new Game(size, minesCount);
        newGame.setGrid(nonRandomGrid);

        //Displays the entire hidden grid.
        System.out.println("Current unrevealed grid is below");
        newGame.printGrid();

        //Selected a field with a bomb
        newGame.floodFill(1, 0);


        //Print the output for debugging purposes
        newGame.printGrid();

        // Assert: Compare output
        String expectedOutput = "  1 2 3 4 \n" +
                "A - - - -\n" +
                "B 1 - - -\n" +
                "C - - - -\n" +
                "D - - - -\n";
        assertEquals(expectedOutput, captureAssert(newGame), "All fields should not be revealed or changed");
        assertEquals(14, nonRandomGrid.getSpacesLeft(), "Expected all fields to be closed and 1 mine. Thus its 4X4-1");
    }

    //This function is to print the revealed grid for debugging purposes
    void printRevealedGrid(Grid grid) {
        System.out.println("Fully revealed generated Grid is the following, for debugging purposes");
        for (int i = 0; i < grid.getSize(); i++) {
            for (int j = 0; j < grid.getSize(); j++) {
                if (grid.getSquares()[i][j].getIsMine()) {
                    System.out.print("M" + ' ');
                } else {
                    System.out.print(String.valueOf(grid.getSquares()[i][j].getAdjacentMines()) + ' ');
                }
            }
            System.out.print("\n");
        }
    }

    //This function is to capture the system.out for string assertions
    String captureAssert(Game game) {
        //Start the capturing of the output stream
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        //Capturing the output from the print
        game.printGrid();

        // Restore original System.out
        System.setOut(originalOut);

        return outContent.toString();
    }

    @Test
    void isInBoundsTest() throws NoSuchMethodException {
        int size = 4;
        int minesCount = 1;

        Game newGame = new Game(size, minesCount);
        assertTrue(newGame.isInBounds(0, 0), "0,0 is within the size of 4");
        assertFalse(newGame.isInBounds(4, 0), "4,0 is outside of the size of 4");
        assertFalse(newGame.isInBounds(0, 4), "0,4 is outside of the size of 4");
        assertFalse(newGame.isInBounds(-1, -1000), "0,4 is outside of the size of 4");

    }

    @Test
    void testPlayGame() {
        int size = 4;
        int minesCount = 1;
        Random notRandom = new Random(1);

        Grid nonRandomGrid = new Grid(size, minesCount, notRandom);
        Game newGame = new Game(size, minesCount);

        newGame.setGrid(nonRandomGrid);
        newGame.printGrid();

        newGame.playGame(new SquareSelection(0, 0));

        newGame.printGrid();

    }
}