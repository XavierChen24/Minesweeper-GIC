package GIC.interview.model;

import org.junit.jupiter.api.Test;


import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CommandProcessorTest {

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
        PrintStream mockOut = mock(PrintStream.class);
        
    }
}