package com.niantic.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> cards;

    public Deck(boolean isEmpty) { cards = new ArrayList<>(); }

    public Deck()
    {
        // build the deck of cards
        cards = new ArrayList<>();

        //Refactored original code to use suits and also added face cards.
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for(int i = 0; i < 4; i++){
            for(String value : values)
            {
                Card card = new Card(value);
                cards.add(card);
            }
        }
    }

    public int getCardCount()
    {
        return cards.size();
    }
    public Card takeCard()
    {
        Card card = cards.removeFirst();
        return card;
    }
    public void playCard(Card card)
    {
        cards.add(card);
    }
    public void shuffle()
    {
        Collections.shuffle(cards);
    }
    public void giveDeck(Player targetPlayer)
    {
        //Give deck to target player
        while(!cards.isEmpty()){
            targetPlayer.dealTo(cards.removeFirst());
        }

    }

    public Card cardOnTop()
    {
        if(cards.isEmpty()){ return null; }

        return cards.getLast();
    }
}
