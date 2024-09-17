package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.ui.UserInput;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class GradingApplication implements Runnable
{
    private GradesService gradesService = new GradesFileService();
    private Scanner userInput = new Scanner(System.in);

    public void run()
    {
        while(true)
        {
            int choice = UserInput.homeScreenSelection();
            switch(choice)
            {
                case 1:
                    displayAllFiles();
                    break;
                case 2:
                    displayFileScores();
                    break;
                case 3:
                    displayStudentSummary();
                    break;
                case 4:
                    displayAllStudentStatistics();
                    break;
                case 5:
                    displayAssignmentStatistics();
                    break;
                case 0:
                    UserInput.displayMessage("Goodbye");
                    System.exit(0);
                default:
                    UserInput.displayMessage("Please make a valid selection");
            }
        }
    }

    private void displayAllFiles()
    {
        // todo: 1 - get and display all student file names
        String[] allFiles = gradesService.getFileNames();
        boolean isViewing = true;

        System.out.println();
        System.out.println("Viewing All Files");
        System.out.println("-".repeat(30));
        System.out.println();
        for(String file : allFiles)
        {
            System.out.println(file);
        }

        while(isViewing)
        {
            System.out.println();
            System.out.println("Press Enter to continue...");
            userInput.nextLine();
            isViewing = false;
        }

    }

    private void displayFileScores()
    {
        boolean isViewing = true;
        // todo: 2 - allow the user to select a file name
        // load all student assignment scores from the file - display all files

        File directory = new File("files");
        String[] allFiles = directory.list();
        HashMap<Integer, String> mappedChoices = new HashMap<>();

        int index = 1;
        for(String file: allFiles)
        {
            mappedChoices.put(index, file);
            index++;
        }

        int choice = UserInput.displayFileChoice(allFiles);
        while(isViewing)
        {

            if(choice == 0){ isViewing = false; }
            String chosenFile = mappedChoices.get(choice);
            List<Assignment> allAssignment = gradesService.getAssignments(chosenFile);

            if(chosenFile != null)
            {
                System.out.println();
                System.out.printf("Viewing %s", chosenFile);
                System.out.println();
                System.out.println("-".repeat(30));
                System.out.println();
                for(Assignment assignment : allAssignment)
                {
                    System.out.println(assignment);
                }
                System.out.println();
                System.out.println("Press Enter to continue...");
                userInput.nextLine();
                isViewing = false;
            }
            else
            {
                choice = UserInput.displayFileChoice(allFiles);
            }
        }
    }

    private void displayStudentSummary()
    {
        // todo: 3 - allow the user to select a file name
        // load all student assignment scores from the file - display student statistics (low score, high score, average score)

        File directory = new File("files");
        String[] allFiles = directory.list();
        String fileChoice;

        int choice = UserInput.displayFileChoice(allFiles);
        fileChoice = allFiles[choice-1];


        List<Assignment> allAssignments = gradesService.getAssignments(fileChoice);

        if(!allAssignments.isEmpty())
        {
            var highestScore = allAssignments.stream().mapToInt(Assignment::getScore).max().getAsInt();
            var lowestScore = allAssignments.stream().mapToInt(Assignment::getScore).min().getAsInt();
            var averageScore = allAssignments.stream().mapToInt(Assignment::getScore).average().getAsDouble();


            System.out.println();
            System.out.printf("Viewing %s", fileChoice);
            System.out.println();
            System.out.println("-".repeat(30));
            System.out.printf("Highest Score:     %d\n", highestScore);
            System.out.printf("Lowest Score:      %d\n", lowestScore);
            System.out.printf("Average Score:     %.2f", averageScore);
            System.out.println();
            System.out.println("Press Enter to continue...");
            userInput.nextLine();
        }
        else
        {
            System.out.println("Not Found");
        }
    }

    private void displayAllStudentStatistics()
    {
        // todo: 4 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for all scores (low score, high score, average score, number of students, number of assignments)
        String[] allFiles = gradesService.getFileNames();
        List<Assignment> contentsOfDirectory = gradesService.getAllAssignments(allFiles);

        if(!contentsOfDirectory.isEmpty())
        {
            var highestScore = contentsOfDirectory.stream()
                    .max(Comparator.comparingInt(Assignment::getScore));

            var lowestScore = contentsOfDirectory.stream()
                    .min(Comparator.comparingInt(Assignment::getScore));

            var averageScore = contentsOfDirectory.stream()
                    .mapToInt(Assignment::getScore)
                    .average();

            System.out.println();
            System.out.println("Viewing All Students Summary");
            System.out.println("-".repeat(30));
            System.out.printf("Students: %d  Assignments: %d", allFiles.length, contentsOfDirectory.size());
            System.out.println();
            System.out.println("-".repeat(30));
            System.out.println("Highest Score: " + highestScore.get().getScore());
            System.out.println("Lowest Score: " + lowestScore.get().getScore());
            System.out.println("Average Score: " + Math.round(averageScore.getAsDouble() * 10.0) / 10.0);
            System.out.println();
            System.out.println("Press Enter to continue...");
            userInput.nextLine();
        }
        else
        {
            System.out.println("Not Found");
        }
    }

    private void displayAssignmentStatistics()
    {
        // todo: 5 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for each assignment (assignment name, low score, high score, average score)
        // this one could take some time
        String[] allFiles = gradesService.getFileNames();
        List<Assignment> contentsOfDirectory = gradesService.getAllAssignments(allFiles);
        Map<String, List<Integer>> allScores = new HashMap<>();

        for (String file : allFiles)
        {
            List<Assignment> contentsOfFile = gradesService.getAssignments(file);
            contentsOfFile.stream()
                    .forEach(assignment -> {

                        List<Integer> currentScores = allScores.get(assignment.getAssignmentName());

                        if(currentScores == null)
                        {
                            allScores.put(assignment.getAssignmentName(), new ArrayList<>());
                        }

                        currentScores = allScores.get(assignment.getAssignmentName());
                        currentScores.add(assignment.getScore());
                        allScores.put(assignment.getAssignmentName(), currentScores);
                    });
        }
        allScores.forEach((key, value) -> {

            var highestScore = value.stream().max(Integer::compareTo);
            var lowestScore = value.stream().min(Integer::compareTo);
            var averageScore = value.stream().mapToInt(Integer::intValue).average();

            System.out.println();
            System.out.println(key);
            System.out.println("-".repeat(30));
            System.out.println("Highest Score: " + highestScore.get());
            System.out.println("Lowest Score: " + lowestScore.get());
            System.out.println("Average Score: " + Math.round(averageScore.getAsDouble() * 100.0) / 100.0);
        });
        System.out.println();
        System.out.println("Press Enter to continue...");
        userInput.nextLine();
    }

    private String parseStudentName(String fileName)
    {
        return fileName.replace(".csv", "")
                        .replace("_", " ")
                        .substring(10);
    }
}
