package com.niantic.application;

import com.niantic.models.Card;
import com.niantic.models.Deck;
import com.niantic.models.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static com.niantic.ui.ColorCodes.CYAN;
import static com.niantic.ui.UserInterface.*;

public class CardGameApplication
{
    Scanner userInput = new Scanner(System.in);

    //Game Variables
    Deck deck = new Deck();
    Deck gamePile = new Deck(true);
    ArrayList<Player> players = new ArrayList<>();
    Player winner = null;


    //Game Start
    boolean gameActive = false;
    public void run()
    {
        addPlayers();
        dealCards();

        //SET TO FALSE TO SEE WINNER SCREEN
        gameActive = true;
        Queue<Player> playOrder = new LinkedList<>(players);

        //WHILE GAME IS ACTIVE
        while(gameActive){

            //Check if there is players
            if(playOrder.isEmpty()){ gameActive = false; }
            takeTurn(playOrder);

        }
        //INITIATE WINNER SCREEN
        displayWinner(winner);
    }

    private Queue<Player> takeTurn(Queue<Player> playersQueue){       //GETS FIRST PERSON IN QUEUE
            Player currentPlayer = playersQueue.peek();

            //VARIBLES FOR VALIDATION
            boolean isValid = false;
            Card validatedCard = null;
            String validatedText = null;

            while(!isValid){
                displayPlayerTurn(gamePile, currentPlayer);
                String cardChoice = userInput.next().toUpperCase();
                Card cardToCompare = cardChoice.isEmpty() ? null : new Card(cardChoice);

                 var cardFound = currentPlayer.getHand().getCards().stream()
                                                  .filter(card -> getValue(card).equals(cardToCompare.getValue()))
                                                  .findFirst();

                 if(cardFound.isPresent()){
                     validatedCard = cardToCompare;
                     validatedText = cardChoice;
                     isValid = true;
                 }
            }

            int currentHighest = gamePile.cardOnTop() == null ? 0 : gamePile.cardOnTop().getNumberValue();

            //CHECKS IF CHOICE BEATS CURRENT HIGHEST
            if(validatedCard.getNumberValue() >= currentHighest){
                //Remove card from current player's hand
                currentPlayer.getHand().removeCardofValue(validatedText.toUpperCase());

                //Adds card to the game pile
                gamePile.playCard(new Card(validatedText.toUpperCase()));

                //Win Condition -- After placing check to see if hand is empty
                if(currentPlayer.getHand().getCards().isEmpty()){
                    gameActive = false;
                    winner = currentPlayer;
                }

            } else {
                System.out.println(CYAN + "You lost the battle but not the war");
                try {
                    Thread.sleep(1500);
                    gamePile.giveDeck(currentPlayer);// Sleep for 2000 milliseconds (2 seconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        //MOVES PLAYER TO THE BACK
        currentPlayer = playersQueue.poll();
        playersQueue.offer(currentPlayer);
        //RETURNS A NEW QUEUE
        return playersQueue;
    }

    private static String getValue(Card card) {
        return card.getValue();
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
