package com.company.Singletons;

import com.company.DB.DeleterDB;
import com.company.DB.LoaderDB;
import com.company.DB.ReaderDB;
import com.company.DB.UpdateDB;
import com.company.Objects.Course;
import com.company.Objects.Student;
import com.company.Objects.Teacher;

import java.lang.management.PlatformManagedObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;

public class Application {

    private static Application application;

    private Application() {
    }

    public static Application getMenu(){
        if(application == null)
            application = new Application();
        return application;
    }

    public static void startApp(){
        Platform platform = Platform.getPlatforma();
        LoaderDB.generalLoad();

        Application application = Application.getMenu();
        Application.login();
    }

    private static void login() {
        try {
            while (true) {
                Scanner scanner = new Scanner((System.in));

                System.out.println("Who are you?");
                System.out.println("1. A student");
                System.out.println("2. A teacher");
                System.out.println("3. Administrator");

                int choice = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Please enter your credentials");
                System.out.println("Username:");
                String username = scanner.nextLine();
                System.out.println("Password:");
                String password = scanner.nextLine();

                String url = "jdbc:mysql://localhost:3306/e-learning-platform";
                Connection con = DriverManager.getConnection(url, "root", "faszar77");

                int match = 0;
                switch (choice) {
                    case 1:
                        String query = "SELECT * from students WHERE username = '" + username + "' and password = '" + password + "';";
                        Statement statement = con.createStatement();
                        ResultSet resultSet = statement.executeQuery(query);
                        while (resultSet.next()) {
                            Platform.setID(Integer.parseInt(resultSet.getString("id")));
                            Platform.setPassword(resultSet.getString("password"));
                            Platform.setUsername(resultSet.getString("username"));
                            match = 1;
                        }
                        if (match == 1)
                            studentMenu();
                        else System.out.println("There is no student with these credentials.");
                        break;
                    case 2:
                        query = "SELECT * from teachers WHERE username = '" + username + "' and password = '" + password + "';";
                        statement = con.createStatement();
                        resultSet = statement.executeQuery(query);
                        while (resultSet.next()) {
                            Platform.setID(Integer.parseInt(resultSet.getString("id")));
                            Platform.setPassword(resultSet.getString("password"));
                            Platform.setUsername(resultSet.getString("username"));
                            match = 1;
                        }
                        if (match == 1)
                            teacherMenu();
                        else System.out.println("There is no teacher with these credentials.");
                        break;
                    case 3:
                        query = "SELECT * from teachers WHERE ID = 0 ";
                        statement = con.createStatement();
                        resultSet = statement.executeQuery(query);
                        while (resultSet.next()) {
                            Platform.setID(Integer.parseInt(resultSet.getString("id")));
                            Platform.setPassword(resultSet.getString("password"));
                            Platform.setUsername(resultSet.getString("username"));
                            String verifyUsername = resultSet.getString("username");
                            String verifyPassword = resultSet.getString("password");
                            if (username.equals(verifyUsername) && password.equals(verifyPassword))
                                match = 1;
                        }
                        if (match == 1)
                            adminMenu();
                        else System.out.println("Wrong credentials");
                        break;
                }
            }
            }catch(SQLException exception){
                exception.printStackTrace();
            }
        }

    private static void studentMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("--------------------");
            System.out.println("Choose an action:");
            System.out.println("1. Change username");
            System.out.println("2. Change password");
            System.out.println("3. See your history");
            System.out.println("4. See all available courses");
            System.out.println("5. See the contents of a course");
            System.out.println("6. See the full content of a course");
            System.out.println("7. Log out");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("Enter your new username:");
                    String newUsername = scanner.nextLine();
                    UpdateDB.updateStudent(Platform.getID(), newUsername);
                    Platform.setUsername(newUsername);
                    System.out.println("Username updated successfully!");
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Enter your new password:");
                    String newPassword = scanner.nextLine();
                    UpdateDB.updatePassword(Platform.getID(), newPassword, "students");
                    Platform.setPassword(newPassword);
                    System.out.println("Password updated successfully!");
                    break;
                case 3:
                    System.out.println();
                    for (Student s :Platform.getStudents())
                        if(s.getUsername().equals(Platform.getUsername()))
                            s.showHistory();
                        break;
                case 4:
                    Platform.showAvailableCourses();
                    break;
                case 5:
                    System.out.println("Enter the ID of the course whose content you want to see:");
                    int courseID = scanner.nextInt();
                    for (Course c : Platform.getCourses())
                        if (c.getID() == courseID)
                            c.showChapters();
                    break;
                case 6:
                    System.out.println("Enter the ID of the course whose content you want to see:");
                    courseID = scanner.nextInt();
                    for (Course c : Platform.getCourses())
                        if (c.getID() == courseID)
                            c.showContent();
                    break;
                case 7:
                    loop = false;
                    break;

            }
        }
    }
    private static void teacherMenu() {
        boolean loop = true;
        while (loop) {
            System.out.println("--------------------");
            System.out.println("Choose an action:");
            System.out.println("1. Change username");
            System.out.println("2. Change password");
            System.out.println("3. See all your courses");
            System.out.println("4. See all students");
            System.out.println("5. Grade a student");
            System.out.println("6. Log out");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.println("Enter your new username:");
                    String newUsername = scanner.nextLine();
                    UpdateDB.updateStudent(Platform.getID(), newUsername);
                    Platform.setUsername(newUsername);
                    System.out.println("Username updated successfully!");
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Enter your new password:");
                    String newPassword = scanner.nextLine();
                    UpdateDB.updatePassword(Platform.getID(), newPassword, "teachers");
                    Platform.setPassword(newPassword);
                    System.out.println("Password updated successfully!");
                    break;
                case 3:
                    for (Teacher t : Platform.getTeachers()) {
                        if (t.getUsername().equals(Platform.getUsername()))
                            t.showCourses();
                    }
                    break;
                case 4:
                    Platform.showStudents();
                    break;
                case 5:
                    System.out.println("Enter the ID of the student, the name of the course and the grade");
                    System.out.println("Student's ID:");
                    String studentID = scanner.nextLine();
                    System.out.println("Name of the course:");
                    String courseName = scanner.nextLine();
                    System.out.println("Grade:");
                    String grade = scanner.nextLine();
                    for(Teacher t : Platform.getTeachers())
                        if(t.getUsername().equals(Platform.getUsername()))
                            t.gradeStudent(studentID,courseName,Integer.parseInt(grade));
                    break;
                case 6:
                    loop = false;
                    break;
            }
        }
    }
    private static void adminMenu(){
        {
            boolean loop = true;
            while(loop) {
                System.out.println("--------------------");
                System.out.println("Choose an action:");
                System.out.println("1. Reload database");
                System.out.println("2. Read from database");
                System.out.println("3. Update rows in database");
                System.out.println("4. Delete from database");
                System.out.println("5. View non-database actions");
                System.out.println("6. Log out");

                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        LoaderDB.generalLoad();

                        break;
                    case 2:
                        System.out.println("What do you want to see?");
                        System.out.println("1. Students");
                        System.out.println("2. Teachers");
                        System.out.println("3. Courses");
                        System.out.println("4. Chapters");
                        System.out.println("5. Questions");
                        System.out.println("6. Answers");
                        int innerChoice = scanner.nextInt();
                        switch(innerChoice){
                            case 1:
                                ReaderDB.readStudents();
                                break;
                            case 2:
                                ReaderDB.readTeachers();
                                break;
                            case 3:
                                ReaderDB.readCourses();
                                break;
                            case 4:
                                ReaderDB.readChapters();
                                break;
                            case 5:
                                ReaderDB.readQuestions();
                                break;
                            case 6:
                                ReaderDB.readAnswers();
                                break;
                            default:
                                System.out.println("Wrong Choice");
                        }
                        break;
                    case 3:
                        System.out.println("What do you want to update??");
                        System.out.println("1. Students");
                        System.out.println("2. Teachers");
                        System.out.println("3. Courses");
                        System.out.println("4. Chapters");
                        innerChoice = scanner.nextInt();
                        System.out.println("Please enter the ID and the new name:");
                        int ID = scanner.nextInt();
                        scanner.next();
                        String name = scanner.nextLine();
                        switch (innerChoice){
                            case 1:
                                UpdateDB.updateStudent(ID,name);
                                break;
                            case 2:
                                UpdateDB.updateTeacher(ID,name);
                                break;
                            case 3:
                                UpdateDB.updateCourse(ID,name);
                                break;
                            case 4:
                                UpdateDB.updateChapter(ID,name);
                                break;
                        }
                        break;
                    case 4:
                        DeleterDB.delete();
                        break;
                    case 5:
                        boolean quit = true;
                        while (quit == true){
                            System.out.println("Choose an action:");
                            System.out.println("1. View all students");
                            System.out.println("2. View all teachers");
                            System.out.println("3. View all available courses");
                            System.out.println("4. Back");
                            choice = scanner.nextInt();
                            switch(choice) {
                                case 1:
                                    Platform.showStudents();
                                    break;
                                case 2:
                                    Platform.showTeachers();
                                    break;
                                case 3:
                                    Platform.showAvailableCourses();
                                    break;
                                case 4:
                                    quit = false;
                                    break;
                            }
                        }
                        break;
                    case 6:
                        loop = false;
                        break;
                }
            }
        }
    }
}
