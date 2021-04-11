package Metrovias;
import java.util.Scanner;
/**Author Ignacio Estevo**/

public class Simulation {

    public static void main(String[] args) throws InvalidWindowException {
        createWindows();
        mainScreen();
        showStack();
    }

    private static void showStack() {
    }

    private static void createWindows() throws InvalidWindowException {
        Scanner input = new Scanner(System.in);

            System.out.print("\n" + "------------------------------------" + "\n" +
                    "Bienvenido a Metrovias" + "\n" +
                    "\n" +
                    "Ingrese la cantidad de ventanillas a simular: ");

            int windows = input.nextInt();
            if (windows > 5 && windows < 25){
                for (int i = 0; i < windows; i++) {
                    new Window();
            }
        }
            else{ throw new InvalidWindowException("Ingresar una cantidad entre 5 y 25");}
    }

    public static void mainScreen(){
        Scanner input = new Scanner(System.in);
        while(true){

            System.out.println("\n" + "------------------------------------" + "\n" +
                    "Metrovias" + "\n" +
                    "\n" +
                    "1. Avanzar 30 segundos" + "\n" +
                    "2. Terminar la simulacion" + "\n");

            switch (input.nextInt()) {
                case 1 -> {
                   //Avanzar 30 segundos
                }
                case 2 -> {
                    System.out.println("Simulacion terminada");
                    //System.exit(0);
                    return;
                }
                default -> System.out.println("Opcion invalida");
            }
        }
    }
}
