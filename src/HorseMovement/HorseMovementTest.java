package HorseMovement;

import DataStructures.Stacks.DynamicStack;
import DataStructures.Stacks.EmptyStackException;

import java.util.Scanner;

public class HorseMovementTest {
    static String[][] board = new String[8][8];
    static Horse aHorse = new Horse();
    static DynamicStack<Position>[] stacksArr = new DynamicStack[4]; //For 4 moves. More moves can be implemented easily

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
                    board[aHorse.getPosition().getRow()-1][aHorse.getPosition().getColumn()-1] = "H" + aHorse.getMoveCounter();

                }
                case 2 -> {
                    stacksArr[aHorse.getMoveCounter()] = aHorse.getPossibleMoves();
                    String newSquare = aHorse.move(aHorse.getPossibleMoves().peek());
                    System.out.println("The horse is now at: " + newSquare);

                    board[aHorse.getPosition().getRow() - 1][aHorse.getPosition().getColumn() - 1] = "H" + aHorse.getMoveCounter();
                    showBoard();


                }
                case 3 -> {
                    listMoves();
                    //showNextPossibleMove();
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

    private static void showNextPossibleMove() throws OutOfBoardException, EmptyStackException {

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


    private static void listMoves() throws OutOfBoardException, EmptyStackException {listMoves(aHorse.getInitialPosition().getPosition(),0, aHorse.getInitialPosition().getPosition());}

    private static int listMoves(String position, int counter, String move) throws OutOfBoardException, EmptyStackException {
        DynamicStack<Position> miStack = aHorse.getPossibleMoves(new Position(String.valueOf(position.charAt(0)),String.valueOf(position.charAt(1))));

        if (counter<2) {
            while (miStack.getSize() != 0) {
                String currentBox = miStack.peek().getPosition();
                miStack.pop();
                counter++;
                listMoves(currentBox,counter,move+"-"+currentBox.toUpperCase());
                counter--;
            }
        } else {
            while (miStack.getSize() != 0) {
                String currentBox = miStack.peek().getPosition();
                aHorse.moveCounter++;
                System.out.println(move+"-"+currentBox.toUpperCase());
                miStack.pop();
            }
            System.out.println("--------------");
            counter--;
        }
        return counter;

    }

    private static void simulationRequirements(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "[]";
            }
        }
    }


}
