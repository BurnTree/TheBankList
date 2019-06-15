package com.devincubator.jdeath.DAO;

import com.devincubator.jdeath.entity.Account;
import com.devincubator.jdeath.entity.User;

import java.sql.*;
import java.util.ArrayList;

public class daoJdbc implements daoMethod {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/BankAccount?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "1234321";

    public Connection connection;
    public Statement statement;
    public void driverConnection() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load class.");
            e.printStackTrace();
        }
    }

    public void jdbcConnection() throws SQLException {
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }

    public void getStatement() throws SQLException {
        statement = connection.createStatement();
    }

    public void closeAll() throws SQLException {
        statement.close();
        connection.close();
    }

    public ArrayList<User> getAllUser() throws SQLException {
        String sql = "SELECT * FROM user";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<User> users = new ArrayList<User>();
        while (resultSet.next()){
            User newUser = new User();
            newUser.setId(resultSet.getInt("userid"));
            newUser.setName(resultSet.getString("name"));
            newUser.setSurName(resultSet.getString("surName"));
            users.add(newUser);
        }
        return users;
    }

    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM user WHERE userid = " + id;
        ResultSet resultSet = statement.executeQuery(sql);
        User newUser = new User();
        resultSet.next();
        newUser.setId(resultSet.getInt("userid"));
        newUser.setName(resultSet.getString("name"));
        newUser.setSurName(resultSet.getString("surName"));
        return newUser;
    }

    public ArrayList<Account> getAllAccount() throws SQLException {
        String sql = "SELECT * FROM account";
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Account> accounts = new ArrayList<Account>();
        System.out.println(resultSet);
        while (resultSet.next()){
            Account newAccount = new Account();
            newAccount.setId(resultSet.getInt("accountId"));
            newAccount.setAccount(resultSet.getInt("account"));
            newAccount.setUserid(resultSet.getInt("userid"));
            System.out.println(newAccount);
            accounts.add(newAccount);
        }
        return accounts;
    }

    public Account getAccountById(int id) throws SQLException {
        String sql = "SELECT * FROM account WHERE accountId = " + id;
        ResultSet resultSet = statement.executeQuery(sql);
        Account newAccount = new Account();
        resultSet.next();
        newAccount.setId(resultSet.getInt("accountId"));
        newAccount.setAccount(resultSet.getInt("account"));
        newAccount.setUserid(resultSet.getInt("userid"));
        System.out.println(newAccount);
        return newAccount;
    }
}
