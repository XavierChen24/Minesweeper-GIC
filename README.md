# Minesweeper Console Game
A classic Minesweeper game implemented in Java, designed to run in the console with a clean and intuitive interface. This implementation features all the traditional Minesweeper mechanics, including grid exploration, flagging, and mine avoidance.

## 🎮 Features
1. Able to specify the size of the grid
2. Able to specify the number of bombs
3. Win when all spaces are selected

## 🚀 Quick Start
```bash
git clone https://github.com/XavierChen24/Minesweeper-GIC.git
cd Minesweeper-GIC
docker build -t minesweeper-game . && docker run -it minesweeper-game
```
OR
```bash
git clone https://github.com/XavierChen24/Minesweeper-GIC.git
cd Minesweeper-GIC
mvn clean package && java -jar target/app-1.0-SNAPSHOT.jar
```

## 🎯 How to Play
1. Select the size of the grid.
2. Enter the number of mines in the grid
3. Select a square to reveal.
4. When there are no more squares to reveal.
5. YOU WIN!

## Brief explanation & assumptions
1. The vertical column will go from A-Z. Thus, the limit for size is 26.
2. The number of mines has to be more than 1. Otherwise, the game automatically ends, thus the mines count is larger than 0
3. The algorithm used to fill, check and display surrounding fields uses the flood fill algorithm.
4. For the class diagram, refer to the PDF attached.
5. There is no way to flag the mines.
6. Since we are using the terminal, there is no way of having the "any key to continue" due to the Java buffer. Thus, the button became enter.

## Environment requirements:
1. Minesweeper should be able to run on any operating system with Docker or Maven

## File Structure
```
.
├── Dockerfile                                          # Docker build configuration
├── LICENSE                                             # Project license
├── Minesweeper Class Diagram V1.2.pdf                  # UML or class diagram (PDF)
├── pom.xml                                             # Maven project configuration
├── README.md                                           # Project documentation
├── src
│   ├── main
│   │   ├── java
│   │   │   └── GIC.interview
│   │   │       ├── Minesweeper.java                   # Main application class
│   │   │       └── model
│   │   │           ├── CommandProcessor.java          # Handles user commands
│   │   │           ├── Game.java                      # Game engine logic
│   │   │           ├── GameStatus.java                # Enum or class for game state
│   │   │           ├── Grid.java                      # Represents the minefield grid
│   │   │           ├── Square.java                    # Single cell in the grid
│   │   │           └── SquareSelection.java           # User selection handler
│   │   └── resources                                   # (empty or used for configs)
│
│   └── test
│       └── java
│           └── GIC.interview.model
│               ├── CommandProcessorTest.java          # Unit tests for command processing
│               ├── GameTest.java                      # Unit tests for game logic
│               └── GridTest.java                      # Unit tests for grid behavior

```

## License
[MIT](https://choosealicense.com/licenses/mit/)