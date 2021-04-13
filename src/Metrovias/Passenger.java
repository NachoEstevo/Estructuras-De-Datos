package Metrovias;

public class Passenger {
    String name;
    Ticket currentTicket;
    Window currentWindow;
    Time waittime;

    public Passenger(String name){
        this.name = name;
        currentTicket = null;
        currentWindow = null;
        waittime = new Time();
    }

    public void assignWindow(Window aWindow){
        this.currentWindow = aWindow;
    }

    public void assignTicket(Ticket aTicket){
        this.currentTicket = aTicket;
    }

    public Time getWaitTime(){return waittime;}
    public String getWaitTimeToString(){
        return this.currentTicket.showTime();
    }
}
