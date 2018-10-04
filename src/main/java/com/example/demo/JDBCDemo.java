package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC测试类
 *
 * @author yuwb@corp.21cn.com
 * @date 2018/10/4 11:44
 */
public class JDBCDemo {
    public static User getUser(int id) throws SQLException {
        User user = null;
        String sql = "select * from users where ID=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setMobile(rs.getString("mobile"));
                user.setEmail(rs.getString("email"));
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } finally {
                try {
                    if (pstmt != null) {
                        pstmt.close();
                    }
                } finally {
                    if (conn != null) {
                        conn.close();
                    }
                }
            }
        }
        return user;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getUser(1));
    }
}
