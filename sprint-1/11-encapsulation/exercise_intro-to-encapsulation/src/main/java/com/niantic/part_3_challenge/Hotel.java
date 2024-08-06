package com.niantic.part_3_challenge;

public class Hotel
{
    int numberOfRooms;
    int numberOfSuites;
    int bookedRooms;
    int bookedSuites;


    public Hotel(int numberOfRooms, int numberOfSuites){
      this.numberOfRooms = numberOfRooms;
      this.numberOfSuites = numberOfSuites;
    };
    public Hotel(int numberOfRooms, int numberOfSuites, int bookedRooms, int bookedSuites){
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
        this.bookedRooms = bookedRooms;
        this.bookedSuites = bookedSuites;
    };

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public void setNumberOfSuites(int numberOfSuites) {
        this.numberOfSuites = numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getAvailableRooms(){
        return this.numberOfRooms - this.bookedRooms;
    };
    public int getAvailableSuites(){
        return this.numberOfSuites - this.bookedSuites;
    };
    public boolean makeReservation(int numberOfRooms, boolean isSuite){

        if(isSuite){
            if(this.getAvailableSuites() > 0){
                this.numberOfSuites = this.numberOfSuites - numberOfRooms;
                return true;
            }
        } else {
            if(this.getAvailableRooms() > 0){
                this.numberOfRooms = this.numberOfRooms - numberOfRooms;
                return true;
            }
        }
        return false;
    };

}
