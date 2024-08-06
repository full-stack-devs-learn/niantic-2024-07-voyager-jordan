package com.niantic.part_3_challenge;

public class Refrigerator
{
    private final int MAX_CAPACITY;
    private int currentTemperature;
    private int available;
    private boolean isDoorOpen;

    public Refrigerator(int currentTemperature, int MAX_CAPACITY){
        this.currentTemperature = currentTemperature;
        this.MAX_CAPACITY = MAX_CAPACITY;
        this.available = MAX_CAPACITY;
    }

    public int getMaxCapacity(){
        return MAX_CAPACITY;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public int setCurrentTemperature(int currentTemperature) {
        return this.currentTemperature = currentTemperature;
    }

    public int getAvailableCapacity() {
        return available;
    }

    public int changeAvailableCapacity(int available) {
        return this.available = available;
    }

    public boolean isDoorOpen(){
        return this.isDoorOpen;
    }
    public boolean openDoor(){
         return isDoorOpen = true;
    }
    public boolean closeDoor(){
        return isDoorOpen = false;
    }

    public boolean addItem(int numberOfItems){

        if(isDoorOpen && available - numberOfItems >= 0){
            this.changeAvailableCapacity(available - numberOfItems);
            return true;
        }
        return false;
    }
    public boolean removeItem(int numberOfItems){
        if(isDoorOpen){
            this.changeAvailableCapacity(available + numberOfItems);
            return true;
        }
        return false;
    }

}
