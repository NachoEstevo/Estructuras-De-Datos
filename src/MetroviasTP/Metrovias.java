package MetroviasTP;

import DataStructures.Queues.EmptyQueueException;
import DataStructures.Stacks.DynamicStack;
import DataStructures.Stacks.EmptyStackException;

public class Metrovias {

    private  Window[] windows;
    private DynamicStack<Passenger> calledPassengers;
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

    public void callNext() throws EmptyQueueException { //First we see if a passenger should be called (50% chance), if true, we select a random window to call him
        currentTime.add30Seconds();
        for (Window w: windows) {
            int chanceToBeCalled = (int) ((Math.random() * 100)); //50% chance to be called or not
            if (chanceToBeCalled >= 50) {
                w.callPassenger();
            }
        }
    }
    public int getLastCalled(){
        int calledLastRound = 0;
        for (Window w: windows) {
            calledLastRound += w.getLastCalled();
        }
        return calledLastRound;
    }

    public Window[] getWindows() {return windows;}

    public int getAmountWindows() {return amountWindows;}

    public DynamicStack<Passenger> getCalledPassengers() {return calledPassengers;}

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
            passengersInLine += w.getAmountWaitingPassengers();
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

    public DynamicStack<Ticket> getTickets() throws EmptyStackException {
        DynamicStack<Ticket> tickets = new DynamicStack<>();
        for (Window w: windows) {
            for (int i = 0; i < w.getCalledPassengers().getSize(); i++) {
                tickets.push(w.getCalledPassengers().peek().getCurrentTicket());
                w.calledPassengers.pop();
            }
        }
        return tickets;
    }
}