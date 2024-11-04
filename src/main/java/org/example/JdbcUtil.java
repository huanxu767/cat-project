package org.example;



import java.sql.*;


public class JdbcUtil {


    public static final String MYSQL_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://172.20.0.87:3306/test?characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";
    public static final String USERNAME = "brms_admin";
    public static final String PASSWORD = "brms_admin123";


    public static Connection getConnection() {

        try {
            Class.forName(MYSQL_DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public static void close(Statement statement, Connection connection) {
        close(null,statement,connection);
    }
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
