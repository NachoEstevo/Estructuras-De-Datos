package HorseMovement;

public class Cell {
    private char col;
    private int row;

    public Cell(int row, char col) {
        this.col = col;
        this.row = row;
    }

    public void setCol(char col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void sumCol(int sumCol) {
        int character = (int) col + sumCol;
        setCol((char)character);
    }

    public void sumRow(int sumRow) {
        setRow(row + sumRow);
    }
    public String toString(){
        return "" + col + row;
    }
    @Override
    public boolean equals(Object obj) {
        return row == ((Cell) obj).getRow() && col == ((Cell) obj).getCol();
    }
}
