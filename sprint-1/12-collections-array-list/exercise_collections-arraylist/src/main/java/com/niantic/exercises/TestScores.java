package com.niantic.exercises;

import com.niantic.models.TestScore;

import java.util.ArrayList;
import java.util.Objects;

public class TestScores
{

    /*
    1.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a test - return all scores for the
        requested tests.
     */
    public ArrayList<TestScore> getScoresByTest(ArrayList<TestScore> testScores, String testName)
    {
        ArrayList<TestScore> groupByTest = new ArrayList<>();
        for(var student : testScores){
            if(Objects.equals(student.getTestName(), testName)){
                groupByTest.add(student);
            }
        }

        return groupByTest;
    }

    /*
    2.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores and the name of a student - return all scores for the
        requested student.
     */
    public ArrayList<TestScore> getScoresByStudent(ArrayList<TestScore> testScores, String student)
    {
        ArrayList<TestScore> groupByStudent = new ArrayList<>();
        for(var person : testScores){
            if(Objects.equals(person.getStudentName(), student)){
                groupByStudent.add(person);
            }
        }

        return groupByStudent;
    }

    /*
    3.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score.
     */
    public int getHighestScore(ArrayList<TestScore> testScores)
    {
        int currentHighest = testScores.getFirst().getScore();

        for(var student : testScores){
            if(student.getScore() > currentHighest){
                currentHighest = student.getScore();
            }
        }

        return currentHighest;
    }

    /*
    4.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score.
     */
    public int getLowestScore(ArrayList<TestScore> testScores)
    {
        int currentLowest = testScores.getFirst().getScore();

        for(var student : testScores){
            if(student.getScore() < currentLowest){
                currentLowest = student.getScore();
            }
        }

        return currentLowest;
    }

    /*
    5.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score.
     */
    public int getAverageScore(ArrayList<TestScore> testScores)
    {
        int average = 0;

        for(var student : testScores){
                average += student.getScore();
        }

        return average / testScores.size();
    }

    /*
    6.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified test name.
     */
    public int getHighestScoreByTest(ArrayList<TestScore> testScores, String testName)
    {

        ArrayList<TestScore> specificTests = getScoresByTest(testScores, testName);
        int currentHighest = specificTests.getFirst().getScore();

        for(var student : specificTests){
                if(student.getScore() > currentHighest){
                    currentHighest = student.getScore();
            }
        }

        return currentHighest;
    }

    /*
    7.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified test name.
     */
    public int getLowestScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        ArrayList<TestScore> specificTests = getScoresByTest(testScores, testName);
        int currentLowest = specificTests.getFirst().getScore();

        for(var student : specificTests){
            if(student.getScore() < currentLowest){
                currentLowest = student.getScore();
            }
        }

        return currentLowest;
    }

    /*
    8.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified test name.
     */
    public int getAverageScoreByTest(ArrayList<TestScore> testScores, String testName)
    {
        ArrayList<TestScore> specificTests = getScoresByTest(testScores, testName);
        int average = 0;

        for(var student : specificTests){
            average += student.getScore();
        }
        return average / specificTests.size();
    }

    /*
    9.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the highest score for the specified student.
     */
    public int getHighestScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        ArrayList<TestScore> specificStudent = getScoresByStudent(testScores, student);
        int currentHighest = specificStudent.getFirst().getScore();

        for(var test : specificStudent){
            if(test.getScore() > currentHighest){
                currentHighest = test.getScore();
            }
        }
        return currentHighest;
    }

    /*
    10.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the lowest score for the specified student.
     */
    public int getLowestScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        ArrayList<TestScore> specificStudent = getScoresByStudent(testScores, student);
        int currentLowest = specificStudent.getFirst().getScore();

        for(var test : specificStudent){
            if(test.getScore() < currentLowest){
                currentLowest = test.getScore();
            }
        }
        return currentLowest;
    }

    /*
    11.  An ArrayList of TestScores contains test results for all students and all of their tests
        Given an input of All testScores return the average score for the specified student.
     */
    public int getAverageScoreByStudent(ArrayList<TestScore> testScores, String student)
    {
        ArrayList<TestScore> specificStudent = getScoresByStudent(testScores, student);
        int average = 0;

        for(var test : specificStudent){
            average += test.getScore();
        }
        return average / specificStudent.size();
    }
}
