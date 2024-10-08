package com.nianatic;

public class Exercises
{
    /*
     * 1)
     * Return an array of 7 strings with the
     * names of the days of the week
     *
     * [Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]
     */
    public String[] daysOfTheWeek()
    {
        String[] arrOfDays = {
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        };
        return arrOfDays;
    }

    /*
     * 2)
     * Return an array of 12 strings with the
     * names of the months of the year
     *
     * [January, February, March, April, May, June, July, August, September, October, November, December]
     */
    public String[] monthsOfTheYear()
    {
        String[] nameOfMonths = new String[12];

        nameOfMonths[0] = "January";
        nameOfMonths[1] = "February";
        nameOfMonths[2] = "March";
        nameOfMonths[3] = "April";
        nameOfMonths[4] = "May";
        nameOfMonths[5] = "June";
        nameOfMonths[6] = "July";
        nameOfMonths[7] = "August";
        nameOfMonths[8] = "September";
        nameOfMonths[9] = "October";
        nameOfMonths[10] = "November";
        nameOfMonths[11] = "December";

        return nameOfMonths;
    }

    /*
     * 3)
     * Return an array of 50 numbers from 1 to 50
     * (this will be best done with a loop)
     *
     * The first number of the array must be 1
     * The last number of the array must be 50
     *
     * [1, 2, 3, ... 50]
     */
    public int[] oneToFifty()
    {
        int[] arrOfFifty = new int[50];

        for (int i = 0; i < 50; i++){
            arrOfFifty[i] = i+1;
        }

        return arrOfFifty;
    }

    /*
     * 4)
     * Return an array of 100 that includes
     * only the even numbers from 1 to 200
     *
     * The first number of the array must be 2
     * The last number of the array must be 200
     *
     * [2, 4, 6, ... 200]
     */
    public int[] evenNumbers()
    {
        int[] arrOfEvenNums = new int[100];
        int start = 2;

        for (int i = 0; i < 100; i++){
            arrOfEvenNums[i] = start;
            start+=2;
        }
        return arrOfEvenNums;
    }

    /*
     * 5)
     * This function accepts an array of strings
     * that represents all of the days of the week.
     *
     * You need to return the name of the FIRST
     * day of the week.
     *
     * The week might begin with a different day.
     * I.e. the full week begins on Sunday
     *      but the work week begins on Monday
     *
     * Example Expectations:
     * Input                                                                               Output
     * firstDayOfWeek([Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]) => Sunday
     * firstDayOfWeek([Monday, Tuesday, Wednesday, Thursday, Friday])                   => Monday
     */
    public String firstDayOfWeek(String[] daysOfTheWeek)
    {
        return daysOfTheWeek[0];
    }

    /*
     * 6)
     * This function accepts an array of strings
     * that represents all of the days of the week.
     *
     * You need to return the name of the LAST
     * day of the week.
     *
     * The week might begin with a different day.
     * I.e. the full week begins on Sunday
     *      but the work week begins on Monday
     *
     * Example Expectations:
     * Input                                                                              Output
     * lastDayOfWeek([Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday]) => Saturday
     * lastDayOfWeek([Monday, Tuesday, Wednesday, Thursday, Friday])                   => Friday
     */
    public String lastDayOfWeek(String[] daysOfTheWeek)
    {
        return daysOfTheWeek[daysOfTheWeek.length - 1];
    }

    /*
     * 7)
     * This function accepts 2 input parameters.
     * 1 - an array of strings (month names)
     * 2 - the number of the month of the year
     *
     * You need to return the name of the month
     * that corresponds with the number.
     *
     * Example Expectations:
     * Input                                                                          Output
     * monthName([Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec], 2)  => Feb
     * monthName([Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec], 8)  => Aug
     */
    public String monthName(String[] months, int monthNumber)
    {
        return months[monthNumber - 1];
    }

    /*
     * 8)
     * This function accepts 2 input parameters.
     * 1 - an array of names
     * 2 - a name to search for in the array
     *
     * Return true if the name is in the list,
     * and false if it does not.
     *
     * The search should not be case sensitive.
     *
     * Example Expectations:
     * Input                                                      Output
     * hasName(["Ron", "Lisa", "Kent", "Michelle"], "Kent")   =>  true
     * hasName(["Ron", "Lisa", "Kent", "Michelle"], "kent")   =>  true
     * hasName(["Ron", "Lisa", "Kent", "Michelle"], "Jenny")  =>  false
     */
    public boolean hasName(String[] names, String nameToFind)
    {
        boolean nameFound = false;

        for (int i = 0; i < names.length; i++) {
            if(names[i].equalsIgnoreCase(nameToFind)){
                nameFound = true;
                break;
            }
        }

        return nameFound;

    }

    /*
     * 9)
     * This function accepts 2 input parameters.
     * 1 - an array of names
     * 2 - a name to search for in the array
     *
     * Return a count of how many times the name is found in the list.
     *
     * The search should not be case sensitive.
     *
     * Example Expectations:
     * Input                                                                  Output
     * countName(["Ron", "Michelle", "Lisa", "Kent", "Michelle"], "Ron")    =>  1
     * countName(["Ron", "Michelle", "Lisa", "Kent", "Michelle"], "kent")   =>  2
     * countName(["Ron", "Michelle", "Lisa", "Kent", "Michelle"], "Jenny")  =>  0
     */
    public int countName(String[] names, String nameToFind)
    {
        int nameCount = 0;
        for (int i = 0; i < names.length; i++) {
            if(names[i].equalsIgnoreCase(nameToFind)){
                nameCount++;
            }
        }
        return nameCount;
    }

    /*
     * 10)
     * Given an array of integers. Add all
     * numbers in the array and return the value.
     *
     * sumNumbers([1,2,3,4])    =>  10
     * sumNumbers([1,3,5])      =>  9
     * sumNumbers([1,1,2,3])    =>  7
     */
    public int sumNumbers(int[] numbers)
    {
        int sumOfArr = 0;
        for (int i = 0; i < numbers.length; i++) {
           sumOfArr += numbers[i];
        }
        return sumOfArr;
    }

    /*
     * 11)
     * Given an array of integers. Add all EVEN
     * numbers in the array and double it.
     *
     * Return the answer.
     *
     * doubleEvens([1,2,3,4])  => 2 + 4 => 6 * 2   =>  12
     * doubleEvens([10,11,13]) => 10 * 2           =>  20
     */
    public int doubleEvens(int[] numbers)
    {
        int sumOfEvens = 0;
        int multiplier = 2;

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 == 0){
                sumOfEvens += numbers[i];
            }
        }

        return sumOfEvens * multiplier;
    }

    /*
     * 12)
     * Given an array of integers. Add the
     * value of every third number in the
     * array and return the answer.
     *
     * sumEveryThird([1,2,3,4]) => 1 + 4                =>  5
     * sumEveryThird([1,3,5])                           =>  1
     * sumEveryThird([1,1,2,3,5,8,13]) => 1 + 3 + 13    =>  17
     */
    public int sumEveryThird(int[] numbers)
    {
        int sumOfThirds = 0;

        for (int i = 0; i < numbers.length; i+=3) {
                sumOfThirds += numbers[i];
        }

        return sumOfThirds;
    }

    /*
     * 13)
     * Given an array of prices, calculate
     * the average price.
     *
     * averagePrice([12.75, 10.25, 8.44, 9.2]) => sum / 4   =>  12.66
     * averagePrice([15.25, 2.34, 3.5])        => sum / 3   =>  7.03
     */
    public double averagePrice(double[] prices)
    {
        double averageOfArray = 0;

        for (int i = 0; i < prices.length; i++) {
            averageOfArray += prices[i];
        }

        averageOfArray = averageOfArray / prices.length;

        return averageOfArray;
    }

    /*
     * 14)
     * Given an array of prices, return the
     * highest price.
     *
     * highestPrice([12.75, 10.25, 8.44, 9.2])   =>  12.75
     * highestPrice([15.25, 21.34, 3.5])         =>  21.34
     */
    public double highestValue(double[] prices)
    {
        double currentHighest = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if(prices[i] > currentHighest){
                currentHighest = prices[i];
            }
        }

        return currentHighest;
    }

    /*
     * 15)
     * Given an array of prices, return the
     * lowest price that is greater than 0.
     *
     * lowestPrice([-15.25, 15.25, 2.34, 3.50])                        =>  2.34
     * lowestPrice([12.75, -5.5, 10.25, 18.44, 4.23, -15.55, 9.20])    =>  -15.55
     */
    public double lowestValue(double[] prices)
    {
        double currentLowest = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < currentLowest){
                currentLowest = prices[i];
            }
        }

        return currentLowest;
    }

}
