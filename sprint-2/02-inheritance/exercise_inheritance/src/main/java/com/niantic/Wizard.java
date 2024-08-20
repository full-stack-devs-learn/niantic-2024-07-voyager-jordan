package com.niantic;

public class Wizard extends Character
{
    protected int mana;

    public Wizard(String name, int health, int level, int experience, int mana)
    {
       super(name, health, level, experience);

       this.mana = mana;
    }

    public int getMana(){ return mana; }

    public void regenerateMana(int manaIncrease)
    {
        if(!isDefeated()){
            mana += manaIncrease;
            System.out.println(this.name + " gained " + manaIncrease + " mana.");
        }
    }

    public void castSpell(Character target)
    {
        if(this.getMana() >= 10 && !isDefeated())
        {
            int damage = attackDamage * 2;
            target.takeDamage(damage);
        }

    }

    @Override
    public void levelUp()
    {
        if(!isDefeated())
        {
            super.levelUp();
            this.mana += 10;
        }
    }

    @Override
    public String specialAbility()
    {
        return "Cast Spells";
    }
}
