package Metrovias;

public class Time {
    int hours, minutes, seconds;

    public Time(){
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
    public void add30Seconds(){
        if (getSeconds() != 30){
            this.seconds = 30;
        }
        else if(getMinutes() == 59 && getSeconds() == 30){
            this.hours += 1;
            this.minutes = 0;
            this.seconds = 0;
        }
        else{
            this.minutes += 1;
        }
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
