package com.budgets.application;

import com.budgets.data.UserDao;

import java.util.Scanner;

public class BudgetManager
{
    Scanner userInput = new Scanner(System.in);
    UserDao userDao = new UserDao();

    public void start(){
        var users = userDao.getUsers();

        users.forEach(System.out::println);
    }
}
