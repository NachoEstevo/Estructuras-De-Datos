package MetroviasTP;

public class Passenger {
    private Ticket currentTicket;
    private Window currentWindow;
    Time enteredQueue; //This saves the time at which the passenger entered the queue


    public Passenger(){
        currentTicket = null;
        currentWindow = null;

    }

    public void assignWindow(Window aWindow){ this.currentWindow = aWindow;}

    public void startTimer(){enteredQueue = new Time();}

    public Window getCurrentWindow() {return currentWindow; }

    public void assignTicket(Ticket aTicket){
        this.currentTicket = aTicket;
    }

    public Ticket getCurrentTicket() {return currentTicket;}

    public Time getWaitTime(){return currentTicket.getTime();}

    public void add30Secs(){this.currentTicket.getTime().add30Seconds();}

    public String getWaitTimeToString(){
        return this.currentTicket.showTime();
    }
}
