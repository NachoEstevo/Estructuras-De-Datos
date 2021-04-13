package Metrovias;

import DataStructures.Stacks.DynamicStack;

public class Metrovias {

    private Window[] windows;
    private DynamicStack<Passenger> calledPassengers;
    private int amountWindows;

    public Metrovias(int amountWindows){
        windows = new Window[amountWindows];

        for (int i = 0; i < amountWindows; i++) {
            windows[i] = new Window();
        }
    }

    public void callNext(){ //First we see if a passenger should be called (50% chance), if true, we select a randow window to call him

        int choice = (int) ((Math.random() * (amountWindows)));
    }






}