package GIC.interview.model;

public class Square {
    private boolean revealed;
    private boolean isMine;
    private int adjacentMines;

    public Square() {
        this.revealed = false;
        this.isMine = false;
        this.adjacentMines = 0;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public boolean reveal() {
        return this.revealed = true;
    }

    public void setIsMine() {
        this.isMine = true;
    }

    public boolean getIsMine() {
        return this.isMine;
    }

    public void setAdjacentMines(int input) {
        this.adjacentMines = input;
    }

    public int getAdjacentMines() {
        return this.adjacentMines;
    }
}
