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
    public void validateGridSizeTests() {
        assertAll("Validation scenarios for validateGridSize",
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateGridSize(0);
                    });
                    assertEquals("Minimum size is 3 and maximum size is 26", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateGridSize(-1);
                    });
                    assertEquals("Minimum size is 3 and maximum size is 26", exception.getMessage());
                },
                () -> {
                    Assertions.assertDoesNotThrow(() -> {
                        commandProcessor.validateGridSize(3);
                    }, "When the mines is 35% of the grids, it should not throw an error");
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateGridSize(27);
                    });
                    assertEquals("Minimum size is 3 and maximum size is 26", exception.getMessage());
                }
        );
    }

    @Test
    public void validateMinesInputTests() {
        assertAll("Validation scenarios for validateMinesInput",
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateMinesInput(0, 10);
                    });
                    assertEquals("Only positive non-zero values are accepted", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateMinesInput(10, 0);
                    });
                    assertEquals("Only positive non-zero values are accepted", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateMinesInput(-1, 10);
                    });
                    assertEquals("Only positive non-zero values are accepted", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateMinesInput(10, -1);
                    });
                    assertEquals("Only positive non-zero values are accepted", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateMinesInput(10, -1);
                    });
                    assertEquals("Only positive non-zero values are accepted", exception.getMessage());
                },
                () -> {
                    Assertions.assertDoesNotThrow(() -> {
                        commandProcessor.validateMinesInput(10, 35);
                    }, "When the mines is 35% of the grids, it should not throw an error");
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateMinesInput(10, 36);
                    });
                    assertEquals("Maximum mines is 35% of the total squares", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateMinesInput(2, 1);
                    });
                    assertEquals("Minimum size is 3 and maximum size is 26", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateMinesInput(27, 9);
                    });
                    assertEquals("Minimum size is 3 and maximum size is 26", exception.getMessage());
                }
        );
    }




}