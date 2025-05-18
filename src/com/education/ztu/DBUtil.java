package com.education.ztu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {

    public static Connection getConnection() throws SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("db");
        String url = rb.getString("db.url");
        String user = rb.getString("db.user");
        String pass = rb.getString("db.password");

        return DriverManager.getConnection(url, user, pass);
    }
}
