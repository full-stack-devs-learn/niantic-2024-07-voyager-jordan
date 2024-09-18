package com.niantic.ui;

import java.util.HashMap;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class UserInput
{
    protected static Scanner in = new Scanner(System.in);

    public static int homeScreenSelection()
    {
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("-".repeat(30));
        System.out.println();
        System.out.println("  1) display files");
        System.out.println();
        System.out.println("  ------------ Individual File ------------");
        System.out.println("  2) Student: display all scores");
        System.out.println("  3) Student: display average score");
        System.out.println("  4) Student: generate & view report");
        System.out.println();
        System.out.println("  ---------- Challenge All Files ----------");
        System.out.println("  5) All Students: display average score");
        System.out.println("  6) All Assignments: display average score");
        System.out.println();
        System.out.println("  0) Exit");

        System.out.println();
        System.out.print("Please make a selection: ");

        return Integer.parseInt(in.nextLine());
    }

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
    }

    public static int displayFileChoice(String[] availableFiles)
    {
        System.out.println();
        System.out.println("Viewing available files");
        System.out.println("-".repeat(30));
        System.out.println();
        //Dynamically Add Files Here
        int index = 1;
        for(String file : availableFiles)
        {
            System.out.printf("  %d) %s", index, file);
            System.out.println();
            index++;
        }
        System.out.println();
        System.out.println("  0) Back");

        System.out.println();
        System.out.print("Choose File: ");

        return Integer.parseInt(in.nextLine());
    }

    public static int displayReportChoices()
    {
        System.out.println();
        System.out.println("  ------------ Report Type ------------");
        System.out.println("  1) Minimal Report");
        System.out.println("  2) Detailed Report");
        System.out.println();
        System.out.println("  0) Exit");
        System.out.println();
        System.out.print("Choose Report Type: ");

        return Integer.parseInt(in.nextLine());

    }
    public static void displayHeaderWithTitle(String title)
    {
        System.out.println();
        System.out.println(title);
        System.out.println("-".repeat(30));
        System.out.println();
    }

    public static void enterToContinue()
    {
        System.out.println();
        System.out.println("Press Enter to continue...");
        in.nextLine().isEmpty();
    }

}
