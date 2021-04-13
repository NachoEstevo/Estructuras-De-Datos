package HorseMovement;

import java.util.Scanner;

public class HorseMovementTest {
    static String[][] board = new String[8][8]; //We do a String array so we can show the path of the horse
    static Horse aHorse = new Horse();

    public static void main(String[] args) throws OutOfMovesException {
        mainScreen();
    }
    public static void mainScreen() throws OutOfMovesException {
        Scanner input = new Scanner(System.in);
        while(true){

            System.out.println("\n" + "------------------------------------" + "\n" +
                    "Horse Movement Grupo 14" + "\n" +
                    "\n" +
                    "1. Elejir posicion inicial" + "\n" +
                    "2. Realizar proximo salto" + "\n" +
                    "3. Mostrar contenido de las pilas" + "\n" +
                    "4. Salir" + "\n");

            switch (input.nextInt()) {
                case 1 -> {
                    String pos = input.nextLine();
                    pos = String.valueOf(Character.toUpperCase(pos.charAt(0)) + pos.charAt(1)); //Check if this works
                    Position init = new Position(pos.charAt(0),pos.charAt(1));
                    aHorse.setInitialPosition(init);
                }
                case 2 -> {
                    String newSquare = aHorse.move();
                    System.out.println("The horse is now at: " + newSquare);
                    //update board.

                }
                case 3 -> {
                    showStackContent();
                }
                case 4 -> {
                    System.out.println("Simulacion terminada");
                    System.exit(0);
                    return;
                }
                default -> System.out.println("Opcion invalida");
            }
        }
    }

    private static void showStackContent() {

    }

    private static void showBoard(){
        System.out.println("Horse path");
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]);
            }
        }
    }
    private static void updateBoard(String move){
        int moveNumber = aHorse.getMoveCounter();
        String numberedPosition = aHorse.getPosition().getNumberedPosition();
        board[numberedPosition.charAt(0)][numberedPosition.charAt(1)] = "c" + moveNumber; //Check if this works

    }

}
