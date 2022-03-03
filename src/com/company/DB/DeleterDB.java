package com.company.DB;

import com.company.Singletons.Platform;

import java.sql.*;
import java.util.Scanner;

public class DeleterDB {

    static String url = "jdbc:mysql://localhost:3306/e-learning-platform";
    static String username = "root";
    static String password = "faszar77";

    public static void delete(){
        try{

            Connection con = DriverManager.getConnection(url,username,password);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Only the administrator can delete from the platform. Please log in.");
            System.out.println("Username: ");
            String username = scanner.nextLine();
            System.out.println("Password: ");
            String password = scanner.nextLine();
            String query = "SELECT * from teachers WHERE ID = 0";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int ok = 0;
            while(resultSet.next()) {
                String verifyUsername = resultSet.getString("username");
                String verifyPassword = resultSet.getString("password");
                System.out.println(verifyUsername + " " + verifyUsername);
                if(username.equals(verifyUsername) && password.equals(verifyPassword))
                    ok = 1;
            }
            if (ok == 1) {
                System.out.println("Access Granted");
                System.out.println("---------------");

            System.out.println("What do you want to delete?");
            System.out.println("----------");
            System.out.println("1. A student");
            System.out.println("2. A teacher");
            System.out.println("3. A course");
            System.out.println("4. A chapter from a course");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Platform.showStudents();
                    System.out.println("What student do you want to delete?");
                    String choiceName = scanner.next() + " " + scanner.next();
                    query = "DELETE FROM students WHERE username = '" + choiceName + "'";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.execute();
                    break;
                case 2:
                    Platform.showTeachers();
                    System.out.println("What teacher do you want to delete?");
                    choiceName = scanner.next() + " " + scanner.next();
                    query = "DELETE FROM teachers WHERE username = '" + choiceName + "'";
                    preparedStatement = con.prepareStatement(query);
                    preparedStatement.execute();
                    break;
                case 3:
                    Platform.showAvailableCourses();
                    System.out.println("What course do you want to delete?");
                    choiceName = scanner.next() + " " + scanner.next();
                    query = "DELETE FROM courses WHERE name = '" + choiceName + "'";
                    preparedStatement = con.prepareStatement(query);
                    preparedStatement.execute();
                    break;
                case 4:
                    Platform.showAvailableCourses();
                    System.out.println("What course chapter do you want to delete?");
                    choiceName = scanner.next() + " " + scanner.next();
                    query = "DELETE FROM chapters WHERE name = '" + choiceName + "'";
                    preparedStatement = con.prepareStatement(query);
                    preparedStatement.execute();
                    break;
                default:
                    System.out.println("Better not delete anything.");
            }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
