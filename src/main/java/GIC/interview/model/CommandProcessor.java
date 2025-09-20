package GIC.interview.model;

import java.util.Scanner;

public class CommandProcessor {
    private Game game;
    //This function takes in user inputs
    public void processInputs() {
        int size;
        int minesCount;
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
                System.out.println("\nHere is your minefield:");

            } catch (NumberFormatException e) {
                System.out.println("Invalid input detected, please retry.");
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            while (game.getGameStatus() == GameStatus.CONTINUE) {
                try {
                    game.printGrid();
                    System.out.print("Select a square to reveal (e.g. A1): ");
                    String selectionInput = scanner.nextLine();

                    SquareSelection selectedSquare = validateSquareSelection(size, selectionInput);

                    game.playGame(selectedSquare);
                    if (game.getGameStatus() == GameStatus.LOSE) {
                        System.out.println("Oh no, you detonated a mine! Game over.");
                        break;
                    } else if (game.getGameStatus() == GameStatus.WIN) {
                        System.out.println("Congratulations, you have won the game!");
                        break;
                    }
                    System.out.println("Here is your updated minefield:");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("Press enter key to play again...");
            scanner.nextLine();
        }
    }

    //This function validates the grid dimension user input
    public void validateGridSize(int size) {
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
    public SquareSelection validateSquareSelection(int size, String input) {
        try {
            //Fetches the first character. Expecting (A-Z)
            char letter = input.charAt(0);
            //Fetches the remaining numbers. Expecting (1-26)
            int number = Integer.parseInt(input.substring(1));

            if (number < 1 || number > Math.min(size, 26) || letter < 'A' || letter >= 'A' + Math.min(size, 26)) {
                throw new IllegalArgumentException();
            }
            return new SquareSelection(number - 1, letter - 'A');
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid field selected. Please input a valid square. (e.g. A1)");
        }
    }

}
