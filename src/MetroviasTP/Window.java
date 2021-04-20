package MetroviasTP;

import DataStructures.Queues.DynamicQueue;
import DataStructures.Queues.EmptyQueueException;
import DataStructures.Stacks.DynamicStack;
import DataStructures.Stacks.EmptyStackException;

public class Window {
    DynamicQueue<Passenger> buffer; //This is the waiting line. First in first to go to a window
    DynamicStack<Passenger> calledPassengers;   //Ticket price set to 10
    private Time waitTimeAverage;
    private int earnings;
    private int passengersCalled;
    private int totalPassengers;
    private int lastCalled;


    public Window() {
        buffer = new DynamicQueue<>();
        calledPassengers = new DynamicStack<>();
        earnings = 0;
        passengersCalled = 0;
        waitTimeAverage = new Time();
        totalPassengers = 0;

    }

    public void enqueuePassenger(Passenger passenger) {
        buffer.enqueue(passenger);
        passenger.assignTicket(new Ticket());
        passenger.startTimer();
        totalPassengers++;
    }

    public void callPassenger() throws EmptyQueueException { // I assume that when the passenger is called he/she instantly gets his ticket and ends the waittime.
        lastCalled = 0;

        if (!buffer.isEmpty()) {
            Passenger called = (Passenger) buffer.getFront().getData();
            earnings += 10;
            passengersCalled++;
            lastCalled++;
            waitTimeAverage.sumTimes(called.getWaitTime());
            buffer.dequeue(); //We dequeue him
            calledPassengers.push(called);
        }
    }

    public int getTotalEarned() throws EmptyStackException {return earnings;}

    public float queueTimeAverageInMinutes() throws EmptyQueueException, EmptyStackException {
        DynamicStack<Passenger> auxStack = getCalledPassengers();
        Time waitTime = new Time();
        for (int i = 0; i < auxStack.getSize(); i++) {
            if (!auxStack.isEmpty()) {
                waitTime.sumTimes(auxStack.peek().getWaitTime());
                auxStack.pop();
            }
        }
        return waitTime.getAverageInMinutes(getTotalPassengers());
    }

    public int getLastCalled() {return lastCalled;}

    public int getTotalPassengers() {return totalPassengers;}

    public int getPassengersCalled() {return passengersCalled;}


    /*public void addqueueTimePassenger() throws EmptyQueueException { //Does not work as intended. Breaks buffer
        DynamicQueue<Passenger> queue1 = buffer;

        for (int i = 0; i < queue1.size(); i++) {
            if (!queue1.isEmpty()) {
                Passenger current = (Passenger) queue1.dequeue();
                current.add30Secs();
            }
        }
    }*/
    public DynamicStack<Passenger> getCalledPassengers(){ return calledPassengers;}

    public int getAmountWaitingPassengers(){
        return buffer.size();

    }

}

