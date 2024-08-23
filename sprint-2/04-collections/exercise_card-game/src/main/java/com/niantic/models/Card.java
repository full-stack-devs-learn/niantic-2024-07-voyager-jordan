package com.niantic.models;

import java.util.HashMap;

public class Card {
    private final String value;

    public Card(String value) {
        this.value = value;
    }


    public String getValue (){ return this.value; }


    public int getNumberValue() {

        HashMap<String, Integer> valueLookup = new HashMap<>(){{
            put("A", 14);
            put("K", 13);
            put("Q", 12);
            put("J", 11);
            put("10", 10);
            put("9", 9);
            put("8", 8);
            put("7", 7);
            put("6", 6);
            put("5", 5);
            put("4", 4);
            put("3", 3);
            put("2", 2);
        }};

        return valueLookup.get(value);
    }

}