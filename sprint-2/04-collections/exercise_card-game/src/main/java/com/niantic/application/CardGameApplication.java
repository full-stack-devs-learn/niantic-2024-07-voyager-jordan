package com.niantic.application;

import com.niantic.models.Card;
import com.niantic.models.Deck;
import com.niantic.models.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static com.niantic.ui.UserInterface.displayAddPlayers;

public class CardGameApplication
{
    Deck deck = new Deck();
    Deck gamePile = new Deck(true);
    ArrayList<Player> players = new ArrayList<>();
    Scanner userInput = new Scanner(System.in);
    boolean gameActive = false;

    
    public void run()
    {
        addPlayers();
        dealCards();

        gameActive = true;
        Queue<Player> playOrder = new LinkedList<>(players);

        while(gameActive){

            //Check if there is players
            if(playOrder.isEmpty()){ gameActive = false; }
            takeTurn(playOrder);

        }
    }

    private Queue<Player> takeTurn(Queue<Player> playersQueue)
    {
            Player currentPlayer = playersQueue.peek();

            System.out.println("  WAR!");
            System.out.println("=-=-=-=");
            System.out.println("=     =");
            System.out.println("=  " + (gamePile.cardOnTop() == null ? 0 : gamePile.cardOnTop().getValue())  +"  =");
            System.out.println("=     =");
            System.out.println("=-=-=-=");
            System.out.println("Current Player: " + currentPlayer.getName());
            System.out.print("Current hand: ");
            System.out.print(currentPlayer.getHand().toString());
            System.out.println();
            System.out.print("Play Card:");

            String cardChoice = userInput.next().toUpperCase();
            Card cardToCompare = new Card(cardChoice);
            int currentHighest = gamePile.cardOnTop() == null ? 0 : gamePile.cardOnTop().getNumberValue();

            if(cardToCompare.getNumberValue() < currentHighest){
                gamePile.giveDeck(currentPlayer);
            } else {
                //Remove card from active player
                currentPlayer.getHand().removeCard(cardChoice.toUpperCase());
                //Win Condition
                if(currentPlayer.getHand().getCards().isEmpty()){
                    gameActive = false;
                }
                //Add To Deck
                gamePile.playCard(new Card(cardChoice.toUpperCase()));
            }
        currentPlayer = playersQueue.poll();
        playersQueue.offer(currentPlayer);
        return playersQueue;
    }

    private void dealCards()
    {
        deck.shuffle();

        //While deck is full;
        while(deck.getCardCount() > 0)
        {
            //Distribute until deck is gone
            for(Player player : players)
            {
                Card card = deck.takeCard();
                player.dealTo(card);
            }
        }
    }

    private void addPlayers()
    {
        int playerCount = 1;
        while(players.size() < 2){

            displayAddPlayers(playerCount);
            String playerName = userInput.next();
            System.out.println();

            players.add(new Player(playerName.trim()));
            playerCount++;
        }

    }
}
