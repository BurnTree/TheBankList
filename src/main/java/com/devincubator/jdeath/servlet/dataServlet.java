package com.devincubator.jdeath.servlet;


import com.devincubator.jdeath.DAO.daoJdbc;
import com.devincubator.jdeath.entity.Account;
import com.devincubator.jdeath.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/info")
public class dataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        daoJdbc dao = new daoJdbc();
        dao.driverConnection();
        try {
            dao.jdbcConnection();
            dao.getStatement();

            ArrayList<User> users = new ArrayList<User>();
            users = dao.getAllUser();

            ArrayList<Account> accounts = new ArrayList<Account>();
            accounts = dao.getAllAccount();

            writer.println("ALL USER:");
            for (int i = 0;i< users.size();i++){
                writer.println(users.get(i));
            }

            writer.println("ALL ACCOUNT:");
            for (int i = 0;i< accounts.size();i++){
                writer.println(accounts.get(i));
            }
            dao.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
