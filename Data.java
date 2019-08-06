package KS;

import java.sql.*;

public class Data {
    private static String username = "root";
    private static String password = "lmh12358";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/javaks?useSSL=false&serverTimezone=UTC";

    public static Connection getConn () {
        try {
            Connection conn = null;
            //注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库......");
            //连接数据库0
            conn = DriverManager.getConnection(DB_URL, username, password);
            return conn;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet Select (Statement stmt, String sql) {
        //查询
        try {
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
