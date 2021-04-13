package HorseMovement;

public class Position {
    private int row;
    private int column;

    public Position(int column, int row){ //It is like a point x,y
        this.row = row;
        this.column = column;
    }
    public Position(String column, int row) throws OutOfBoardException {
        columnToNumber(column.toUpperCase());
        this.row = row;
    }
    public Position(String col, String row) throws OutOfBoardException {
        columnToNumber(col.toUpperCase());
        this.row = Integer.parseInt(row);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String columnToString() throws OutOfBoardException {

        switch (getColumn()) {
            case 1 -> { return "A"; }
            case 2 -> { return "B"; }
            case 3 -> { return "C"; }
            case 4 -> { return "D"; }
            case 5 -> { return "E"; }
            case 6 -> { return "F"; }
            case 7 -> { return "G"; }
            case 8 -> { return "H"; }
            default -> {throw new OutOfBoardException("The value is not in the board");}
        }

    }
    public void columnToNumber(String col) throws OutOfBoardException {

        switch (col){
            case "A" -> { this.column = 1; }
            case "B" -> { this.column = 2; }
            case "C" -> { this.column = 3; }
            case "D" -> { this.column = 4; }
            case "E" -> { this.column = 5; }
            case "F" -> { this.column = 6; }
            case "G" -> { this.column = 7; }
            case "H" -> { this.column = 8; }
            default -> {throw new OutOfBoardException("The value is not in the board");}
        }
    }
    public String getPosition() throws OutOfBoardException { return this.columnToString() + String.valueOf(getRow());}

    public String getNumberedPosition(){return  String.valueOf(getColumn()) +  String.valueOf(getRow());}

    public boolean isValid(){
        return (row >= 1 && row <= 8) && (column >= 1 && column <= 8);
    }

}
