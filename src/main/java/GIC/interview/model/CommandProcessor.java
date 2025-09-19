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

                validateGridSize(size);
                System.out.println("Enter the number of mines to place on the grid (maximum is 35% of the total squares): ");
                minesCount = Integer.parseInt(scanner.nextLine());
                validateMinesInput(size, minesCount);

                game = new Game(size, minesCount);


            } catch (NumberFormatException e) {
                System.out.println("Invalid input detected, please retry.");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }


        }
    }

    //This function validates the grid dimension user input
    public void validateGridSize(int size){
        if (size < 3 || size > 26) {
            throw new IllegalArgumentException("Minimum size is 3 and maximum size is 26");
        }
    }

    //This function validates the bomb count and grid dimensions
    public void validateMinesInput(int size, int mines) {
        if (size <= 0 || mines <= 0) {
            throw new IllegalArgumentException("Only positive non-zero values are accepted");
        }
        if (size < 3 || size > 26) {
            throw new IllegalArgumentException("Minimum size is 3 and maximum size is 26");
        }
        if (mines > Math.floor(size * size * 0.35)) {
            throw new IllegalArgumentException("Maximum mines is 35% of the total squares");
        }
    }

    //This function validates the inputs for square selection
    public void validateSquareSelection(String input) {
    }

}
