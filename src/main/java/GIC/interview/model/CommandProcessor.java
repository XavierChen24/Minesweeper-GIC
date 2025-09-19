package GIC.interview.model;

import java.util.Scanner;

public class CommandProcessor {
    private Game game;
    private final Scanner scanner;

    public CommandProcessor() {
        this.scanner = new Scanner(System.in);
    }

    //This function takes in user inputs
    public void processInputs() {
        int size = 0;
        int minesCount = 0;
        System.out.println("Welcome to Minesweeper!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter the size of the grid (e.g. 4 for a 4x4 grid): ");
                size = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter the number of mines to place on the grid (maximum is 35% of the total squares): ");
                minesCount = Integer.parseInt(scanner.nextLine());
            }catch
        }
    }

    //This function validates the bomb count and grid dimensions
    public void validateInitialInput(int size, int mines) {

    }

    //This function validates the inputs for square selection
    public void validateSquareSelection() {
    }

}
