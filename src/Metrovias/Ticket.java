package Metrovias;

import java.util.Random;

public class Ticket {
    int price;
    Time time;
    int code;
    public Ticket(){
        this.time = new Time();
        price = 10;
        Random r = new Random( System.currentTimeMillis() );
        code = ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }

    public int getPrice() { return price;}

    public void setPrice(int price) { this.price = price;}

    public String showTime() {return time.toString();}

    public Time getTime(){return time;}

    public int getCode() {return code;}

    public void setCode(int code) {this.code = code;}

}

