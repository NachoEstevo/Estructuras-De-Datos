package Metrovias;

public class Passenger {
    String name;
    Ticket currentTicket;
    Window currentWindow;

    public Passenger(String name){
        this.name = name;
        currentTicket = null;
        currentWindow = null;
    }

    public void assignWindow(Window aWindow){
        this.currentWindow = aWindow;
    }
    public void assignTicket(Ticket aTicket){
        this.currentTicket = aTicket;
    }
    public int getWaitTime(){
        return this.currentTicket.getTime();
    }
}
