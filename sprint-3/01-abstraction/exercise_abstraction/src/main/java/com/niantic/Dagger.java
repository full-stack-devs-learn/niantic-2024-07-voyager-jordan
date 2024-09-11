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

    public void setDaggerCount(int value)
    {
        this.daggerCount += value;

        if(this.getDaggerCount() < 0)
        {
            this.daggerCount = 0;
        }

    }

    public void addDagger()
    {
        this.setDaggerCount(1);
    }

    @Override
    public int attack() {

        if(this.daggerCount >= 1)
        {
            int chargeIncrease = 20;

            this.setPercentCharged(chargeIncrease);
            return this.getDamage();
        }

        return 0;
    }

    @Override
    public int powerAttack() {
        if(this.daggerCount >= 1)
        {
            int abilityCost = 100;
            if(this.getPercentCharged() == 100)
            {
                this.setPercentCharged(-abilityCost);
                this.setDaggerCount(-1);
                return this.getDamage() * 3;
            }
            else
            {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public int getRange() {
        return 10;
    }
}
