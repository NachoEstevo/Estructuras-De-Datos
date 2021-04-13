package Metrovias;

import DataStructures.Queues.DynamicQueue;
import DataStructures.Stacks.DynamicStack;
import DataStructures.Stacks.EmptyStackException;

public class Window {
    DynamicQueue<Passenger> buffer; //This is the waiting line. First in first to go to a window
    DynamicStack<Ticket> tickets;   //Ticket price set to 10
    private Time waitTimeAverage;
    private int earnings;
    private int passengersCalled;


    public Window(){
        buffer = new DynamicQueue<>();
        tickets = new DynamicStack<>();
        earnings = 0;
        passengersCalled = 0;

    }
    public void enqueuePassenger(Passenger passenger){
        buffer.enqueue(passenger);
    }

    public Passenger callPassenger(){ // I assume that when the passenger is called he/she instantly gets his ticket and ends the waittime.
        Passenger called = (Passenger)buffer.getFront().getData();
        earnings += 10;
        passengersCalled++;
        waitTimeAverage.sumTimes(called.getWaitTime());
        return called;

    }
    public int getTotalEarned() throws EmptyStackException {
        int earned = 0;
        while (!tickets.isEmpty()){
            earned += tickets.peek().getPrice();
            tickets.pop();
        }
        return earned;
    }
}
