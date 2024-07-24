package com.niantic;

import java.math.BigDecimal;

public class Main
{
    public static void main(String[] args)
    {
        examples();
        section01();
        section02();
        section03();
        clairesCookies();
        elliotsYardCare();
    }

    public static void examples()
    {
        // i. Create a variable that stores the name of the best
        // programming language.
        String weirdLanguage;
        weirdLanguage = "Java";
        String better = "Script";

        System.out.println("i) Best Programming Language");
        System.out.println("language: " + weirdLanguage + better);
        System.out.println();



        // ii. Create a variable to store the speed limit in
        // a school zone.
        int speedLimit;
        speedLimit = 20;

        System.out.println("ii) Speed Limit");
        System.out.println("speedLimit: " + speedLimit);
        System.out.println();
    }

    public static void section01()
    {
        /******************** Section 1 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 1: Declaring Variables");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();



        // 1. Declare a new variable to hold your name.
        // Variable name: name
        // Data Type: string (names/words are strings)
        String name;
        name = "Jordan Napoleon";
        System.out.println("My Name:" + name);




        // 2. Declare a variable to hold your age.
        // Variable name: age
        // Data Type: int (age is a whole number)
        int age;
        age = 27;
        System.out.println("My Age:" + age);


        // 3. Declare a variable that holds the first 5 digits of PI.
        // Variable name: pi
        // Data Type: double (pi is a number with decimal places)
        double pi = 3.1415;
        System.out.println(pi);


        // 4. Declare a variable holds the price of
        // an adult meal at the buffet.
        // Variable name: price
        // Data Type: double (price contains a dollar and cent value)
        double price = 10.50;
        System.out.println("Adult Meal total is: $" + price);

        // NOTE: the decimal data type  is not automatically recognized
        // see lecture notes
    }

    public static void section02()
    {

        /******************** Section 2 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 2: Selecting DataTypes");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();

        // From this point forward you will need to choose
        // the variable name for each of your variables
        // as well as the DataType that will be used for
        // each variable.



        // 5. Declare a variable to store the name of your
        // favorite super hero.
        String favoriteSuperHero = "Black Panther";
        System.out.println("My Favorite Hero is:" + favoriteSuperHero);

        // Hint: You cannot use the same variable name
        // as a variable that you have used before.



        // 6. Declare a variable to hold the value of
        // value of a test score. The test has 100
        // questions and each question is worth 1 point.
        // (You can choose the score)
        int totalQuestions = 100;
        int wrongQuestions = 5;
        int rightQuestions = totalQuestions - wrongQuestions;

        System.out.println("Your score is: " + rightQuestions + "%");




        // 7. Declare a variable that holds the current
        // population in the United States.
        // (search what the population is today)
        int currUnitedStatesPop = 336673595;
        System.out.println("Population of the United States: " + currUnitedStatesPop);


        // 8. Declare a variable that holds the current
        // population in China.
        // (search what the population is today)
        long currChinaPop = 1416043270;
        System.out.println("Population of the China:         " + currChinaPop);


        // 9. Declare a variable that holds the current
        // population in the world.
        // (search what the population is today)
        long currWorldPop = 8061927302L;
        System.out.println("Population of the world:         " + currWorldPop);



        // 10. Declare a variable that specifies whether
        // or not your mouse is wireless.
        boolean isWirelessMouse = true;
        System.out.println("My mouse is wireless: " + isWirelessMouse);



        // 11. Search what the Latitude and Longitude of your
        // home town are. Then declare 2 variables
        // to store the Latitude and Longitude.

        double homeTownLat = 19.8987;
        double homeTownLong = 155.6659;

        System.out.println("My Location of my home town is: " + homeTownLat + "°N, " + homeTownLong + "°W");





        // 12. Create a variable that holds the current
        // Microsoft stock price.

        double currMSFTprice = 444.85;
        System.out.println("Microsoft Stock is worth: " + currMSFTprice);
    }
    
    public static void section03()
    {
        /******************** Section 3 ********************/
        System.out.println();
        System.out.println("**********************************************");
        System.out.println("Section 3: Expressions and Arithmetic");
        System.out.println("**********************************************");
        System.out.println();
        System.out.println();

        /*
         * In this section you are expected to create
         * multiple variables in each exercise. You should
         * create as many variables as you need in order to
         * solve each problem.
         *
         * Make sure that your variable names are meaningful
         * and that the name describes the purpose of the
         * variable. Also, your code should not have any
         * "magic numbers" but anyone who reads the code
         * should be able to understand your code and
         * the calculations.
         */

        System.out.println("----------------------------");
        System.out.println("Backyard Basketball");
        System.out.println("-----------------------------");
        System.out.println();


        // 13. In his last basketball game Pete made 7 shots,
        // but missed 3 of his shots.
        int basketsMade = 7;
        int basketsMissed = 3;

        // How many shots did Pete take?
        int totalBasketsTook = basketsMade + basketsMissed;
        System.out.println("Pete made: " + totalBasketsTook + " shots.");


        // 14. In his previous basketball game Pete took 20 shots.
        // He missed 6 shots, and he made 3 three point shots.
        totalBasketsTook = 20;
        basketsMissed = 6;
        int threePointsScored = 3;
        int totalThreePointsScored = threePointsScored * 3;
        // How many 2 point shots did Pete make?\
        basketsMade = totalBasketsTook - basketsMissed - threePointsScored;

        System.out.println("Pete made " + basketsMade + ", 2 point shots.");



        // 15. Pete and Pat are teammates. Pete made 6 shots.
        // Pat made twice as many shots as Pete.
        int peteShotCount = 6;
        int patShotCount = peteShotCount * 2;
        int teamsTotalShots =  peteShotCount + patShotCount;

        // How many total shots did they make?
        System.out.println("Pete and Pat took a total of " + teamsTotalShots);



        // 16. Pete has made 13 shots, Pat has made 9.
        // If both Pete and Pat make 1 more shot each
        // before the game ends, how many total shots
        // did the Terrifying Twosome make in the game?
        peteShotCount = 13;
        patShotCount = 9;
        peteShotCount++;
        patShotCount++;

        teamsTotalShots = peteShotCount + patShotCount;

        System.out.println("The Twosome made a total of: " + teamsTotalShots);





        // 17. In his last game Pete made 11 shots.
        // he missed 4 shots.
        int basketsMadeByPete = 11;
        int basketsMissedByPete = 4;
        int peteTotalBaskets = basketsMadeByPete + basketsMissedByPete;

        // What percentage of his shots did he make?
        double peteShotPercent = ((double)basketsMadeByPete / peteTotalBaskets) * 100;

        System.out.println("Petes Shot Percentage is: " + (int)peteShotPercent + "%");




        // 18. Pete and Pat have decided to only take 3 point
        // shots in their next game. Together they make 70%
        // of their 3 point shots.
        int rivalTeamsPoints = 31;
        double currPercent = (double) 70 / 100;
        int threePointShotsNeeded = rivalTeamsPoints / 3 + 1;
        double totalShotsTook = Math.ceil(threePointShotsNeeded / currPercent);





        // The team that they are playing scores 31 points a game.

        // How many shots do Pete and Pat have to take to win
        // this game?
        System.out.println("Pete and Pat need to take: " + totalShotsTook);
    }
    
    public static void clairesCookies()
    {

        System.out.println();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Claire's Cookies");
        System.out.println("-----------------------------");
        System.out.println();



        // 19. Claire sells cookies by the dozen. Sean has 14 students
        // in his class. He has bought 3 dozen cookies for his class.

        // Sean wants to divide the cookies evenly between
        // his students. How many cookies will each student
        // receive? (Students can only receive whole cookies)
        int claireCookieSales = 3;
        int totalStudents = 14;
        int totalDonuts = claireCookieSales * 12;
        int qtyPerStudent =  totalDonuts / totalStudents;
        System.out.println("Each student will get : " + qtyPerStudent + " donuts each.");



        // 20. Sean has 14 students in his class.
        // He has bought 3 dozen cookies for his class.

        // Sean wants to divide the cookies evenly between
        // his students. After giving the students their
        // cookies, how many cookies will be left over?
        int remainderCookies = totalDonuts % totalStudents;
        System.out.println(remainderCookies + " cookies leftover");



        // 21. Sean's class has earned a cookie party.

        // If Sean has 14 students, how many dozen cookies
        // does he need to buy from Claire's Cookies so that
        // each student can receive 3 cookies.
        qtyPerStudent = 3;
        int donutsNeeded = totalStudents * qtyPerStudent;
        double dozensNeeded = Math.ceil((double)donutsNeeded / 12);
        claireCookieSales = (int)dozensNeeded;


        System.out.println("Claire needs to sell " + claireCookieSales + " dozen cookies");



        // 22. Sean's class has earned a cookie party. The number
        // of cookies that a student receives depends on
        // the score that they received on the cookie test.
        // Sean has 14 students.

        // 100 = 4 cookies
        // 90+ = 3 cookies
        // everyone else 2 cookies

        // Sean has 14 students. Chuck and Andrea scored
        // a perfect 100 on the test. Regina, Glen, Tony and Lorrie
        // all scored above 90. The rest of the class scored
        // below 90.

        // How many dozen cookies does Sean need to buy.
        int scored100 = 2;
        int scored90 = 4;
        int scoredBelow = totalStudents - scored100 - scored90;

        donutsNeeded = (scored100 * 4) + (scored90 * 3) + (scoredBelow * 2);
        System.out.println("Sean needs to buy: " + donutsNeeded + " donuts");





        // 23. If Claire's Cookies sells each dozen cookies for 12.99,
        // how much will it cost Sean to buy 4 dozen cookies.
        double pricePerDozenDonuts = 12.99;
        dozensNeeded = 4;
        double totalPrice = dozensNeeded * pricePerDozenDonuts;
        System.out.println("Your total price is: $" + totalPrice);





        // (Use this information for the next several questions)
        // Claire now charges different prices for different
        // types of cookies as follows:

        // Snicker Doodles = $12.99 / dz
        // Chocolate Chip = $13.99 / dz
        // Frosted Chocolate Chip = $15.99 / dz

        // Each dozen cookies must be the same type of cookie.

        // Sean has allowed his students to choose 3
        // cookies each. Here is what they have selected

        // Snicker Doodles | Chocolate Chip | Frosted Chocolate Chip
        // ---------------------------------------------------------
        // 9                 15               18

        // 24. How many total dozen cookies does Sean need to buy?
        double pricePerDozenDoodles = 12.99;
        double pricePerDozenChoc = 13.99;
        double pricePerDozenFrosted = 15.99;

        int totalSnickerDoodles = 9;
        int totalChocolateChip = 15;
        int totalFrostedChip = 18;

        double totalSnickerDoodleDz = Math.ceil((double)totalSnickerDoodles / 12);
        double totalChocChipDz = Math.ceil((double)totalChocolateChip / 12);
        double totalFrostChipDz = Math.ceil((double)totalFrostedChip / 12);


        // 25. What is the total cost of this order?
        totalPrice = (totalSnickerDoodleDz * pricePerDozenDoodles) + (totalChocChipDz * pricePerDozenChoc) + (totalFrostChipDz * pricePerDozenFrosted);
        System.out.println("Sean's total is: $" + totalPrice);


        // 26. How many cookies will be left over of each type of cookie?
        // (Snicker Doodles, Chocolate Chip, Frosted Chocolate Chip)

        int modSnickerDoodle = ((int)totalSnickerDoodleDz * 12) % totalSnickerDoodles;
        int modChocChip = ((int)totalChocChipDz * 12) % totalChocolateChip;
        int modFrostChip = ((int)totalFrostChipDz * 12) % totalFrostedChip;

        System.out.println("Leftover Snicker Doodle: " + modSnickerDoodle);
        System.out.println("Leftover Chocolate Chip: " + modChocChip);
        System.out.println("Leftover Frosted Chip: " + modFrostChip);


        // 27. How much money could Sean have saved if he would
        // have bought: 2 dz Frosted Chocolate Chip
        //              1 dz Chocolate Chip
        //              1 dz Snicker Doodle

        totalSnickerDoodleDz = 1;
        totalChocChipDz = 1;
        totalFrostChipDz = 2;

        double currentPrice = totalPrice;
        double newPrice = (pricePerDozenFrosted * totalFrostChipDz) + (pricePerDozenChoc * totalChocChipDz) + (pricePerDozenDoodles * totalSnickerDoodleDz);
        double priceDifference = currentPrice - newPrice;
        System.out.println("Sean would have saved: $" + (float)priceDifference);

    }


    // bonus - challenge
    public static void elliotsYardCare()
    {

        System.out.println();
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Elliot's Yard Care");
        System.out.println("----------------------------");
        System.out.println();

        // Use the following information to answer the remaining questions.

        // Elliot runs a yard care business named "Elliot's Yard Care".
        // He charges $30 to mow and trim a medium size lawn (100 ft x 50 ft).
        // Elliot takes pride in his work and his lawns look
        // immaculate. In order to maintain such a quality reputation
        // his services include grass clipping removal and
        // complete sweeping of the property after the lawn
        // is mowed.

        // Elliot's goal is to earn at least $10 per hour.
        // It costs him about $2.50 in materials and gas per 1000 sq ft.
        // On average elliot has calculated that it takes him roughly
        // 45 minutes to fully maintain 1000 sq ft.


        int lawnLength = 100;
        int lawnWidth = 50;
        int totalSqFoot = lawnLength * lawnWidth;

        double yardRate = (double)30 / 5000;
        double yardPrice = yardRate * totalSqFoot;

        double expenseRate = (double)2.50 / 1000;
        double expensesPrice = expenseRate * totalSqFoot;

        double timelyRate = (double)45 / 1000;
        double totalTimeInMinutes = timelyRate * totalSqFoot ;
        double totalTimeInHours = totalTimeInMinutes / 60;

        double costPerHour = expensesPrice / totalTimeInHours;
        int newNet = 10;


        double netPrice = yardPrice - expensesPrice;









        // 28. What is the total cost to Elliot when
        // he mows a yard that is 100 x 50 feet?
        System.out.println("Total Cost for 100 x 50 is: $" + expensesPrice);



        // 29. How much total money does Elliot earn
        // to maintain a 100 x 50 ft yard?
        System.out.println("Elliot nets: $" + netPrice);



        // 30. How much time does it take Elliot to mow
        // a 100 x 50 ft yard?
        System.out.println("Elliot takes: " + totalTimeInMinutes + " minutes");


        // 31. How much money does Elliot earn per hour
        // on a 100 x 50 foot yard?
        System.out.println("Elliot makes: $" + (netPrice / totalTimeInHours) + " per hour");



        // 32. What is Elliot's cost per hour on a medium
        // sized yard?
        System.out.println("Elliot's expenses per hour is: $" + costPerHour );



        // 33. How much money should Elliot charge for a medium yard
        // in order to earn $10 per hour?
        System.out.println("Elliot needs to charge: $" + (newNet + costPerHour) * totalTimeInHours);


    }
}