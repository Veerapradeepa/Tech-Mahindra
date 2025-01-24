package com.project1.LoginPage;

import java.sql.*;

import java.util.Scanner;

public class Logging {


     // Database connection details

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

    private static final String USER = "PRADEEPA";

    private static final String PASSWORD = "1234";



    public static void main(String[] args) {

        try {

            // Load Oracle JDBC Driver

            Class.forName("oracle.jdbc.driver.OracleDriver");



            // Establish connection

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            Scanner scanner = new Scanner(System.in);



            while (true) {

                System.out.print("\nEnter username: ");

                String username = scanner.nextLine();



                // Check if the user exists in the database

                Statement st = con.createStatement();

                String checkUserSQL = "SELECT * FROM PRADEEPA.Login_Credentials WHERE USER_NAME = '" + username + "'";

                ResultSet rs = st.executeQuery(checkUserSQL);



                if (rs.next()) {

                    // User exists, proceed to login

                    System.out.print("Enter password: ");

                    String password = scanner.nextLine();



                    String checkPasswordSQL = "SELECT * FROM PRADEEPA.Login_Credentials WHERE USER_NAME= '" + username + "' AND Password = '" + password + "'";

                    ResultSet passwordCheck = st.executeQuery(checkPasswordSQL);



                    if (passwordCheck.next()) {

                        System.out.println("Login successful! Welcome, " + username + ".");

                        break;

                    } else {

                        System.out.println("Incorrect password. Please try again.");

                    }

                } else {

                    // User does not exist, prompt to sign up

                    System.out.println("User not found. Please sign up.");

                    System.out.print("Enter a password: ");

                    String newPassword = scanner.nextLine();



                    String insertUserSQL = "INSERT INTO PRADEEPA.Login_Credentials (USER_NAME, Password) VALUES ('" + username + "', '" + newPassword + "')";

                    try {

                        st.executeUpdate(insertUserSQL);

                        System.out.println("User registered successfully! Please log in.");

                    } catch (SQLException e) {

                        System.out.println("Error registering user: " + e.getMessage());

                    }

                }

            }



            // Close the connection

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
