package com.niantic.part_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuizTests
{
        /*
    Methods Tested
    - possiblePoints must be positive.
    - score must be positive.
    Get Percentage.
    Get Letter Grade.

    */
    @Test
    public void getPercent_returnPercentScoreOfStudent_expectPositiveValue()
    {
        // Arrange
        int possiblePoints = 100;
        int studentsScore = 50;
        String studentName = "John Doe";
        Quiz quiz = new Quiz(possiblePoints, studentName);
        quiz.setScore(studentsScore);
        int expectedPercent = 50;

        // Act
        int actualPercent = quiz.getPercent();

        // Assert
        assertEquals(expectedPercent, actualPercent, "Expected '50'");
    }

    @Test
    public void getLetterGrade_returnGradeOfStudent_expectA()
    {
        // Arrange
        int possiblePoints = 100;
        int studentsScore = 90;
        String studentName = "John Doe";
        Quiz quiz = new Quiz(possiblePoints, studentName);
        quiz.setScore(studentsScore);
        String expectedGrade = "A";
        // Act
        String actualGrade = quiz.getLetterGrade();
        // Assert
        assertEquals(expectedGrade, actualGrade, "Expected 'A'");
    }
    @Test
    public void getLetterGrade_returnGradeOfStudent_expectB()
    {
        // Arrange
        int possiblePoints = 100;
        int studentsScore = 80;
        String studentName = "John Doe";
        Quiz quiz = new Quiz(possiblePoints, studentName);
        quiz.setScore(studentsScore);
        String expectedGrade = "B";
        // Act
        String actualGrade = quiz.getLetterGrade();
        // Assert
        assertEquals(expectedGrade, actualGrade, "Expected 'B'");
    }
    @Test
    public void getLetterGrade_returnGradeOfStudent_expectC()
    {
        // Arrange
        int possiblePoints = 100;
        int studentsScore = 70;
        String studentName = "John Doe";
        Quiz quiz = new Quiz(possiblePoints, studentName);
        quiz.setScore(studentsScore);
        String expectedGrade = "C";
        // Act
        String actualGrade = quiz.getLetterGrade();
        // Assert
        assertEquals(expectedGrade, actualGrade, "Expected 'C'");
    }
    @Test
    public void getLetterGrade_returnGradeOfStudent_expectD()
    {
        // Arrange
        int possiblePoints = 100;
        int studentsScore = 60;
        String studentName = "John Doe";
        Quiz quiz = new Quiz(possiblePoints, studentName);
        quiz.setScore(studentsScore);
        String expectedGrade = "D";
        // Act
        String actualGrade = quiz.getLetterGrade();
        // Assert
        assertEquals(expectedGrade, actualGrade, "Expected 'D'");
    }
    @Test
    public void getLetterGrade_returnGradeOfStudent_expectF()
    {
        // Arrange
        int possiblePoints = 100;
        int studentsScore = 59;
        String studentName = "John Doe";
        Quiz quiz = new Quiz(possiblePoints, studentName);
        quiz.setScore(studentsScore);
        String expectedGrade = "F";
        // Act
        String actualGrade = quiz.getLetterGrade();
        // Assert
        assertEquals(expectedGrade, actualGrade, "Expected 'F'");
    }
}