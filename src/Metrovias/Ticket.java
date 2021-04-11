package Metrovias;

import java.util.Random;

public class Ticket {
    int price;
    int time;
    int code;
    public Ticket(int time){
        this.time = time;
        price = 5;
        Random r = new Random( System.currentTimeMillis() );
        code = ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }

    public int getPrice() { return price;}

    public void setPrice(int price) { this.price = price;}

    public int getTime() {return time;}

    public void setTime(int time) {this.time = time;}

    public int getCode() {return code;}

    public void setCode(int code) {this.code = code;}

}

