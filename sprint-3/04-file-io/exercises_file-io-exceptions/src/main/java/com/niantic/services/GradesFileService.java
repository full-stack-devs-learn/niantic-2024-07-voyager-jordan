package com.niantic.services;

import com.niantic.models.Assignment;

import java.io.File;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GradesFileService implements GradesService
{


    @Override
    public String[] getFileNames()
    {
        String[] result = new String[0];

        try
        {
            File directory = new File("files");
            result = directory.list();
            return result;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public List<Assignment> getAssignments(String fileName)
    {
        List<Assignment> assignments = new ArrayList<>();
        File file = new File("files/" + fileName);

        try(Scanner reader = new Scanner(file))
        {
            //Skip Header
            reader.nextLine();
            while(reader.hasNext())
            {
                String line = reader.nextLine();
                var column = line.split(",");

                int number = Integer.parseInt(column[0]);
                String assignmentName = column[1];
                String firstName = column[2];
                String lastName = column[3];
                int score = Integer.parseInt(column[4]);

                Assignment assignment = new Assignment(number, assignmentName, firstName, lastName, score);
                assignments.add(assignment);
            }
        }
        catch(Exception e)
        {
            //eating the error for now
        }

        return assignments;
    }

    @Override
    public List<Assignment> getAllAssignments(String[] fileNames)
    {
        List<Assignment> allAssignments = new ArrayList<>();

        for(String file : fileNames)
        {
            List<Assignment> contentsOfFile = getAssignments(file);
            allAssignments.addAll(contentsOfFile);
        }

        return allAssignments;
    }

}
