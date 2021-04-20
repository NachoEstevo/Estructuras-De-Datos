package MetroviasTP;
import DataStructures.Queues.EmptyQueueException;
import DataStructures.Stacks.DynamicStack;
import DataStructures.Stacks.EmptyStackException;

import java.util.Scanner;
/**Author Ignacio Estevo**/

public class Main {
    private static Window[] windowsArr;
    private static Metrovias metrovia;

    public static void main(String[] args) throws InvalidWindowException, EmptyStackException, EmptyQueueException {
        createWindows();
        mainScreen();
        showStack();
    }

    private static void showStack() throws EmptyStackException {
        System.out.println("Show stack...");
        DynamicStack<Ticket> tickets = metrovia.getTickets();
        for (int i = 0; i < tickets.getSize(); i++) {
            Ticket currentTicket = tickets.peek();
            System.out.println("Ticket: " + i);
            System.out.println("Code: " + currentTicket.getCode());
            System.out.println("Time: " + currentTicket.showTime());
            System.out.println("Price: " + currentTicket.getPrice());
            System.out.println(" ");
            tickets.pop();
        }

    }

    private static void createWindows() throws InvalidWindowException, EmptyStackException {
        Scanner input = new Scanner(System.in);

        System.out.print("\n" + "------------------------------------" + "\n" +
                "Bienvenido a Metrovias" + "\n" + "Precio del ticket: 10$" +
                "\n" + "\n" +
                "Ingrese la cantidad de ventanillas a simular: ");

        int windowsAmount = input.nextInt();
        metrovia = new Metrovias(windowsAmount); //Initialize metrovias with the amount of windows

        if (windowsAmount >= 5 && windowsAmount <= 25){
            windowsArr = metrovia.getWindows(); //for easier handling
        }
        else{ throw new InvalidWindowException("Ingresar una cantidad entre 5 y 25");}
    }

    public static void mainScreen() throws EmptyStackException, EmptyQueueException {
        Scanner input = new Scanner(System.in);
        while(true){

            System.out.println("\n" + "------------------------------------" + "\n" +
                    "MetroviasTP" + "\n" +
                    "\n" +
                    "1. Avanzar 30 segundos" + "\n" +
                    "2. Terminar la simulacion" + "\n");

            switch (input.nextInt()) {
                case 1 -> {
                    fastForward30Sec();
                }
                case 2 -> {
                    System.out.println("Simulacion terminada");
                    showTotalEarnings();
                    showAverageWaitTime();
                    //System.exit(0);
                    return;
                }
                default -> System.out.println("Opcion invalida");
            }
        }
    }

    private static void fastForward30Sec() throws EmptyQueueException { //5 new people are enqueued in a random window and we call "Metrovias.callNext()" to see if they are called or not
        Passenger[] newlyArrived = new Passenger[5];
        int peopleCalled = 0;

        for (int i = 0; i < 5; i++) {
            newlyArrived[i] = new Passenger();
            int randWindow = (int) ((Math.random() * metrovia.getAmountWindows())); //+1?
            windowsArr[randWindow].enqueuePassenger(newlyArrived[i]); //a random window gets a passenger
        }
        for (Window w: windowsArr) {
            w.callPassenger();
            //metrovia.callNext(); If this method is used it applies the 50% chance, but it is quite low to see results.
        }

        peopleCalled = metrovia.getLastCalled();
        System.out.println("The " + windowsArr.length + " windows called a total of " + peopleCalled + " passengers this time");
        System.out.println((metrovia.passengersInLine() + " are still waiting")); //Arreglar todavia no funciona
    }

    private static void showTotalEarnings() throws EmptyStackException {
        int earnings = 0;
        for (Window w: windowsArr) {
            earnings += w.getTotalEarned();
        }
        System.out.println("The total earned is: " + earnings + "$. Which comes from " + metrovia.getTotalPassengersCalled() + " people");
    }

    private static void showAverageWaitTime() throws EmptyQueueException, EmptyStackException {
        float averageTime = 0;
        /*for (Window w: windowsArr) {
            averageTime += w.queueTimeAverageInMinutes();
        }
        averageTime = averageTime / windowsArr.length;
*/
        DynamicStack<Ticket> tickets = metrovia.getTickets();
        int sizeTick =  tickets.getSize();
        for (int i = 0; i < tickets.getSize(); i++) {
            averageTime+= tickets.peek().getTime().getAverageInMinutes(1);
            tickets.pop();
        }
        averageTime = averageTime/sizeTick;
        System.out.println("In average, the " + windowsArr.length + " windows, have an average waittime of " + averageTime/60 + " seconds");
    }

}
