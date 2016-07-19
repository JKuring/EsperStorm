package com.eastcom.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by linghang.kong on 2016/6/30.
 */
public class ImpalaConnector {
    private static final String CONNECTION_URL = "jdbc:hive2://10.11.58.22:21050/xdr_data;auth=noSasl";

    private static final String JDBC_DRIVER_NAME = org.apache.hive.jdbc.HiveDriver.class.getName();

    private Connection con;

    public ImpalaConnector() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER_NAME);
        this.con = DriverManager.getConnection(CONNECTION_URL);
    }

    public Statement getStatement() {
        try {
            Statement stmt = con.createStatement();
            return stmt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close(Statement statement) throws SQLException {
        statement.close();
    }
}
