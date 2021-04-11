package HorseMovement;

import java.util.Scanner;

public class HorseMovementTest {
    static Board aBoard = new Board();
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
                    aHorse.setInitialPosition(pos);
                }
                case 2 -> {
                    aHorse.move();
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

}
