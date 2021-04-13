package Metrovias;
import java.util.Scanner;
/**Author Ignacio Estevo**/

public class Main {
    private static Window[] windows;

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

        int windowsAmount = input.nextInt();
        windows = new Window[windowsAmount];
        if (windowsAmount > 5 && windowsAmount < 25){
            for (int i = 0; i < windowsAmount; i++) {
                windows[i] = new Window();
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
                    fastForward30Sec();
                }
                case 2 -> {
                    System.out.println("Simulacion terminada");
                    //print earnings
                    //System.exit(0);
                    return;
                }
                default -> System.out.println("Opcion invalida");
            }
        }
    }

    private static void fastForward30Sec() {
        for (Window w: windows) {

        }
    }

}
