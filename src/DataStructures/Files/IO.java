package DataStructures.Files;

import java.util.Scanner;

public class IO {
    private Scanner input;
    private String fileName = "C:\\Users\\nacho\\OneDrive\\Escritorio\\Market";

    public IO(){
        input = new Scanner(System.in);
        int option = menu();

        while (option < 8){
            switch (option) {
                case 1 -> alta();
                case 2 -> tamano();
                case 3 -> listar();
                case 4 -> cantAlmacen();
                case 5 -> buscar();
                case 6 -> eliminar();
                case 7 -> compactar();
            }
            option = menu();
        }
    }

    private int menu() {
        System.out.println("1. Alta");
        System.out.println("2. Cantidad de Productos");
        System.out.println("3. Listar todos los productos");
        System.out.println("4. Cantidad de productos de almacen");
        System.out.println("5. Buscar");
        System.out.println("6. Eliminar");
        System.out.println("7. Compactar");
        System.out.println("8. Fin");
        System.out.println("Opcion: ");
        String opt = input.nextLine();
       int option = Integer.parseInt(opt);
       return option;
    }
}
