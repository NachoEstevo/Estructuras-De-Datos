package HorseMovement;

public class Position {
    private int row;
    private int column;

    public Position(int column, int row){ //It is like a point x,y
        this.row = row;
        this.column = column;
    }
    public Position(String column, int row){
        this.column = columnToNumber(column);
        this.row = row;
    }
    public Position(String column, String row){
        this.column = columnToNumber(column);
        this.row = Integer.parseInt(row);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    public String columnToString() {

        switch (column) {
            case 1 -> { return "A"; }
            case 2 -> { return "B"; }
            case 3 -> { return "C"; }
            case 4 -> { return "D"; }
            case 5 -> { return "E"; }
            case 6 -> { return "F"; }
            case 7 -> { return "G"; }
            case 8 -> { return "H"; }
            default -> {
                System.out.println("Casilla invalida");
                return null;
            }
        }
    }
    public int columnToNumber(String column){
        switch (column){
            case "A" -> { return 1; }
            case "B" -> { return 2; }
            case "C" -> { return 3; }
            case "D" -> { return 4; }
            case "E" -> { return 5; }
            case "F" -> { return 6; }
            case "G" -> { return 7; }
            case "H" -> { return 8; }
            default -> {
                System.out.println("Casilla invalida");
                return -1;
            }
        }
    }
    public String getPosition(){
        return this.columnToString() + getRow();
    }

    public String getNumberedPosition(){return  String.valueOf(getColumn()) +  String.valueOf(getRow());}

    public boolean isValid(){
        return (row >= 1 && row <= 8) && (column >= 1 && column <= 8);
    }
}
