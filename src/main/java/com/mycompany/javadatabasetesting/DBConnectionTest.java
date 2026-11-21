package com.mycompany.javadatabasetesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.testng.annotations.Test;
import org.testng.Assert;
public class DBConnectionTest {
 private static final String URL ="jdbc:mysql://localhost:3306/mysql";
  private static final String USER = "root";
 // Apna actual MySQL password yahan set karo
 private static final String PASSWORD = "";

    @Test
    public void testDatabaseConnection() throws SQLException {

        try (Connection con =
                 DriverManager.getConnection(URL, USER, PASSWORD)) {

            Assert.assertNotNull(con, "Database connection failed");

            System.out.println("MySQL connected successfully!");
            System.out.println("Connection valid: " + con.isValid(2));
        }
    }
}
