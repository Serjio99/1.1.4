package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Driver;

public class Util {
    // соеденение с БД
    public static Connection connection = null;
    public static final String URL = "jdbc:mysql://localhost:3306"; // путь к БД верный?
    public static final String Driver = "com.mysql.cj.jdbc.Driver";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";
    public static SessionFactory sessionFactory;

    public static Connection getConnection() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Class.forName(Driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Подключение успешно!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("JDBS драйвер не нашолся!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL-ошибка");
        }
        return connection;
    }
}
