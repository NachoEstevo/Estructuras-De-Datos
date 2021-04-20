package MetroviasTP;

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

    public int getHours() {return hours;}

    public int getMinutes() {return minutes;}

    public int getSeconds() { return seconds;}

    public String toString(){ return getHours() + ": " + getMinutes() + ": " + getSeconds();}

    public void sumTimes(Time timeB){ //More things should be taken into account to avoid problems.
        if (this.hours + timeB.getHours() <= 24){
            this.hours += timeB.getHours();
        }
        if (this.getMinutes() + timeB.getMinutes() < 60){
            this.minutes += timeB.getMinutes();
        }
        if (this.getSeconds() + timeB.getSeconds() < 60){
            this.seconds += timeB.getSeconds();
        }
        else if (this.minutes + timeB.getMinutes() > 59){
            this.hours++;
            this.minutes = 0;
        }
        else if(this.seconds + timeB.getSeconds() > 59){
            this.minutes++;
            this.seconds = 0;
        }
    }
    public float getAverageInMinutes(int totalCalled){
        float inMinutes = 0;
        inMinutes += this.getHours()*60;
        inMinutes += this.getMinutes();
        inMinutes += this.getSeconds()/60;

        return inMinutes/totalCalled;
    }
}
