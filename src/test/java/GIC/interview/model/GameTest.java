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
    void testPlayGame() {
        int size = 4;
        int minesCount = 1;
        Random notRandom = new Random(1);

        Grid nonRandomGrid = new Grid(size, minesCount, notRandom);
        Game newGame = new Game(size, minesCount);

        newGame.setGrid(nonRandomGrid);
        newGame.printGrid();

        newGame.playGame(new SquareSelection(0,0));

        newGame.printGrid();

    }
}