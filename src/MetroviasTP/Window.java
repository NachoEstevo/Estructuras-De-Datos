package MetroviasTP;

import DataStructures.Queues.DynamicQueue;
import DataStructures.Queues.EmptyQueueException;
import DataStructures.Stacks.DynamicStack;
import DataStructures.Stacks.EmptyStackException;

public class Window {
    DynamicQueue<Passenger> buffer; //This is the waiting line. First in first to go to a window
    DynamicStack<Ticket> tickets;
    private int earnings;           //Ticket price set to 10
    private int passengersCalled;
    private int totalPassengers;
    public int lastCalled;

    public Window() {
        buffer = new DynamicQueue<>();
        tickets = new DynamicStack<>();
        earnings = 0;
        passengersCalled = 0; //The amount of passengers attended in this window
        totalPassengers = 0; // passengers called + passengers in line
    }

    public void enqueuePassenger(Passenger passenger) {
        buffer.enqueue(passenger);
        totalPassengers++;
    }

    public void callPassenger(Time metroviaTime) throws EmptyQueueException { // I assume that when the passenger is called he/she instantly gets his ticket and ends the waittime.
        lastCalled = 0;
        Ticket aTicket;

        Passenger called = buffer.dequeue(); //We dequeue him from the line
        earnings += 10;
        passengersCalled++;
        lastCalled++;

        //Tickets handling
        aTicket = new Ticket((int) metroviaTime.substractTimesInSeconds(called.getTimeEnteredQueue())); //Calulates the waitTime of the passenger
        called.assignTicket(aTicket); //We give the passenger the ticket
        tickets.push(aTicket);       //We stack the called passengers ticket
    }

    public int getTotalEarned() throws EmptyStackException {return earnings;} //It can be made iterating through the tickets

    public float queueTimeAverageInSeconds() throws EmptyQueueException, EmptyStackException {
        DynamicStack<Ticket> auxStack = getTickets();
        Time waitTime = new Time();

        for (int i = 0; i < auxStack.getSize(); i++) {
            if (!auxStack.isEmpty()) {
                waitTime.sumTimes(auxStack.peek().getTime()); //We add the time of every called person.
                auxStack.pop();
            }
        }
        return waitTime.getAverageInSeconds(passengersCalled);
    }

    public int getTotalPassengers() {return totalPassengers;}

    public int getPassengersCalled() {return tickets.getSize();}

    public DynamicStack<Ticket> getTickets(){ return tickets;}

    public int getAmountWaitingPassengers(){return buffer.size();} // totalpassengers - calledpassengers

}

