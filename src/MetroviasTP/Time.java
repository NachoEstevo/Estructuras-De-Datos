package MetroviasTP;

public class Time {
    int hours, minutes, seconds;

    public Time(){
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }
    public Time(int time){
        Time result = new Time();
        while(time !=0) {
            if (time >= 3600) {
                result.hours ++;
                time -= 3600;
            }
            else if(time < 3600 && time > 60){
                result.minutes++;
                time-= 60;
            }
            else{
                result.seconds += time;
                time-= time;
            }
        }
    }


    public void add30Seconds(){
        if (getSeconds() == 0){
            this.seconds = 30;
        }
        else if (getSeconds() == 30){
            this.seconds = 0;
            this.minutes++;
        }
        else if(getMinutes() == 59 && getSeconds() == 30){
            this.hours += 1;
            this.minutes = 0;
            this.seconds = 0;
        }
    }

    public int getHours() {return this.hours;}

    public int getMinutes() {return this.minutes;}

    public int getSeconds() { return this.seconds;}

    public String toString(){ return getHours() + ":" + getMinutes() + ":" + getSeconds();}

    public Time sumTimes(Time timeB){
        if(this.seconds + timeB.getSeconds() > 59){
            this.minutes++;
            this.seconds = 0;
        }
        else{ this.seconds+= timeB.getSeconds();}

        if (this.getMinutes() + timeB.getMinutes() > 60){
            this.hours ++;
            this.minutes = 0;
        }
        else{ this.minutes += timeB.getMinutes();}

        if (this.hours + timeB.getHours() <= 24){
            this.hours += timeB.getHours();
        }
        return this;
    }

    public float substractTimesInSeconds(Time timeB){
        float time1 = this.getAverageInSeconds(1);
        float time2 = timeB.getAverageInSeconds(1);

        return time1-time2;
    }
    public float getAverageInSeconds(int total){
        float inSeconds = 0;
        inSeconds += this.getHours()*60*60;
        inSeconds += this.getMinutes()*60;
        inSeconds += this.getSeconds();

        return inSeconds/total;
    }
    public Time secondsToTime(){
        float time1= this.getAverageInSeconds(1);
        Time result = new Time();
        while(time1 !=0) {
            if (time1 >= 3600) {
                result.hours ++;
            }
            else if(time1 < 3600 && time1 > 60){
                result.minutes++;
            }
            else{this.seconds += time1;}
        }
        return this;
    }

}
