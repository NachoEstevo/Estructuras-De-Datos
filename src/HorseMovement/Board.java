package HorseMovement;

import DataStructures.Stacks.DynamicStack;

public class Board {
    boolean[][] board;

    public Board(){
        board = new boolean[8][8]; //We initialize a chess board of 8x8
    }

    public String getCurrentPosition() throws NoHorseAtBoardException {

        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                if (board[i][j]){
                    return toColumn(i) + j;
                }
            }
        }
        throw new NoHorseAtBoardException("There is no horse in the board");
    }
    public DynamicStack<String> moves(String position) {
        char column = position.toLowerCase().charAt(0);
        int numberOfColumna;

        int row = Character.getNumericValue(position.charAt(1));
        if (row>8 || row<1){
            System.out.println("Casilla invalida");
            return null;
        }

        switch (column) {
            case 'A' -> numberOfColumna = 1;
            case 'B' -> numberOfColumna = 2;
            case 'C' -> numberOfColumna = 3;
            case 'D' -> numberOfColumna = 4;
            case 'E' -> numberOfColumna = 5;
            case 'F' -> numberOfColumna = 6;
            case 'G' -> numberOfColumna = 7;
            case 'H' -> numberOfColumna = 8;
            default -> {
                System.out.println("Casilla invalida");
                return null;
            }
        }
        return searchForMovements(numberOfColumna,row);
    }

    private String toColumn(int column){
        String col = "";
        switch (column) {
            case 1 -> col = "A";
            case 2 -> col = "B";
            case 3 -> col = "C";
            case 4 -> col = "D";
            case 5 -> col = "E";
            case 6 -> col = "F";
            case 7 -> col = "G";
            case 8 -> col = "H";
            default -> {
                System.out.println("Casilla invalida");
                return null;
            }
        }
        return col;
    }
    private DynamicStack<String> searchForMovements(int column, int row) { //All the movements without checking if they are available or not
        DynamicStack<String> aStack = new DynamicStack<>();
        //North
        addValue((column+1),(row+2),aStack);
        addValue((column-1),(row+2), aStack);
        //South
        addValue((column+1),(row-2), aStack);
        addValue((column-1),(row-2), aStack);
        //West
        addValue((column-2),(row+1), aStack);
        addValue((column-2),(row-1), aStack);
        //East
        addValue((column+2),(row+1), aStack);
        addValue((column+2),(row-1), aStack);

        return aStack;
    }

    private void addValue(int columnToAdd, int rowToAdd, DynamicStack<String> aStack) {
        if (columnToAdd>0 && rowToAdd>0 && columnToAdd<9 && rowToAdd<9){
            String position = toColumn(columnToAdd) + rowToAdd;
            aStack.push(position);
        }
    }
}
