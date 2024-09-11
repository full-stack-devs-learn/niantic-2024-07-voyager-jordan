package com.niantic;

public class Dagger extends Weapon
{
    private int daggerCount = 1;

    public Dagger(String name, int damage){
        super(name, damage);
    }

    public int getDaggerCount()
    {
        return daggerCount;
    }

    public void setDaggerCount()
    {
        this.daggerCount += 1;
    }

    public void addDagger()
    {
        this.setDaggerCount();
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int powerAttack() {
        return 0;
    }

    @Override
    public int getRange() {
        return 0;
    }
}
