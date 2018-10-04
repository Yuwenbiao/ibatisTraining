package com.example.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 数据库访问工具
 *
 * @author yuwb@corp.21cn.com
 * @date 2018/10/4 11:38
 */
public class DBUtil {
    private static Connection conn = null;
    private static Statement stmt;
    private static PreparedStatement pstmt = null;
    private static String url, driver, userName, password;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        url = bundle.getString("jdbc.url");
        driver = bundle.getString("jdbc.driverClassName");
        userName = bundle.getString("jdbc.username");
//        password = bundle.getString("jdbc.password");
    }

    public DBUtil() {
    }

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
