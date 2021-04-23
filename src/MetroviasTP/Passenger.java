package MetroviasTP;

public class Passenger {
    private Ticket currentTicket;
    private Window currentWindow;
    Time enteredQueue; //This saves the time at which the passenger entered the queue


    public Passenger(Time enteredQueue){
        this.enteredQueue = enteredQueue;
    }

    public void assignWindow(Window aWindow){ this.currentWindow = aWindow;}

    public Window getCurrentWindow() {return currentWindow; }

    public void assignTicket(Ticket aTicket){
        this.currentTicket = aTicket;
    }

    public Ticket getTicket() {return currentTicket;}

    public Time getTimeEnteredQueue(){
        if (enteredQueue.getAverageInSeconds(1) == 0){
            Time minTime = new Time(); // If the person entered the queue and was called at the same time, time should be just 30 secs.
            minTime.seconds = 30;
            return minTime;
        }
        else return enteredQueue;
    }

    public String getWaitTimeToString(){
        return this.currentTicket.showTime();
    }
}
