package com.niantic.application;

import com.niantic.models.Assignment;
import com.niantic.models.StudentData;
import com.niantic.services.GradesFileService;
import com.niantic.services.GradesService;
import com.niantic.services.LoggingService;
import com.niantic.services.ReportsService;
import com.niantic.ui.UserInput;

import java.io.File;
import java.util.*;

public class GradingApplication implements Runnable
{
    private GradesService gradesService = new GradesFileService();
    private Scanner userInput = new Scanner(System.in);
    private LoggingService errorLog = new LoggingService("error");
    private LoggingService appLog = new LoggingService("application");

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
                case 4 :
                    studentReportInterface();
                    break;
                case 5:
                    displayAllStudentStatistics();
                    break;
                case 6:
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
        String title = "Viewing All Files";

        UserInput.displayHeaderWithTitle(title);

        Arrays.stream(allFiles).sorted().forEach(System.out::println);

        UserInput.enterToContinue();
    }

    private void displayFileScores()
    {
        // todo: 2 - allow the user to select a file name
        // load all student assignment scores from the file - display all files
        File getDirectory = new File("files");
        String[] choices = getDirectory.list();
        HashMap<Integer, String> mappedChoices = new HashMap<>();

        int index = 1;
        for(String file: choices)
        {
            mappedChoices.put(index, file);
            index++;
        }

        int choice = UserInput.displayFileChoice(choices);
        String chosenFile = mappedChoices.get(choice);
        List<Assignment> allAssignment = gradesService.getAssignments(chosenFile);
        Boolean valid = false;

        while(!valid)
        {
            try
            {
                if(chosenFile != null)
                {
                    UserInput.displayHeaderWithTitle(String.format("Viewing %s", chosenFile));
                    allAssignment.forEach(System.out::println);
                    UserInput.enterToContinue();
                    valid = true;
                }
                else
                {
                    System.out.println("Invalid choice");
                }
            }
            catch(Exception e)
            {
                choice = UserInput.displayFileChoice(choices);
            }
        }
    }

    private void displayStudentSummary()
    {
        // todo: 3 - allow the user to select a file name
        // load all student assignment scores from the file - display student statistics (low score, high score, average score)
        boolean isValid = false;
        File directory = new File("files");
        String[] allFiles = directory.list();

        int choice;
        String chosenFile = "";

        while(!isValid)
        {
            choice = UserInput.displayFileChoice(allFiles);
            if(choice <= allFiles.length) {
                chosenFile = allFiles[choice-1];
                isValid = true;
            }
        }

        try
        {
            List<Assignment> allAssignments = gradesService.getAssignments(chosenFile);

            if (allAssignments.isEmpty()) return;

            var highestScore = allAssignments.stream().mapToInt(Assignment::getScore).max().getAsInt();
            var lowestScore = allAssignments.stream().mapToInt(Assignment::getScore).min().getAsInt();
            var averageScore = allAssignments.stream().mapToInt(Assignment::getScore).average().getAsDouble();

            UserInput.displayHeaderWithTitle(String.format("Viewing %s", chosenFile));
            System.out.printf("Highest Score:     %d\n", highestScore);
            System.out.printf("Lowest Score:      %d\n", lowestScore);
            System.out.printf("Average Score:     %.2f", averageScore);
            UserInput.enterToContinue();
        }
        catch(Exception e)
        {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

    }

    private void displayAllStudentStatistics()
    {
        // todo: 4 - Optional / Challenge - load all scores from all student and all assignments
        // display the statistics for all scores (low score, high score, average score, number of students, number of assignments)
        String[] allFiles = gradesService.getFileNames();
        List<Assignment> contentsOfDirectory = gradesService.getAllAssignments(allFiles);

        if(contentsOfDirectory.isEmpty()) return;

        var highestScore = contentsOfDirectory.stream().mapToInt(Assignment::getScore).max().getAsInt();
        var lowestScore = contentsOfDirectory.stream().mapToInt(Assignment::getScore).min().getAsInt();
        var averageScore = contentsOfDirectory.stream().mapToInt(Assignment::getScore).average().getAsDouble();

        UserInput.displayHeaderWithTitle("Viewing All Students Summary");
        System.out.printf("Students: %d  Assignments: %d\n", allFiles.length, contentsOfDirectory.size());
        System.out.println("-".repeat(30));
        System.out.printf("Highest Score:     %d\n", highestScore);
        System.out.printf("Lowest Score:      %d\n", lowestScore);
        System.out.printf("Average Score:     %.2f\n", averageScore);
        UserInput.enterToContinue();
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

            UserInput.displayHeaderWithTitle(key);
            System.out.printf("Highest Score:     %d\n", highestScore.get());
            System.out.printf("Lowest Score:      %d\n", lowestScore.get());
            System.out.printf("Average Score:     %.2f\n", averageScore.getAsDouble());
        });
        UserInput.enterToContinue();
    }

    private void studentReportInterface()
    {
        LoggingService reports = new LoggingService("reports");
        ReportsService buildReport = new ReportsService();

        boolean isValid = false;
        String[] allFiles = gradesService.getFileNames();

        int choice;
        String chosenFile = "";

        while(!isValid)
        {
            choice = UserInput.displayFileChoice(allFiles);
            if(choice <= allFiles.length) {
                chosenFile = allFiles[choice-1];
                isValid = true;
            }
        }

        List<Assignment> studentFile = gradesService.getAssignments(chosenFile);
        StudentData studentData = new StudentData(studentFile);

        isValid = false;
        while(!isValid)
        {
            choice = UserInput.displayReportChoices();
            switch(choice)
            {
                case 1:
                    buildReport.createMinimalPersonReport(studentData);
                    isValid = true;
                    break;
                case 2:
                    buildReport.createDetailedPersonReport(studentData);
                    isValid = true;
                    break;
                case 0:
                    return;
            }
        }

    }
    private String parseStudentName(String fileName)
    {
        return fileName.replace(".csv", "")
                .replace("_", " ")
                .substring(10);
    }
}
