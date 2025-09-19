package GIC.interview.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.PrintStream;
import java.net.CookieManager;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandProcessorTest {

    final private CommandProcessor commandProcessor = new CommandProcessor();

    @Test
    void processInputs() {
        String simulatedInput = String.join("\n",
                "4", //Size of the grid
                "3",    //Number of mines
                "D4",   //First selected square
                "B1",   //Second selected square
                "A1",   //Third selected square
                "D1",   //Last selected square
                " \n");
        Scanner mockScanner = new Scanner(simulatedInput);
    }

    @Test
    public void validateInitialInputTests() {
        assertAll("Validation scenarios",
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateInitialInput(0, 10);
                    });
                    assertEquals("Only positive non-zero values are accepted", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateInitialInput(10, 0);
                    });
                    assertEquals("Only positive non-zero values are accepted", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateInitialInput(-1, 10);
                    });
                    assertEquals("Only positive non-zero values are accepted", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateInitialInput(10, -1);
                    });
                    assertEquals("Only positive non-zero values are accepted", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateInitialInput(10, -1);
                    });
                    assertEquals("Only positive non-zero values are accepted", exception.getMessage());
                },
                () -> {
                    Assertions.assertDoesNotThrow(() -> {
                        commandProcessor.validateInitialInput(10, 35);
                    }, "When the mines is 35% of the grids, it should not throw an error");
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateInitialInput(10, 36);
                    });
                    assertEquals("Maximum mines is 35% of the total squares", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateInitialInput(2, 1);
                    });
                    assertEquals("Minimum size is 3 and maximum size is 26", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateInitialInput(27, 9);
                    });
                    assertEquals("Minimum size is 3 and maximum size is 26", exception.getMessage());
                }
        );
    }



}