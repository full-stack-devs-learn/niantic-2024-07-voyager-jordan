package com.niantic;

import java.util.Arrays;
import java.util.Scanner;


public class Main
{

    private static Scanner userInput = new Scanner(System.in);
    private static int[] scores = new int[0];


    public static void main(String[] args)
    {
        while(true)
        {
            int choice = getHomeSelection();

            switch(choice)
            {
                case 1:
                    createNewTestScores(scores);
                    break;
                case 2:
                    calculateAverage(scores);
                    break;
                case 3:
                    findHighestScore(scores);
                    break;
                case 4:
                    findLowestScore(scores);
                    break;
                case 0:
                    System.out.println("Thanks for playing!");
                    System.out.println("Good bye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid selection!");
                    break;
            }
        }
    }

    public static int getHomeSelection()
    {
        System.out.println();
        System.out.println("Welcome to Test Score Calculator!");
        System.out.println("------------------------------");
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1) Enter new test scores");
        System.out.println("2) Calculate the class average");
        System.out.println("3) Find the highest score");
        System.out.println("4) Find the lowest score");
        System.out.println("0) Exit");

        System.out.print("Please select an option:");
        return Integer.parseInt(userInput.nextLine());
    }

    private static void createNewTestScores(int[] currentScores)
    {
        //Declare length Variable decided by current array length and adding ONE;
        int length = currentScores.length + 1;
        int[] newArray;
        //Created a newArray that copies current scores and adds an extra spot;
        newArray = Arrays.copyOf(currentScores, length);
        //Collects user input
        System.out.print("Enter your test score: ");
        int userScore = Integer.parseInt(userInput.nextLine());
        System.out.println();

        //Assigns data to the new arrays end position
        newArray[length - 1] = userScore;
        //Copies score back over to Global Score Variable
        scores = Arrays.copyOf(newArray, newArray.length);

        System.out.println("Your Score has been added!");


    }

    private static void calculateAverage(int[] usersScores)
    {
        if(usersScores.length == 0){
            System.out.println();
            System.out.println("No scores currently loaded");
        } else {
            int average = 0;
            for (int score : usersScores){
                average += score;
            }
            average = average / usersScores.length;
            System.out.println();
            System.out.println("Your average score is: " + average);
        }
    }

    private static void findHighestScore(int[] usersScores)
    {
        if(usersScores.length == 0){
            System.out.println();
            System.out.println("No scores currently loaded");
        } else {
            int currentHighest = usersScores[0];
            for (int score : usersScores){
                currentHighest = Math.max(score, currentHighest);
            }
            System.out.println();
            System.out.println("Your highest score is: " + currentHighest);
        }
    }

    private static void findLowestScore(int[] usersScores)
    {
        if(usersScores.length == 0){
            System.out.println();
            System.out.println("No scores currently loaded");
        } else {
            int currentLowest = usersScores[0];
            for (int score : usersScores){
                currentLowest = Math.min(score, currentLowest);
            }
            System.out.println();
            System.out.println("Your lowest score is: " + currentLowest);
        }
    }

}