package com.devincubator.jdeath.DAO;

import java.sql.SQLException;

public interface daoMethod {
    void driverConnection();
    void jdbcConnection() throws SQLException;
    void getStatement() throws SQLException;
}
