package com.budgets.application;

import com.budgets.services.TransactionsDao;
import com.budgets.services.monthConverter;
import com.budgets.services.UsersDao;
import com.budgets.models.User;

import java.util.Scanner;

public class BudgetManager
{
    Scanner userInput = new Scanner(System.in);
    UsersDao userDao = new UsersDao();

    public void start(){
        while(true)
        {
            int choice = displayLandingScreen();
            switch(choice)
            {
                case 1:
                    User user = displayLoginScreen();
                    if(user != null){
                        displayWelcomeScreen(user);
                    }
                    break;
                case 2:
                    displayNewUserScreen();
                    break;
                case 0:
                    System.out.println();
                    System.out.println("Have a nice day!");
                    System.out.println();
                    System.exit(0);
            }
        }
    }

    private int displayLandingScreen(){
        System.out.println("--------------------------------------");
        System.out.println("            Budget Manager");
        System.out.println("--------------------------------------");
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("  1) Existing User");
        System.out.println("  2) New User");
        System.out.println("  0) Quit");
        System.out.println();

        return getUserInt("Enter your selection: ");
    }
    private void displayNewUserScreen()
    {
        boolean isSuccessful = false;
        User account;

        while (!isSuccessful) {
            System.out.println("--------------------------------------");
            System.out.println("             Create Account");
            System.out.println("--------------------------------------");

            String email = getUserString("Enter Email: ");
            String password = getUserString("Enter Password: ");
            String firstName = getUserString("Enter First Name: ");
            String lastName = getUserString("Enter Last Name: ");


            try {
                var newUser = new User(){{
                    setEmail(email);
                    setPassword(password);
                    setFirstName(firstName);
                    setLastName(lastName);
                }};

                var insertUser = new UsersDao();
                insertUser.addUser(newUser.getEmail()
                                        , newUser.getPassword()
                                        , newUser.getFirstName()
                                        , newUser.getLastName()
                );

                account = new UsersDao().getUser(email, password);

                if(account != null)
                {
                    System.out.println("Account Created");
                    isSuccessful = true;
                } else {
                    System.out.println("Try Again");
                }

            } catch (Exception e) {
                System.exit(0);
            }
        }
    }
    private User displayLoginScreen()
    {
        int failCount = 0;
        User account = null;

        while (failCount < 3) {
            System.out.println("--------------------------------------");
            System.out.println("             Login Screen");
            System.out.println("--------------------------------------");

            String email = getUserString("Enter Email: ");
            String password = getUserString("Enter Password: ");
            // email = "johndoe@gmail.com"; // For testing
            // password = "123password";    // For testing

            try {
                account = userDao.getUser(email.toLowerCase(), password.toLowerCase());

                if(account != null)
                {
                    System.out.println("Login Successful!");
                    break;
                } else {
                    failCount++;
                    System.out.println("Invalid email or password. Please try again.");
                    if(failCount >= 3){
                        System.out.println("Failed to many times returning home");
                    } else {
                        System.out.println(STR."Attempts remaining: \{3 - failCount}");
                    }
                }

            } catch (Exception e) {
                System.exit(0);
            }
        }
        return account;
    }

    private void displayWelcomeScreen(User account)
    {
        boolean isViewing = true;

        while(isViewing)
        {

            int choice = welcomeSelection(account);
            switch(choice)
            {

                case 1:
//                    displayBudgets();
//                    break;
                case 2:
//                    createBudget();
//                    break;
                case 3:
                    displayTransactions(account);
                    break;
                case 4:
//                    bankSelection();
//                    break;
                case 5:
//                    displayProfileSettings();
//                    break;
                case 0:
                    isViewing = false;
                    break;
                default:
                    isViewing = false;
                    break;
            }
        }
    }
    private int welcomeSelection(User account)
    {
        System.out.println("--------------------------------------");
        System.out.println(STR."          Welcome \{account.getFirstName()} \{account.getLastName()}!");
        System.out.println("--------------------------------------");
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("  1) View Budgets *Unavailable*");
        System.out.println("  2) Create Budget *Unavailable*");
        System.out.println("  3) Transactions");
        System.out.println("  4) Bank Management *Unavailable*");
        System.out.println("  1) Profile Settings *Unavailable*");
        System.out.println("  0) Logout");
        System.out.println();
        return getUserInt("Enter your selection: ");
    }

    private void displayTransactions(User account){
        boolean isViewing = true;

        while(isViewing)
        {
            int choice = transactionSelection();
            switch(choice)
            {

                case 1:
                    displayAllUsersTransactions(account);
                    break;
                case 2:
                    displayTransactionsByMonth(account);
                    break;
                case 3:
                    displayTransactionsByCategories(account);
                    break;
                case 4:
                    displayTransactionsBySubCategories(account);
                    break;
                case 0:
                    isViewing = false;
                    break;
                default:
                    isViewing = false;
                    break;
            }
        }
    };
    private int transactionSelection()
    {
        System.out.println("--------------------------------------");
        System.out.println("            Transactions");
        System.out.println("--------------------------------------");
        System.out.println("Select from the following options:");
        System.out.println();
        System.out.println("  1) All Transactions");
        System.out.println("  2) Sort by Month");
        System.out.println("  3) Sort by Categories");
        System.out.println("  4) Sort by Sub-Categories");
        System.out.println("  0) Return Home");
        System.out.println();
        return getUserInt("Enter your selection: ");
    }
    private void displayAllUsersTransactions(User account)
    {
        TransactionsDao transactionsDao = new TransactionsDao();
        var allTransactions = transactionsDao.getUsersTransactions(account.getUserId());

        System.out.println("--------------------------------------");
        System.out.println("            Transactions");
        System.out.println("--------------------------------------");
        for(var transaction : allTransactions){
            System.out.println(transaction);
        }
        System.out.println("--------------------------------------");
    }
    private void displayTransactionsByMonth(User account)
    {
        String month = getUserString("Enter name of month: ");
        System.out.println();
        String monthDigit = monthConverter.monthToNumber(month.toLowerCase());

        if(monthDigit == null){
            System.out.println("--------------------------------------");
            System.out.println("           Invalid Month");
            System.out.println("--------------------------------------");
            System.out.println("      Returning to Transactions");
            System.out.println("--------------------------------------");
            displayTransactions(account);
        } else {
            TransactionsDao transactionsDao = new TransactionsDao();
            var monthlyTransactions = transactionsDao.getUsersTransactionMonth(account.getUserId(), monthDigit);

            System.out.println("--------------------------------------");
            System.out.println(STR."\{month} Transactions");
            System.out.println("--------------------------------------");
            for(var transaction : monthlyTransactions){
                System.out.println(transaction);
            }
            System.out.println("--------------------------------------");
        }

    }
    private void displayTransactionsByCategories(User account)
    {
        String categoryName = getUserString("Enter name of Category: ");
        TransactionsDao transactionsDao = new TransactionsDao();
        var categoryTransactions = transactionsDao.getUsersTransactionCategory(account.getUserId(), categoryName);

        System.out.println("--------------------------------------");
        System.out.println(STR."\{categoryName} Transactions");
        System.out.println("--------------------------------------");
        for(var transaction : categoryTransactions){
            System.out.println(transaction.toStringCategories());
        }
        System.out.println("--------------------------------------");
    }
    private void displayTransactionsBySubCategories(User account)
    {
        String categoryName = getUserString("Enter name of Category: ");
        TransactionsDao transactionsDao = new TransactionsDao();
        var categoryTransactions = transactionsDao.getUsersTransactionSubCategory(account.getUserId(), categoryName);

        System.out.println("--------------------------------------");
        System.out.println(STR."\{categoryName} Transactions");
        System.out.println("--------------------------------------");
        for(var transaction : categoryTransactions){
            System.out.println(transaction.toStringSubCategories());
        }
        System.out.println("--------------------------------------");
    }



    //<editor-fold desc="Helper Functions">
    private void waitForUser()
    {
        System.out.println("Press ENTER to continue...");
        userInput.nextLine();
    }

    private String getUserString(String message)
    {
        System.out.print(message);
        return userInput.nextLine();
    }

    private int getUserInt(String message)
    {
        return Integer.parseInt(getUserString(message));
    }

    private double getUserDouble(String message)
    {
        return Double.parseDouble(getUserString(message));
    }

    // </editor-fold>
}
