package HorseMovement;

import DataStructures.Stacks.DynamicStack;
import DataStructures.Stacks.EmptyStackException;

import java.util.Scanner;

public class HorseMovementTest {
    static String[][] board = new String[8][8];
    static Horse aHorse = new Horse();
    static DynamicStack<Position>[] stacksArr = new DynamicStack[4];

    public static void main(String[] args) throws OutOfMovesException, OutOfBoardException, EmptyStackException {
        simulationRequirements();
        mainScreen();
    }
    public static void mainScreen() throws OutOfMovesException, OutOfBoardException, EmptyStackException {
        Scanner input = new Scanner(System.in);
        while(true){

            System.out.println("\n" + "------------------------------------" + "\n" +
                    "Horse Movement Grupo 14" + "\n" +
                    "Posicion acutal: " + aHorse.getCurrentPosition() +
                    "\n" +
                    "1. Elejir posicion inicial" + "\n" +
                    "2. Realizar proximo salto" + "\n" +
                    "3. Mostrar contenido de las pilas" + "\n" +
                    "4. Salir" + "\n");

            String option = input.nextLine();
            switch (Integer.parseInt(option)) {
                case 1 -> {
                    System.out.print("Elija la posicion inicial: ");
                    String pos = input.nextLine();
                    Position init = new Position(String.valueOf(pos.charAt(0)),Integer.parseInt(String.valueOf(pos.charAt(1))));
                    aHorse.setInitialPosition(init);
                    board[aHorse.getPosition().getRow()-1][aHorse.getPosition().getColumn()-1] = "H" + aHorse.moveCounter;
                }
                case 2 -> {
                    stacksArr[aHorse.getMoveCounter()] = aHorse.getPossibleMoves(); //Cambiar. Esta linea llena la pila con los posibles movimientos. No los concatena
                    String newSquare = aHorse.move(aHorse.getPossibleMoves().peek());
                    System.out.println("The horse is now at: " + newSquare);

                    board[aHorse.getPosition().getRow()-1][aHorse.getPosition().getColumn()-1] = "H" + aHorse.moveCounter;
                    showBoard();

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

    private static void showStackContent() throws EmptyStackException, OutOfBoardException { //Cambiar
        System.out.println("Initial Position ");
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < stacksArr[j].getSize(); i++) {
                System.out.println(stacksArr[j].peek().getPosition());
                stacksArr[j].pop();

            }
            System.out.println("Next Move");
        }
    }

    private static void showBoard(){
        System.out.println("Horse path");
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("A B C D E F G H");
    }

    private static void simulationRequirements(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "[]";
            }
        }
    }

}
