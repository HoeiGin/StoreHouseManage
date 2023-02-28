package org.StoreManage;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    private static Connection conn = null;
    public static Connection getConn() {
        // uname: the username of database
        // psw: the password of database
        String uname = "";
        String psw = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/billbook";
            conn = DriverManager.getConnection(url, uname, psw);
        }
        catch (Exception e) {
            System.out.println("Fail to connect the database");
            e.printStackTrace();
        }
        return conn;
    }
}
