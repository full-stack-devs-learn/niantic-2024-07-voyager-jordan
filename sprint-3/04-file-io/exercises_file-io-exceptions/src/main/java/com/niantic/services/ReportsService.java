package com.niantic.services;

import com.niantic.models.StudentData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReportsService {

    // todo: Receive data and write to a file with the data.

    public void createMinimalPersonReport(StudentData studentData)
    {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd");
        String fileName = "reports/" + today.format(formatter) + "_" + studentData.getFullName().replace(" ", "_") + "_minimal" + ".txt";

        File file = new File(fileName);

        try (PrintWriter out = new PrintWriter(file))
        {
            out.println(studentData.getFullName());
            out.println("-".repeat(30));
            out.printf("Lowest Score:              %2d\n", studentData.getLowestScoreFromAll());
            out.printf("Highest Score:             %2d\n", studentData.getHighestScoreFromAll());
            out.printf("Average Score:          %.2f\n", studentData.getAverageScore());
            out.println("-".repeat(30));
        }
        catch (FileNotFoundException e)
        {
            //todo: create error log
        }
    }

    public void createDetailedPersonReport(StudentData studentData)
    {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd");
        String fileName = "reports/" + today.format(formatter) + "_" + studentData.getFullName().replace(" ", "_") + "_detailed" + ".txt";;

        File file = new File(fileName);

        try (PrintWriter out = new PrintWriter(file))
        {
            out.println(studentData.getFullName());
            out.println("-".repeat(37));
            out.println();
            out.println("-".repeat(37));
            out.println("Lowest Score");
            out.println("-".repeat(37));
            studentData.getAssignmentByScore(studentData.getLowestScoreFromAll()).forEach(
                    assignment -> out.println(assignment.toString())
            );
            out.println();
            out.println("-".repeat(37));
            out.println("Highest Score");
            out.println("-".repeat(37));
            studentData.getAssignmentByScore(studentData.getHighestScoreFromAll()).forEach(
                    assignment -> out.println(assignment.toString())
            );
            out.println();
            out.println("-".repeat(37));
            out.println("Average Scores");
            out.println("-".repeat(37));
            studentData.getAssignmentByScore(studentData.getAverageScore(), true).forEach(
                    assignment -> out.println(assignment.toString())
            );

        }
        catch (FileNotFoundException e)
        {
            //todo: Create error log
        }
    }
}
