package org.br.expense;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/expenses";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)) {
            System.out.println("Servidor conectado!");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
