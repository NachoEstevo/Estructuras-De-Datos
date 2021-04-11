package Metrovias;

import DataStructures.Stacks.DynamicStack;
import DataStructures.Stacks.EmptyStackException;

public class Window {
DynamicStack<Passenger> passengers;
DynamicStack<Ticket> tickets;

    public Window(){
        passengers = new DynamicStack<>();
        tickets = new DynamicStack<>();

    }
    public void callPassenger(){

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
