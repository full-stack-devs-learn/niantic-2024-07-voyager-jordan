package com.nianatic;

public class ExercisesChallenge
{

    /*
     * Given an array of numbers, add only
     * the first 2 numbers and return
     * the answer.
     *
     * The array may have fewer than 2 numbers,
     * so you will need to have logic to deal
     * with that.
     *
     * sumFirst2Numbers([1, 2, 3])       =>  3
     * sumFirst2Numbers([10, 8, 14, 32]) =>  18
     * sumFirst2Numbers([3])             =>  3
     * sumFirst2Numbers([])              =>  0
     */
    public int sumFirst2Numbers(int[] numbers)
    {

        if(numbers.length == 0){return 0;}
        if(numbers.length == 1){return numbers[0];}
        if(numbers.length == 2){return numbers[0] + numbers[1];}
        if(numbers.length > 2){return numbers[0] + numbers[1];}

        return 0;
    }

    /*
     * Given an array of names, create a
     * new array of the same size. The new
     * array should have all of the names
     * in it but in reverse order.
     *
     * reverseNames(["Ron", "Lisa", "Kent", "Michelle"]) => ["Michelle", "Kent", "Lisa", "Ron"]
     */
    public String[] reverseNames(String[] names)
    {
        String temp;

        //I used names.length / 2 because it replaces two at a time
        for (int i = 0; i < names.length / 2; i++) {
            //Stored current index
            temp = names[i];
            //Reassigned current index with last index
            names[i] = names[names.length - (i+1)];
            //Reassigned last index with stored data
            names[names.length - (i+1)] = temp;
        }
        return names;
    }



    /*
     * Given a multidimensional array of numbers,
     * combine all numbers into a single 1 dimensional array
     *
     * The nested arrays will all have numbers
     * but the amount can vary
     *
     * combineArrays([
     *                [1,2,3],
     *                [4,5,6],
     *                [7,8,9]
     *               ])         =>  [1,2,3,4,5,6,7,8,9]
     *
     * combineArrays([
     *                [1,2],
     *                [3,4,5,6],
     *                [7,8,9]
     *               ])         =>  [1,2,3,4,5,6,7,8,9]
     *
     * combineArrays([
     *                [1,2,3,4],
     *                [5,6,7,8,9]
     *               ])         =>  [1,2,3,4,5,6,7,8,9]
     */
    public int[] combineArrays(int[][] numbers)
    {
        int lengthOfAllArrays = 0;
        int currentIndex = 0;

        //Used to find length of combined arrays
        for (int i = 0; i < numbers.length; i++) {
            lengthOfAllArrays += numbers[i].length;
        }

        //Declared combinedArrays and made it the length of all Arrays
        int[] combinedArrays = new int[lengthOfAllArrays];

        //Looped through arrays
        for (int i = 0; i < numbers.length; i++) {

            //Looped through elements in arrays
            for (int j = 0; j < numbers[i].length; j++) {

                //Added the value of arrays in to combined Arrays
                combinedArrays[currentIndex] = numbers[i][j];

                //This value is used to keep track on current index
                currentIndex++;
            }
        }
        return combinedArrays;
    }
}
