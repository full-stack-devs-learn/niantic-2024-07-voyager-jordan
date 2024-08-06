package com.niantic.part_2_objects;

public class Circle
{
    private int radius;

    public Circle(){};
    public Circle(int radius){
        this.radius = radius;
    }


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getCircumference(){
        return 2 * Math.PI * this.radius;
    }
    public int getDiameter(){
        return (int)(2 * this.radius);
    }
    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }
}
