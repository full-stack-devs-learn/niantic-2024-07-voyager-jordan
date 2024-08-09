package com.budgets.services;

import com.budgets.models.Transaction;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;

public class TransactionsDao {
    private final JdbcTemplate jdbcTemplate;

    public TransactionsDao()
    {
        String databaseUrl = "jdbc:mysql://localhost:3306/financial";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource()
        {{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<Transaction> getUsersTransactions(int userId)
    {
        ArrayList<Transaction> usersTransactions = new ArrayList<>();

        String query = """
                SELECT *
                FROM transactions
                WHERE owner = ?
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(query, userId);

        while(row.next()){
            int transaction_id = row.getInt("transaction_id");
            int owner_id = row.getInt("owner");
            int budget_id = row.getInt("budget_id");
            int vendor_id = row.getInt("vendor_id");
            int subcategory_id = row.getInt("subcategory_id");
            double amount = row.getDouble("amount");
            Date timestamp = row.getDate("date");
            String note = row.getString("note");

            Transaction transaction = new Transaction(
                    transaction_id
                    , owner_id
                    , budget_id
                    , vendor_id
                    , subcategory_id
                    , amount
                    , timestamp
                    , note
            );
            usersTransactions.add(transaction);
        }
        return usersTransactions;
    };
    public ArrayList<Transaction> getUsersTransactionMonth(int userId, String month)
    {
        ArrayList<Transaction> usersTransactions = new ArrayList<>();


        String query = """
                SELECT *
                FROM transactions
                WHERE owner = ?
                AND MONTH(date) = ?
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(query, userId, month);

        while(row.next()){
            int transaction_id = row.getInt("transaction_id");
            int owner_id = row.getInt("owner");
            int budget_id = row.getInt("budget_id");
            int vendor_id = row.getInt("vendor_id");
            int subcategory_id = row.getInt("subcategory_id");
            double amount = row.getDouble("amount");
            Date timestamp = row.getDate("date");
            String note = row.getString("note");

            Transaction transaction = new Transaction(
                    transaction_id
                    , owner_id
                    , budget_id
                    , vendor_id
                    , subcategory_id
                    , amount
                    , timestamp
                    , note
            );
            usersTransactions.add(transaction);
        }
        return usersTransactions;
    };
    public ArrayList<Transaction> getUsersTransactionCategory(int userId, String nameOfCategory)
    {
        ArrayList<Transaction> usersTransactions = new ArrayList<>();


        String query = """
                        SELECT c.category_name
                        , s.subcategory_name
                        , t.*
                        FROM transactions t
                        JOIN users u ON t.owner = u.user_id
                        JOIN subcategories s ON t.subcategory_id = s.subcategory_id
                        JOIN categories c ON s.parent_id = c.category_id
                        WHERE user_id = ? AND category_name = ?
                        ORDER BY t.date desc
                       """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(query, userId, nameOfCategory);

        while(row.next()){
            int transaction_id = row.getInt("transaction_id");
            int owner_id = row.getInt("owner");
            int budget_id = row.getInt("budget_id");
            int vendor_id = row.getInt("vendor_id");
            int subcategory_id = row.getInt("subcategory_id");
            double amount = row.getDouble("amount");
            Date timestamp = row.getDate("date");
            String note = row.getString("note");
            //Optionals
            String subcategory_name = row.getString("subcategory_name");
            String parentCategory_name = row.getString("category_name");

            Transaction transaction = new Transaction(
                    transaction_id
                    , owner_id
                    , budget_id
                    , vendor_id
                    , subcategory_id
                    , amount
                    , timestamp
                    , note
                    , subcategory_name
                    , parentCategory_name
            );
            usersTransactions.add(transaction);
        }
        return usersTransactions;
    };
    public ArrayList<Transaction> getUsersTransactionSubCategory(int userId, String nameOfCategory)
    {
        ArrayList<Transaction> usersTransactions = new ArrayList<>();


        String query = """
                        SELECT c.category_name
                        , s.subcategory_name
                        , t.*
                        FROM transactions t
                        JOIN users u ON t.owner = u.user_id
                        JOIN subcategories s ON t.subcategory_id = s.subcategory_id
                        JOIN categories c ON s.parent_id = c.category_id
                        WHERE user_id = ? AND subcategory_name = ?
                        ORDER BY t.date desc
                       """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(query, userId, nameOfCategory);

        while(row.next()){
            int transaction_id = row.getInt("transaction_id");
            int owner_id = row.getInt("owner");
            int budget_id = row.getInt("budget_id");
            int vendor_id = row.getInt("vendor_id");
            int subcategory_id = row.getInt("subcategory_id");
            double amount = row.getDouble("amount");
            Date timestamp = row.getDate("date");
            String note = row.getString("note");
            //Optionals
            String subcategory_name = row.getString("subcategory_name");
            String parentCategory_name = row.getString("category_name");

            Transaction transaction = new Transaction(
                    transaction_id
                    , owner_id
                    , budget_id
                    , vendor_id
                    , subcategory_id
                    , amount
                    , timestamp
                    , note
                    , subcategory_name
                    , parentCategory_name
            );
            usersTransactions.add(transaction);
        }
        return usersTransactions;
    };
}
