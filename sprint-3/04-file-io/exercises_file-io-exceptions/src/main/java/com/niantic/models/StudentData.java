package com.niantic.models;

import java.util.List;

public class StudentData {

    private String fullName;
    private List<Assignment> assignments;

    public StudentData(List<Assignment> assignments)
    {
        this.assignments = assignments;
        this.fullName = assignments.getFirst().getFirstName() + " "+ assignments.getFirst().getLastName();
    }

    public String getFullName() {
        return fullName;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public int getHighestScoreFromAll()
    {
        return assignments.stream().mapToInt(Assignment::getScore).max().getAsInt();
    }

    public int getLowestScoreFromAll()
    {
        return assignments.stream().mapToInt(Assignment::getScore).min().getAsInt();
    }

    public double getAverageScore()
    {
        return assignments.stream().mapToInt(Assignment::getScore).average().getAsDouble();
    }

    public List<Assignment> getAssignmentByScore(int score)
    {
        var result = assignments.stream().filter(assignment -> assignment.getScore() == score).toList();
        return result;
    }

    public List<Assignment> getAssignmentByScore(double score, boolean isAverage)
    {
        int parsedScore = (int)Math.round(score);
        if (!isAverage) return null;
        var result = assignments.stream().filter(assignment -> assignment.getScore() == parsedScore + 1 ||
                                                         assignment.getScore() == parsedScore - 1)
                                   .toList();
        return result;
    }

}
