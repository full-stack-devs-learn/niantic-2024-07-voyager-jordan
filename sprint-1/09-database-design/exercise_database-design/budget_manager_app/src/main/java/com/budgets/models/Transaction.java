package com.budgets.models;

import java.sql.Date;

public class Transaction {

    private int transaction_id;
    private int owner_id;
    private int budget_id;
    private int vendor_id;
    private int subcategory_id;
    private String subcategory_name;
    private String parentCategory_name;
    private double amount;
    private Date timestamp;
    private String note;


    public Transaction(){};
    public Transaction(int transaction_id, int owner_id, int budget_id, int vendor_id, int subcategory_id, double amount, Date timestamp, String note)
    {
        this.transaction_id = transaction_id;
        this.owner_id = owner_id;
        this.budget_id = budget_id;
        this.vendor_id = vendor_id;
        this.subcategory_id = subcategory_id;
        this.amount = amount;
        this.timestamp = timestamp;
        this.note = note;
    }
    public Transaction(int transaction_id, int owner_id, int budget_id, int vendor_id, int subcategory_id, double amount, Date timestamp, String note, String subcategory_name, String parentCategory_name)
    {
        this.transaction_id = transaction_id;
        this.owner_id = owner_id;
        this.budget_id = budget_id;
        this.vendor_id = vendor_id;
        this.subcategory_id = subcategory_id;
        this.amount = amount;
        this.timestamp = timestamp;
        this.note = note;
        this.subcategory_name = subcategory_name;
        this.parentCategory_name = parentCategory_name;
    }
    @Override
    public String toString()
    {
        return String.format("%-12s|  $%-10.2f|  %5s", timestamp, amount, note);
    }
    public String toStringCategories()
    {
        return String.format("%-10s| %-15s| %-12s|  $%-10.2f|  %5s", parentCategory_name, subcategory_name, timestamp, amount, note);
    }
}
