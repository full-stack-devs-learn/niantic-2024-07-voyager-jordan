package com.niantic;

import java.util.HashSet;
import java.util.Set;


public class Bow extends Weapon
{
    private static final Set<String> ARROW_TYPES = new HashSet<>();
    static {
        ARROW_TYPES.add("Standard");
        ARROW_TYPES.add("Poison");
        ARROW_TYPES.add("Explosive");
    }

    private String arrowType;
    private final int QUIVER_SIZE;
    private int arrowCount;

    public Bow(String name, int damage, int quiverSize)
    {
        super(name, damage);
        if(!ARROW_TYPES.contains(name)){
            throw new IllegalArgumentException("Invalid name must be one of "+ ARROW_TYPES);
        }
        this.QUIVER_SIZE = quiverSize;
        this.arrowCount = quiverSize;
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
        return 0;
    }
}
