package com.mycompany.javadatabasetesting;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StudentDBTest {

 private static final String URL ="jdbc:mysql://localhost:3306/mysql";
  private static final String USER = "root";
 // Apna actual MySQL password yahan set karo
 private static final String PASSWORD = "";

    @Test
    public void validateStudentData() throws SQLException {

        String sql =
            "SELECT name, email, course FROM students WHERE id = ?";

        try (Connection con =
                 DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, 1);

            try (ResultSet rs = ps.executeQuery()) {

                Assert.assertTrue(
                    rs.next(), "Student record was not found"
                );

                String name = rs.getString("name");
                String email = rs.getString("email");
                String course = rs.getString("course");

                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("Course: " + course);

                Assert.assertEquals(name, "Vinod");
                Assert.assertEquals(email, "vinod@example.com");
                Assert.assertEquals(course, "Java Selenium");

                Assert.assertFalse(
                    rs.next(), "Unexpected duplicate result"
                );
            }
        }
    }
}
