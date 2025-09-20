package GIC.interview.model;

import org.junit.jupiter.api.Assertions;
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

    @Test
    public void validateSquareSelectionTest() {
        int size = 5;
        assertAll("Validation scenarios for square selection",
                () -> {
                    Assertions.assertDoesNotThrow(() -> {
                        commandProcessor.validateSquareSelection(size, "E1");
                    }, "E1 in a grid size 5 should be a valid grid selection");
                },
                () -> {
                    Assertions.assertDoesNotThrow(() -> {
                        commandProcessor.validateSquareSelection(size, "A1");
                    }, "A1 in a grid size 5 should be a valid grid selection");
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateSquareSelection(size, "F1");
                    }, "Should throw an error when the input is outside of the specified size");
                    assertEquals("Invalid field selected. Please input a valid square. (e.g. A1)", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateSquareSelection(size, "F!");
                    }, "Should not allow non alphanumeric inputs.");
                    assertEquals("Invalid field selected. Please input a valid square. (e.g. A1)", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateSquareSelection(size, "!F");
                    }, "Should not allow non alphanumeric inputs.");
                    assertEquals("Invalid field selected. Please input a valid square. (e.g. A1)", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateSquareSelection(size, "1F");
                    }, "Should throw an error when the input is outside of the specified size");
                    assertEquals("Invalid field selected. Please input a valid square. (e.g. A1)", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateSquareSelection(size, "!!");
                    },"Should not allow non alphanumeric inputs.");
                    assertEquals("Invalid field selected. Please input a valid square. (e.g. A1)", exception.getMessage());
                },
                () -> {
                    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                        commandProcessor.validateSquareSelection(size, "1.1F");
                    },"Decimal numbers should throw an error too");
                    assertEquals("Invalid field selected. Please input a valid square. (e.g. A1)", exception.getMessage());
                },
                () -> {
                    SquareSelection input = commandProcessor.validateSquareSelection(size, "A1");

                    assertEquals(0, input.getX());
                    assertEquals(0, input.getY());

                },
                () -> {
                    SquareSelection input = commandProcessor.validateSquareSelection(size, "B2");

                    assertEquals(1, input.getX());
                    assertEquals(1, input.getY());

                }
        );
    }


}