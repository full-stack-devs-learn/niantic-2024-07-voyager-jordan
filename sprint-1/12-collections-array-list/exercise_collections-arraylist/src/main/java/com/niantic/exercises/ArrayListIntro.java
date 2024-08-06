package com.niantic.exercises;

import java.util.ArrayList;

public class ArrayListIntro
{
    /*
    1. Create an ArrayList of Strings and add the names of your
       5 favorite heroes.

    Return the list.
     */
    public ArrayList<String> getHeroesList()
    {
        ArrayList<String> heroesList = new ArrayList<>();

        heroesList.add("Thor");
        heroesList.add("Black Panther");
        heroesList.add("Captain America");
        heroesList.add("Hulk");
        heroesList.add("Loki");

        return heroesList;
    }

    /*
    2. Given a list of integers, create and return a new list of just the
       even numbers in the list

       findEvens( [1, 2, 3, 4] )            ->  [2, 4]
       findEvens( [21, 98, 78, 5, 6, 8] )   ->  [98, 78, 6, 8]
     */
    public ArrayList<Integer> findEvens(ArrayList<Integer> numbers)
    {
        ArrayList<Integer> evensList = new ArrayList<>();

        for (Integer num : numbers){
            if(num % 2 == 0){
                evensList.add(num);
            }
        }

        return evensList;
    }

    /*
    3. Given a list of integers, return the sum of all numbers

       sum( [1, 2, 3, 4] )            ->  10
       sum( [21, 98, 78, 5, 6, 8] )   ->  216
     */
    public int sum(ArrayList<Integer> numbers)
    {
        int sum = 0;

        for (Integer each : numbers){
            sum += each;
        }

        return sum;
    }

    /*
    4. Given a list of integers, return the highest number

       sum( [1, 2, 3, 4] )            ->  4
       sum( [21, 98, 78, 5, 6, 8] )   ->  98
     */
    public int max(ArrayList<Integer> numbers)
    {
        int currentHighest = numbers.getFirst();

        for (Integer num : numbers){
            if(num > currentHighest){
                currentHighest = num;
            }
        }

        return currentHighest;
    }

    /*
    5. Given a list of integers, return the lowest number

       sum( [1, 2, 3, 4] )            ->  1
       sum( [21, 98, -78, 5, 6, 8] )  ->  -78
     */
    public int min(ArrayList<Integer> numbers)
    {
        int currentLowest = numbers.getFirst();

        for(Integer nums : numbers){
            if(nums < currentLowest){
                currentLowest = nums;
            }
        }
        return currentLowest;
    }

    /*
    6. Given a list of integers, return the average of all numbers
       This should return the average as an integer, not a floating point

       sum( [3, 1, 59, -4, 81, 23] )    ->  27
       sum( [21, 98, -78, 5, 6, 8] )    ->  53
     */
    public int average(ArrayList<Integer> numbers)
    {
        int averageOfList = 0;
        for(Integer num : numbers){
            averageOfList += num;
        }

       return averageOfList / numbers.size();

    }

    /*
    7.  Build an arrayList that holds the fibonacci sequence

        The fibonacci sequence is a numeric pattern 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
        - each new number is added by calculating the sum of the previous 2 numbers
          0 + 1 = 1
          1 + 1 = 2
          1 + 2 = 3
          2 + 3 = 5
          etc.
        - the sequence must begin with 0, 1 so size will never be lower than 2

        Include as many numbers as is specified by the size input
     */
    public ArrayList<Integer> buildFibonacci(int size)
    {
        ArrayList<Integer> fibonacciList = new ArrayList<>();
        fibonacciList.add(0);
        fibonacciList.add(1);

        if(size == 2){
            return fibonacciList;
        }
        //size - 2 because we already have the first two numbers of the sequence
        for(int i = 1; i <= size - 2; i++){
            fibonacciList.add(fibonacciList.get(i) + fibonacciList.get(i-1));
        }

        return fibonacciList;
    }
}
