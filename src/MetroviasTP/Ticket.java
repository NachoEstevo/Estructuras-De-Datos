package MetroviasTP;

import java.util.Random;

public class Ticket {
    int price;
    Time time;
    int code;
    public Ticket(){
        this.time = new Time();
        price = 10;
        Random r = new Random();
        code = ((1 + r.nextInt(2)) * 10000 + r.nextInt(1000));
    }

    public int getPrice() { return price;}

    public String showTime() {return time.toString();}

    public Time getTime(){return time;}

    public int getCode() {return code;}

}

