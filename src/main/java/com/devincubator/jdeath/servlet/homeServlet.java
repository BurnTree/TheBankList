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
import java.sql.SQLException;

@WebServlet("/")
public class homeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        daoJdbc dao = new daoJdbc();
        dao.driverConnection();
        try {
            dao.jdbcConnection();
            dao.getStatement();
            User best = dao.getRichUser();

            if (req.getParameter("userBut") != null) {
                req.setAttribute("user", best.getName() + " " + best.getSurName());
                req.setAttribute("sum", req.getParameter("sumText"));
            }
            if (req.getParameter("sumBut") != null) {
                String userText = req.getParameter("userText");
                req.setAttribute("user", userText);
                req.setAttribute("sum", dao.getRich());
            }
            dao.closeAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}




