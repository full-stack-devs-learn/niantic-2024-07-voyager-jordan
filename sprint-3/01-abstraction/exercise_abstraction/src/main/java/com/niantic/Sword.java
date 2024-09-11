package com.niantic;

public class Sword extends Weapon
{
    public Sword(String name, int damage)
    {
        super(name, damage);
    }

    @Override
    public int attack() {

        int chargeIncrease = 10;
        this.setPercentCharged(chargeIncrease);
        return chargeIncrease;
    }

    @Override
    public int powerAttack() {
        int currentCharge = this.getPercentCharged();

        if(currentCharge == 100)
        {
            this.setPercentCharged(-100);
            return this.getDamage() * 4;
        }
        if(currentCharge >= 50)
        {
            this.setPercentCharged(-50);
            return this.getDamage() * 2;
        }
        else
        {
            this.setPercentCharged(0);
            return this.getDamage();
        }
    }

    @Override
    public int getRange() {
        return 1;
    }
}
