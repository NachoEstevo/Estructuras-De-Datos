package DataStructures.Archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Informe {
    private Scanner lector;
    private String nombreArchivo = "RegistroVentas.txt";

    public Informe() {
        lector = new Scanner(System.in);
        int opcion = menu();
        while (opcion < 4) {
            switch (opcion) {
                case 1 -> generarArchvioVentas();
                case 2 -> montoPorDestino();
                case 3 -> montoPorMes();
            }
            opcion = menu();
        }
    }

    public int menu(){
        System.out.println("1. Generar Archivo de ventas");
        System.out.println("2. Monto de las ventas en pesos discriminadas por destino");
        System.out.println("3. Monto de las ventas en pesos discriminadas por mes");
        String opc = lector.nextLine();
        return Integer.parseInt(opc);
    }

    public void montoPorDestino(){
        try{
            ArchivoVentas archV = new ArchivoVentas(nombreArchivo);
            archV.inicio();
            BufferedReader bf = new BufferedReader(new FileReader("Grupo 14/src/Archivos/RegistroDestino"));
            BufferedReader bf2 = new BufferedReader(new FileReader("Grupo 14/src/Archivos/RegistroCotizacion"));
            MontoDestino[] montoDestinos = new MontoDestino[30];
            CotizacionDolar[] cotizacionesPorMes = new CotizacionDolar[12];

            for (int i = 0; i < montoDestinos.length; i++) {
                String[] parts = splitDestino(bf.readLine());
                montoDestinos[i] = new MontoDestino(parts[0], parts[1]);
            }

            for (int i = 0; i < cotizacionesPorMes.length; i++) {
                int[] parts = splitCotizacion(bf2.readLine());
                cotizacionesPorMes[i] = new CotizacionDolar(parts[0], parts[1]);
            }
            System.out.println("Cantidad de registros: ");
            System.out.println(archV.cantReg()); //Tenemos 966 registros no 1000
            for (int i = 0; i < archV.cantReg(); i++) { //Lee muy pocas ventas
                Venta unaVenta = archV.leer();
                System.out.println(unaVenta.toString());
                for (int j = 0; j < montoDestinos.length; j++) { //Si coincide el lugar le sumamos el monto
                    if (unaVenta.getCodigoDeDestino().equals(montoDestinos[j].getCodigoDeDestino())){
                        montoDestinos[j].setMontoDestino(unaVenta.getCantidad()*unaVenta.getPrecioUnitarioEnDolares()*cotizacionesPorMes[unaVenta.getMes()].getCotizacion());
                    }
                }
            }

            for (int i = 0; i < montoDestinos.length; i++) {
                System.out.println(montoDestinos[i].toString());
            }

            bf.close();
            bf2.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void montoPorMes(){
        try {
            ArchivoVentas archV = new ArchivoVentas(nombreArchivo);
            archV.inicio();
            BufferedReader bf = new BufferedReader(new FileReader("Grupo 14/src/Archivos/RegistroCotizacion"));

            CotizacionDolar[] cotizacionesPorMes = new CotizacionDolar[12];
            for (int i = 0; i < 12; i++) {
                int[] parts = splitCotizacion(bf.readLine());
                cotizacionesPorMes[i] = new CotizacionDolar(parts[0], parts[1]);
            }

            int[] montoPorMes = new int[12];
            for (int i = 0; i < archV.cantReg(); i++) {
                Venta venta = archV.leer();
                for (int j = 0; j < montoPorMes.length-1; j++) { // Problema con el mes 12. Sin montoPorMes.length -1 da out of bounds
                    if (venta.getMes() == (j+1)){
                        montoPorMes[j] += venta.getCantidad()*venta.getPrecioUnitarioEnDolares()*cotizacionesPorMes[venta.getMes()].getCotizacion();

                    }
                }
            }

            for (int i = 0; i < montoPorMes.length ; i++) {
                System.out.println("\nMes: " + (i+1) + "\n" +
                        "Monto Total: " + montoPorMes[i]);
            }

            bf.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void generarArchvioVentas(){
        try{
            ArchivoVentas archV = new ArchivoVentas(nombreArchivo);

            String[] destinos = new String[30];
            BufferedReader bf = new BufferedReader(new FileReader("Grupo 14/src/Archivos/RegistroDestino"));

            for (int i = 0; i < destinos.length; i++) {
                destinos[i] = split(bf.readLine());
            }

            for (int i = 0; i < 1000; i++) { //Creamos 1000 ventas aleatorias
                archV.fin();
                archV.escribir(new Venta(destinos[(int) Math.floor(Math.random()*(destinos.length-1))], i,
                        (int) Math.floor(Math.random()*(10)+1), (int) Math.floor(Math.random()*(50)+10),
                        (int) Math.floor(Math.random()*(30)+1), (int) Math.floor(Math.random()*(12)+1),
                                2021));
            }

            bf.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Informe generado Exitosamente");

    }


    private String split(String line){
        String[] parts = line.split(";");
        return parts[0];
    }

    private String[] splitDestino(String line){
        String[] parts = line.split(";");
        return parts;
    }

    private int[] splitCotizacion(String line){
        int[] parts = new int[2];
        String[] parts2 = line.split(";");
        parts[0] = Integer.parseInt(parts2[0]);
        parts[1] = Integer.parseInt(parts2[1]);
        return parts;
    }

}
