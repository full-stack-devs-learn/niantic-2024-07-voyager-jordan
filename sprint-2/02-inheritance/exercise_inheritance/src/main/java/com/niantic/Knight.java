package com.niantic;

public class Knight extends Character
{
    protected int armor;

    public Knight(String name, int health, int level, int experience, int armor)
    {
        super(name, health, level, experience);

        this.armor = Math.max(armor, 0);

    }

    public int getArmor() {
        return armor;
    }

    @Override
    public void takeDamage(int incomingDamage)
    {
            incomingDamage -= this.getArmor();

            if(incomingDamage > 0){
                this.health -= incomingDamage;
            }
    }

    @Override
    public void levelUp()
    {
        if(!isDefeated()){
            super.levelUp();
            this.armor += 5;
        }

    }

    @Override
    public String specialAbility(){ return "Armor Shield"; }
}
