package com.niantic.part_2_objects;

public class Rectangle
{
    private int height;
    private int width;

    public Rectangle(){};
    public Rectangle(int height, int width){
        this.height = height;
        this.width = width;
    };

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getArea(){
        return this.height * this.width;
    };
}
