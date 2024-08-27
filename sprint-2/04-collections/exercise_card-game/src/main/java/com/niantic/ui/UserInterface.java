package com.niantic.ui;

import com.niantic.models.Card;
import com.niantic.models.Deck;
import com.niantic.models.Player;

import java.util.ArrayList;

import static com.niantic.ui.ColorCodes.*;

public class UserInterface
{

    public static void displayAddPlayers(int playerCount){
        System.out.println(RED + "=-=-=-=-=-=-=-=-=-=-=-=" + RESET);
        System.out.println(GREEN + "= " + BLUE + "      Player " + playerCount + "       " + RESET + GREEN + "=" + RESET);
        System.out.println(RED + "=-=-=-=-=-=-=-=-=-=-=-=" + RESET);
        System.out.print(YELLOW + "Enter your name: " + RESET);
    }

    public static void displayPlayerTurn(Deck gamePile, Player currentPlayer){
        System.out.println(RED + "  WAR!" + RESET);
        System.out.println("=-=-=-=");
        System.out.println("=     =");
        System.out.println("=  "+ YELLOW + (gamePile.cardOnTop() == null ? 0 : gamePile.cardOnTop().getValue())+ RESET +"  =");
        System.out.println("=     =");
        System.out.println("=-=-=-=");
        System.out.println("Current Player: "+ GREEN + currentPlayer.getName() + RESET);
        System.out.print("Current Hand: ");
        System.out.print(currentPlayer.getHand().toString());
        System.out.println();
        System.out.print("Play Card:");
    }

    public static void displayWinner(Player theWinner)
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println();
        System.out.println(CYAN + "               *               *               *               " + RESET);
        System.out.println(CYAN + "              ***             ***             ***              " + RESET);
        System.out.println(CYAN + "             *****           *****           *****             " + RESET);
        System.out.println(CYAN + "            *******         *******         *******            " + RESET);
        System.out.println(CYAN + "           *********       *********       *********           " + RESET);
        System.out.println(CYAN + "          ***********     ***********     ***********          " + RESET);
        System.out.println(CYAN + "         *************   *************   *************         " + RESET);

        System.out.println();
        System.out.println(YELLOW + "               *               *               *               " + RESET);
        System.out.println(YELLOW + "              ***             ***             ***              " + RESET);
        System.out.println(YELLOW + "             *****           *****           *****             " + RESET);
        System.out.println(YELLOW + "            *******         *******         *******            " + RESET);
        System.out.println(YELLOW + "           *********       *********       *********           " + RESET);
        System.out.println(YELLOW + "          ***********     ***********     ***********          " + RESET);
        System.out.println(YELLOW + "         *************   *************   *************         " + RESET);
        System.out.println(YELLOW + "          ***********     ***********     ***********          " + RESET);
        System.out.println(YELLOW + "           *********       *********       *********           " + RESET);
        System.out.println(YELLOW + "            *******         *******         *******            " + RESET);
        System.out.println(YELLOW + "             *****           *****           *****             " + RESET);
        System.out.println(YELLOW + "              ***             ***             ***              " + RESET);
        System.out.println(YELLOW + "               *               *               *               " + RESET);

        System.out.println();
        System.out.println(PURPLE + BOLD + "                =============================" + RESET);
        System.out.println(PURPLE + BOLD + "                        CONGRATULATIONS       " + RESET);
        System.out.println(PURPLE + BOLD + "                             "+ theWinner + RESET);
        System.out.println(PURPLE + BOLD + "                =============================" + RESET);
    }
}
