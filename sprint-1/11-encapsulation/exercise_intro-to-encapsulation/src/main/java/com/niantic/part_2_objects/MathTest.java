package com.niantic.part_2_objects;

public class MathTest
{
    //Variables
    private int score;
    private int possibleScore;
    private String studentName;

    //Constructor
    public MathTest(int possibleScore, String studentName){
        this.possibleScore = possibleScore;
        this.studentName = studentName;
    };

    //Methods
    public String getStudentName(){
        return studentName;
    };
    public int getScore(){
        return score;
    };
    public int setScore(int score){
        return this.score = score;
    };
    public int getPossiblePoints(){
        return possibleScore;
    };
    public int getPercent(){
        return (int)((this.score / (double)this.possibleScore) * 100);
    };

    public String getLetterGrade(){
        int percent = (int)((this.score / (double)this.possibleScore) * 100);

        if (percent >= 90) {
            return "A";
        } else if (percent >= 80) {
            return "B";
        } else if (percent >= 70) {
            return "C";
        } else if (percent >= 60) {
            return "D";
        } else {
            return "F";
        }
    };

}
