package com.kulchuri.feeder.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class FeederDb implements DbData {

    private static Connection conn = null;

    private FeederDb() {
    }

    static {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Connection Failed:" + e);
        }
    }

    public static Connection getFeederDb() {
        return conn;
    }
}
