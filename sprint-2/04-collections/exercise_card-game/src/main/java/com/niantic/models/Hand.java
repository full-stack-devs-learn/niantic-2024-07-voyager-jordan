package com.niantic.models;

import java.util.ArrayList;
import java.util.List;

public class Hand
{
    private ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public int getPointValue()
    {
        // return sum of all card points
        int sum = 0;

        for(Card card : cards)
        {
            sum += card.getNumberValue();
        }
        return sum;
    }

    public int getCardCount()
    {
        return cards.size();
    }

    public void dealTo(Card card)
    {
        cards.add(card);
    }

    public void removeCard(String cardToRemove){
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getValue().equals(cardToRemove)) {
                cards.remove(i);
                break;
            }
        }
    }

    @Override
    public String toString(){
        String inHand = "";
        for(Card card : cards){
            inHand += card.getValue() + " ";
        }
        return inHand;
    };
}
