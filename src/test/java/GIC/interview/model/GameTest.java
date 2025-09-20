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
        String expectedOutput = """
                  1 2 3 4 5\s
                A - - - - -
                B - - - - -
                C - - - - -
                D - - - - -
                E - - - - -
                """;
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
        String expectedOutput = """
                  1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26\s
                A - - - - - - - - - - - - - - - - - - - - - - - - - -
                B - - - - - - - - - - - - - - - - - - - - - - - - - -
                C - - - - - - - - - - - - - - - - - - - - - - - - - -
                D - - - - - - - - - - - - - - - - - - - - - - - - - -
                E - - - - - - - - - - - - - - - - - - - - - - - - - -
                F - - - - - - - - - - - - - - - - - - - - - - - - - -
                G - - - - - - - - - - - - - - - - - - - - - - - - - -
                H - - - - - - - - - - - - - - - - - - - - - - - - - -
                I - - - - - - - - - - - - - - - - - - - - - - - - - -
                J - - - - - - - - - - - - - - - - - - - - - - - - - -
                K - - - - - - - - - - - - - - - - - - - - - - - - - -
                L - - - - - - - - - - - - - - - - - - - - - - - - - -
                M - - - - - - - - - - - - - - - - - - - - - - - - - -
                N - - - - - - - - - - - - - - - - - - - - - - - - - -
                O - - - - - - - - - - - - - - - - - - - - - - - - - -
                P - - - - - - - - - - - - - - - - - - - - - - - - - -
                Q - - - - - - - - - - - - - - - - - - - - - - - - - -
                R - - - - - - - - - - - - - - - - - - - - - - - - - -
                S - - - - - - - - - - - - - - - - - - - - - - - - - -
                T - - - - - - - - - - - - - - - - - - - - - - - - - -
                U - - - - - - - - - - - - - - - - - - - - - - - - - -
                V - - - - - - - - - - - - - - - - - - - - - - - - - -
                W - - - - - - - - - - - - - - - - - - - - - - - - - -
                X - - - - - - - - - - - - - - - - - - - - - - - - - -
                Y - - - - - - - - - - - - - - - - - - - - - - - - - -
                Z - - - - - - - - - - - - - - - - - - - - - - - - - -
                """;
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
        String expectedOutput = """
                  1 2 3 4\s
                A 0 0 0 0
                B 1 1 0 0
                C - 1 0 0
                D - 1 0 0
                """;
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
        String expectedOutput = """
                  1 2 3 4\s
                A - - - -
                B - - - -
                C - - - -
                D 1 - - -
                """;
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
        String expectedOutput = """
                  1 2 3 4\s
                A - - - -
                B - - - -
                C - - - -
                D - - - -
                """;
        assertEquals(expectedOutput, captureAssert(newGame), "All fields should not be revealed or changed");
        assertEquals(15, nonRandomGrid.getSpacesLeft(), "Expected all fields to be closed and 1 mine. Thus its 4X4-1");
    }

    @Test
    void floodFillTest_negativeFlow2() {
        //Flood fill should do nothing when it hit an already revealed square
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
        String expectedOutput = """
                  1 2 3 4\s
                A - - - -
                B 1 - - -
                C - - - -
                D - - - -
                """;
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
    void isInBoundsTest() {
        int size = 4;
        int minesCount = 1;

        Game newGame = new Game(size, minesCount);
        assertTrue(newGame.isInBounds(0, 0), "0,0 is within the size of 4");
        assertFalse(newGame.isInBounds(4, 0), "4,0 is outside of the size of 4");
        assertFalse(newGame.isInBounds(0, 4), "0,4 is outside of the size of 4");
        assertFalse(newGame.isInBounds(-1, -1000), "0,4 is outside of the size of 4");

    }

    @Test
    void testPlayGame_win1() {
        //The following is a full game with flood fill with 2 inputs.
        int size = 4;
        int minesCount = 1;
        Random notRandom = new Random(1);

        Grid nonRandomGrid = new Grid(size, minesCount, notRandom);
        Game newGame = new Game(size, minesCount);

        newGame.setGrid(nonRandomGrid);
        //Display the hidden board for debugging purposes
        printRevealedGrid(nonRandomGrid);

        //Displays the entire hidden grid.
        System.out.println("Current unrevealed grid is below");
        newGame.printGrid();

        //Player selects the field that should be flood filled.
        newGame.playGame(new SquareSelection(0, 0));
        System.out.println("Selected A1");
        //Displays the entire hidden grid.
        System.out.println("Current unrevealed grid is below");
        newGame.printGrid();

        // Assert: Compare output
        String expectedOutput = """
                  1 2 3 4\s
                A 0 0 0 0
                B 1 1 0 0
                C - 1 0 0
                D - 1 0 0
                """;
        assertEquals(expectedOutput, captureAssert(newGame), "14 cells should be revealed leaving one bomb and one hidden");
        assertEquals(1, nonRandomGrid.getSpacesLeft(), "Should leave one unrevealed square");
        assertEquals(GameStatus.CONTINUE, newGame.getGameStatus(), "One square is unrevealed, thus the game status should be to continue");


        //Player selects the last field that is a square
        newGame.playGame(new SquareSelection(0, 3));
        System.out.println("Selected D1");
        // Assert: Compare output

        //Displays the entire hidden grid.
        System.out.println("Current unrevealed grid is below");
        newGame.printGrid();

        expectedOutput = """
                  1 2 3 4\s
                A 0 0 0 0
                B 1 1 0 0
                C - 1 0 0
                D 1 1 0 0
                """;

        assertEquals(expectedOutput, captureAssert(newGame), "all 15 Cells should be revealed.");
        assertEquals(0, nonRandomGrid.getSpacesLeft(), "There should be no more squares left");
        assertEquals(GameStatus.WIN, newGame.getGameStatus(), "All cells are opened, the game should be considered won");
    }

    @Test
    void testPlayGame_lose1() {
        //The following is a full game with flood fill with 2 inputs, on the 2nd input, click a bomb.
        int size = 4;
        int minesCount = 1;
        Random notRandom = new Random(1);

        Grid nonRandomGrid = new Grid(size, minesCount, notRandom);
        Game newGame = new Game(size, minesCount);

        newGame.setGrid(nonRandomGrid);
        //Display the hidden board for debugging purposes
        printRevealedGrid(nonRandomGrid);

        //Displays the entire hidden grid.
        System.out.println("Current unrevealed grid is below");
        newGame.printGrid();

        //Player selects the field that should be flood filled.
        newGame.playGame(new SquareSelection(0, 0));
        System.out.println("Selected A1");

        //Displays the entire hidden grid.
        System.out.println("Current unrevealed grid is below");
        newGame.printGrid();

        // Assert: Compare output
        String expectedOutput = """
                  1 2 3 4\s
                A 0 0 0 0
                B 1 1 0 0
                C - 1 0 0
                D - 1 0 0
                """;
        assertEquals(expectedOutput, captureAssert(newGame), "14 cells should be revealed leaving one bomb and one hidden");
        assertEquals(1, nonRandomGrid.getSpacesLeft(), "Should leave one unrevealed square");
        assertEquals(GameStatus.CONTINUE, newGame.getGameStatus(), "One square is unrevealed, thus the game status should be to continue");


        //Player selects the last field that is a square
        newGame.playGame(new SquareSelection(0, 2));
        System.out.println("Selected C1");
        // Assert: Compare output

        //Displays the entire hidden grid.
        System.out.println("Current unrevealed grid is below");
        newGame.printGrid();

        expectedOutput = """
                  1 2 3 4\s
                A 0 0 0 0
                B 1 1 0 0
                C - 1 0 0
                D - 1 0 0
                """;

        assertEquals(expectedOutput, captureAssert(newGame), "14 cells should be revealed leaving one bomb and one hidden");
        assertEquals(1, nonRandomGrid.getSpacesLeft(), "Should leave one unrevealed square");
        assertEquals(GameStatus.LOSE, newGame.getGameStatus(), "All cells are opened, the game should be considered won");
    }

    @Test
    void testPlayGame_win2() {
        //When the user selects one square, and it flood fills all the squares
        int size = 10;
        int minesCount = 1;
        Random notRandom = new Random(3);

        Grid nonRandomGrid = new Grid(size, minesCount, notRandom);
        Game newGame = new Game(size, minesCount);

        newGame.setGrid(nonRandomGrid);
        //Display the hidden board for debugging purposes
        printRevealedGrid(nonRandomGrid);

        //Displays the entire hidden grid.
        System.out.println("Current unrevealed grid is below");
        newGame.printGrid();

        //Player selects the field that should be flood filled.
        newGame.playGame(new SquareSelection(0, 0));
        System.out.println("Selected A1");

        //Displays the entire hidden grid.
        System.out.println("Current unrevealed grid is below");
        newGame.printGrid();

        // Assert: Compare output
        String expectedOutput = """
                  1 2 3 4 5 6 7 8 9 10\s
                A 0 0 0 0 0 0 0 0 0 0
                B 0 0 0 0 0 0 0 0 0 0
                C 0 0 0 0 0 0 0 0 0 0
                D 1 1 0 0 0 0 0 0 0 0
                E - 1 0 0 0 0 0 0 0 0
                F 1 1 0 0 0 0 0 0 0 0
                G 0 0 0 0 0 0 0 0 0 0
                H 0 0 0 0 0 0 0 0 0 0
                I 0 0 0 0 0 0 0 0 0 0
                J 0 0 0 0 0 0 0 0 0 0
                """;
        assertEquals(expectedOutput, captureAssert(newGame), "14 cells should be revealed leaving one bomb and one hidden");
        assertEquals(0, nonRandomGrid.getSpacesLeft(), "All squares should be revealed.");
        assertEquals(GameStatus.WIN, newGame.getGameStatus(), "All cells are opened, the game should be considered won");

    }

    @Test
    void testPlayGame_error() {
        //When the user selects a previously selected square, it should throw an error.
        int size = 4;
        int minesCount = 1;
        Random notRandom = new Random(1);

        Grid nonRandomGrid = new Grid(size, minesCount, notRandom);
        Game newGame = new Game(size, minesCount);

        newGame.setGrid(nonRandomGrid);
        //Display the hidden board for debugging purposes
        printRevealedGrid(nonRandomGrid);

        //Displays the entire hidden grid.
        System.out.println("Current unrevealed grid is below");
        newGame.printGrid();

        //Player selects the field that should be flood filled.
        newGame.playGame(new SquareSelection(0, 0));
        System.out.println("Selected A1");

        //Displays the entire hidden grid.
        System.out.println("Current unrevealed grid is below");
        newGame.printGrid();

        // Assert: Compare output
        String expectedOutput = """
                  1 2 3 4\s
                A 0 0 0 0
                B 1 1 0 0
                C - 1 0 0
                D - 1 0 0
                """;
        assertEquals(expectedOutput, captureAssert(newGame), "14 cells should be revealed leaving one bomb and one hidden");
        assertEquals(1, nonRandomGrid.getSpacesLeft(), "Should leave one unrevealed square");
        assertEquals(GameStatus.CONTINUE, newGame.getGameStatus(), "One square is unrevealed, thus the game status should be to continue");


        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            System.out.println("Selected A1");
            //Player selects the last field that is a square
            newGame.playGame(new SquareSelection(0, 0));

        }, "Square selection for a already revealed square should throw error");
        assertEquals("Square has been previously selected", exception.getMessage());
    }
}