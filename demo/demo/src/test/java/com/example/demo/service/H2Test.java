package com.example.demo.service;

import java.sql.*;

public class H2Test {
    public static void main(String[] args) throws SQLException {
        // JDBC URL, username, and password for the H2 database
//        String url = "jdbc:h2:tcp://localhost/~/test";
        String url = "jdbc:h2:file:/data/demo";
        String username = "sa";
        String password = "password";

        // Establish a connection to the H2 database
        Connection conn = DriverManager.getConnection(url, username, password);

        // Create a statement
        Statement stmt = conn.createStatement();

        // Execute a simple query
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM person");

        // Print the result
        while (rs.next()) {
            System.out.println("Number of persons: " + rs.getInt(1));
        }

        // Close the connection
        conn.close();
    }
}
