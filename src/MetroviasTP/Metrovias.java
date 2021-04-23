package MetroviasTP;

import DataStructures.Queues.EmptyQueueException;
import DataStructures.Stacks.DynamicStack;
import DataStructures.Stacks.EmptyStackException;

public class Metrovias {

    private  Window[] windows;
    private int amountWindows;
    Time currentTime;


    public Metrovias(int amountWindows){
        this.amountWindows = amountWindows;
        windows = new Window[amountWindows];
        initiateMetrovias();
        currentTime = new Time();
    }
    public void initiateMetrovias(){
        for (int i = 0; i < getAmountWindows(); i++) {
            windows[i] = new Window();
        }
    }
    public void pass30Seconds() throws EmptyQueueException { //30 seconds are added on the clock. That time is taken as reference for newly arrived passengers
        Passenger[] newlyArrived = new Passenger[5];
        currentTime.add30Seconds();
        for (int i = 0; i < 5; i++) { // 5 passengers are created and assigned to a random window
            newlyArrived[i] = new Passenger(currentTime);
            int randWindow = (int) ((Math.random() * getAmountWindows())); //+1?
            windows[randWindow].enqueuePassenger(newlyArrived[i]); //a random window gets a passenger
        }
        for (Window w: windows) {
            System.out.println("Personas en ventana antes de llamar: " + w.getAmountWaitingPassengers());
        }
        callNext();
        for (Window w: windows) {
            System.out.println("Personas en ventana: " + w.getAmountWaitingPassengers());
        }
    }

    private void callNext() throws EmptyQueueException { //We see if a passenger should be called (50% chance)
        for (Window w: windows) {
            int chanceToBeCalled = (int) ((Math.random() * 100)); //50% chance to be called or not
            if (chanceToBeCalled >= 50 && !w.buffer.isEmpty()) {
                w.callPassenger(currentTime);
            }
        }
    }
    public int getLastCalled(){ // Number of people called in the las 30 seconds.
        int calledLastRound = 0;
        for (Window w: windows) {
            calledLastRound += w.getLastCalled();
        }
        return calledLastRound;
    }

    public Window[] getWindows() {return windows;}

    public int getAmountWindows() {return amountWindows;}

    public DynamicStack<Ticket> gettotalTickets() throws EmptyStackException {
        DynamicStack<Ticket> tickets = new DynamicStack<>();
        for (Window w: windows) {
            while (!w.getTickets().isEmpty()){
                tickets.push(w.getTickets().peek());
                w.tickets.pop();
            }
        }
        return tickets;
    }

    public int getTotalPassengers(){
        int totalPassengers = 0;
        for (Window w: windows) {
            totalPassengers += w.getTotalPassengers();
        }
        return totalPassengers;
    }
    public int passengersInLine(){
        int passengersInLine = 0;
        for (Window w: windows) {
            passengersInLine += (w.getTotalPassengers() - w.getPassengersCalled());
        }
        return passengersInLine;
    }

    public int getTotalPassengersCalled(){
        int totalPassengersCalled = 0;
        for (Window w: windows) {
            totalPassengersCalled += w.getPassengersCalled();
        }
        return totalPassengersCalled;
    }
}