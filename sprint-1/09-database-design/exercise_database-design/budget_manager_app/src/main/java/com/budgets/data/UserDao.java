package com.budgets.data;

import com.budgets.models.User;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;


public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    ArrayList<User> users = new ArrayList<>();

    // <editor-fold desc="Database Connection">
    public UserDao()
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
    // </editor-fold>

    public ArrayList<User> getUsers(){
        // initialize the return Arraylist
//        ArrayList<User> users = new ArrayList<>();

        String query = """
                    SELECT id
                    ,first_name
                    ,last_name
                    FROM users
                    """;
        SqlRowSet row = jdbcTemplate.queryForRowSet(query);

        while(row.next()){
            //          [row].[datatype][column name]
            int userId = row.getInt("id");
            String firstName = row.getString("first_name");
            String lastName = row.getString("last_name");

            User user = new User(userId, firstName, lastName);

            users.add(user);
        }
        return users;
    };
}
