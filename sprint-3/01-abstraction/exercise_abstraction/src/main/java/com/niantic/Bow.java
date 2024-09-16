package com.niantic;

import java.util.HashSet;
import java.util.Set;


public class Bow extends Weapon
{
    private static final Set<String> ARROW_TYPES = new HashSet<>();
    static {
        ARROW_TYPES.add("standard");
        ARROW_TYPES.add("poison");
        ARROW_TYPES.add("explosive");
    }

    private String arrowType;
    private final int QUIVER_SIZE;
    private int arrowCount;
    private int damage;

    public Bow(String name, int damage, int quiverSize)
    {
        super(name, damage);
        if(!ARROW_TYPES.contains(name.toLowerCase())){
            throw new IllegalArgumentException("Invalid name must be one of "+ ARROW_TYPES);
        }
        this.arrowType = name;
        this.QUIVER_SIZE = quiverSize;
        this.arrowCount = quiverSize;
        this.damage = arrowType.equalsIgnoreCase("poison")
                ? damage * 2
                : arrowType.equalsIgnoreCase("explosion")
                    ? damage * 3
                    : damage;

    }

    public String getArrowType() {
        return arrowType;
    }

    public int getQUIVER_SIZE() {
        return QUIVER_SIZE;
    }

    public int getArrowCount() {
        return arrowCount;
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
        int maximumRange = 20;
        return maximumRange;
    }
}
