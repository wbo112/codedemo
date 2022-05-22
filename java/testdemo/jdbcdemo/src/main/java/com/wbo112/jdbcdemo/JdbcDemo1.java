package com.wbo112.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDemo1 {
    public static void main(String[] args) {
        try {

            String url="jdbc:mysql://192.168.50.20:3306/gulimall_admin?useUnicode=true&characterEncoding=utf-8";
            String username="root";
            String password="root";
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);




} catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }
}
