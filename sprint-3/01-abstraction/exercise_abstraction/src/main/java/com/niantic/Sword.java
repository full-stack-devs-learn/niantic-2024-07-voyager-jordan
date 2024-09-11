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
        int abilityCost = 50;

        if(currentCharge == 100)
        {
            this.setPercentCharged(-abilityCost*2);
            return this.getDamage() * 4;
        }
        if(currentCharge >= 50)
        {
            this.setPercentCharged(-abilityCost);
            return this.getDamage() * 2;
        }
        else
        {
            return this.attack();
        }
    }

    @Override
    public int getRange() {
        return 1;
    }
}
