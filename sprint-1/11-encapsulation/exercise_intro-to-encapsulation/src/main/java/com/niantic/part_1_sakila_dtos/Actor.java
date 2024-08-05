package com.niantic.part_1_sakila_dtos;

public class Actor
{
    //Variables
    private int actorId;
    private String first_name;
    private String last_name;

    //Default Constructor
    public Actor(){

    }
    //Parameterized Constructor
    public Actor(int id, String first_name, String last_name){
        this.actorId = id;
        this.first_name = first_name;
        this.last_name = last_name;

    }

    //Getters & Setters
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getFullName(){
        return first_name + " " + last_name;
    }
}
