package com.devincubator.jdeath;

import com.devincubator.jdeath.DAO.daoJdbc;
import com.devincubator.jdeath.entity.User;

import java.net.UnknownServiceException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws SQLException {
        daoJdbc dao = new daoJdbc();
        dao.driverConnection();
        dao.jdbcConnection();
        dao.getStatement();

        //dao.getAllAccount();
        dao.getAccountById(4);
        dao.closeAll();
    }
}
