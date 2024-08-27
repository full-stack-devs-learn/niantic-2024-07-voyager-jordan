package com.niantic.models;

import java.util.ArrayList;

public class Hand
{
    private ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    // HAND SIZE
    public int getCardCount()
    {
        return cards.size();
    }

    // PERSON --> HAND
    public void dealTo(Card card)
    {
        if(!card.getValue().isEmpty()){
            cards.add(card);
        }
    }

    // DISCARD A CARD
    public void removeCardofValue(String cardToRemove){
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getValue().equals(cardToRemove)) {
                cards.remove(i);
                break;
            }
        }

    }

    // DISPLAY CARDS IN HAND
    @Override
    public String toString(){
        String inHand = "";
        for(Card card : cards){
            inHand += card.getValue() + " ";
        }
        return inHand;
    };
}
