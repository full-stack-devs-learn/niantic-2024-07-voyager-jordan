package com.niantic;

public class ElliotsYardCare
{
    /*
     * Elliot has gas and material costs to operate his business.
     *
     * He calculates his costs by 1000 sq ft. and his costs
     * change if he is also trimming the lawn.
     *
     * Cost per 1000 sq ft.
     * --------------------
     * Without trimming: $2.50
     * With trimming:    $3.00
     *
     * Calculate Elliot's costs based on the yard size
     *
     * calculateCost(100, 50, false) -> 12.50
     * calculateCost(100, 50, true) -> 15.00
     * calculateCost(75, 75, false) -> 16.88
     */
    public double  calculateCost(int width, int length, boolean  isTrimming)
    {
        double totalSqFoot = width * length;
        //Gotta love JavaScript used a ternary condition to figure out rate if true 3 false 2.5
        double currentRate = isTrimming ? 3 : 2.5;
        //Calculate rate per foot based off currentRate / 1000
        double ratePerSqFoot = currentRate / 1000;
        //Used ratePerSqFoot and multiplied totalSqFoot
        double priceTotal = totalSqFoot * ratePerSqFoot;

        return priceTotal;
    }

    /*
     * Elliot needs to calculate what his profit is on each job.
     *
     * He also wants to have this information for already completed jobs.
     * Historically he knows the size of the yard, whether or
     * not he trimmed the yard, and how much he charged
     * his customer.
     *
     * Calculate his profits with the following function:
     *
     * calculateProfit(100, 50, false, 50) -> 37.50
     * calculateProfit(100, 50, true, 50) -> 35
     * calculateProfit(75, 75, true, 50) -> 33.12
     * calculateProfit(150, 100, true, 75) -> 30
     */
    public double  calculateProfit(int width, int length, boolean  isTrimming, int amountCharged)
    {
        double expenses = calculateCost(width, length, isTrimming);
        double netProfit = amountCharged - expenses;

        return netProfit;
    }

    /*
     * In addition to calculating his profits, Elliot realizes that
     * he is spending a lot of time on the job site. He needs to
     * be able to estimate how long a job is going to take.
     *
     * If Elliot is only mowing the lawn it will take him 30 minutes
     * per 1000 sq ft. But if he is also trimming, it will take him
     * 45 minutes.
     *
     * Calculate how many hours it will take him to complete each job.
     *
     * calculateTime(100, 50, false) -> 2.5
     * calculateTime(100, 50, true) -> 3.75
     * calculateTime(75, 75, true) -> 4.22
     * calculateTime(100, 75, true) -> 5.62
     */
    public double calculateTime(int width, int length, boolean  isTrimming)
    {
        double totalSqFt = width * length;
        double timelyRate = isTrimming ? 45 : 30;
        double totalTimeInMinutes = totalSqFt * timelyRate / 1000;
        double totalTimeInHours = totalTimeInMinutes / 60;

        return totalTimeInHours;
    }

    /*
     * Elliot needs to earn at least $10 / hour on each job
     *
     * You need to calculate how much Elliott should charge
     * for a new customer.
     *
     * The customer will provide the dimensions of the yard
     * and specify whether they want Elliot to also trim
     * the yard.
     *
     * Elliott does not bill by the hour, but he charges
     * by the yard. Yards are charged by their size at
     * $25 increments.
     *
     * For instance a job price will be $25, 50, 75 etc
     * based on the size of the yard
     *
     * The minimum price is $25.
     *
     * Calculate what price Elliot should charge for the job.
     *
     * calculatePrice(100, 50, false) -> 50
     * calculatePrice(100, 50, true) -> 75
     * calculatePrice(75, 75, true) -> 75
     * calculatePrice(100, 75, true) -> 100
     */
    public double  calculatePrice(int width, int length, boolean  isTrimming)
    {
        //Base Price 25
        int amountCharged = 25;
        //Wage Goal
        int wageGoalPerHour = 10;
        
        //Calculates current Profit and Time to find Dollars made per hour ** GOAL: 10$/hr **
        double currentProfit = calculateProfit(width, length, isTrimming, amountCharged);
        double currentTimeInHours = calculateTime(width, length, isTrimming);
        double dollarsPerHour = currentProfit / currentTimeInHours;

        //While the dollars per hour is less than goal
        while(dollarsPerHour < wageGoalPerHour){
            amountCharged+=25;
            currentProfit = calculateProfit(width, length, isTrimming, amountCharged);
            //This line is unnecessary but i left it to show initial thought
            // currentTimeInHours = calculateTime(width, length, isTrimming);
            dollarsPerHour = currentProfit / currentTimeInHours;
        }
        return amountCharged;
    }
}