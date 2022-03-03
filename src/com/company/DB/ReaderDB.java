package com.company.DB;

import com.company.Objects.Student;

import java.sql.*;

public class ReaderDB {

    static String url = "jdbc:mysql://localhost:3306/e-learning-platform";
    static String username = "root";
    static String password = "faszar77";

    public static void readStudents(){
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * from students";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("ID, Username, Password" + '\n' + "--------------------");
            while(resultSet.next()){
                String ID = resultSet.getString("ID");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println(ID + " " + username + " " + password);
            }
            con.close();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public static void readTeachers(){
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * from teachers WHERE ID != 0";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("ID, Username, Password" + '\n' + "--------------------");
            while(resultSet.next()){
                String ID = resultSet.getString("ID");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println(ID + ", " + username + ", " + password);
            }
            con.close();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public static void readCourses(){
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * from courses";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("ID, Name, Owner" + '\n' + "--------------------");
            while(resultSet.next()){
                String ID = resultSet.getString("ID");
                String name = resultSet.getString("name");
                String owner = resultSet.getString("owner");
                System.out.println(ID + ", " + name + ", " + owner);
            }
            con.close();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public static void readChapters(){
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * from chapters";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("ID, Name, Description, Course" + '\n' + "--------------------");
            while(resultSet.next()){
                String ID = resultSet.getString("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String course = resultSet.getString("course");
                System.out.println(ID + ", " + name + ", " + description + ", " + course);
            }
            con.close();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public static void readQuestions(){
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * from questions";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("ID, Question, Correct Answer, Quiz" + '\n' + "--------------------");
            while(resultSet.next()){
                String ID = resultSet.getString("id");
                String question = resultSet.getString("question");
                String correct = resultSet.getString("correct");
                String quiz = resultSet.getString("quiz");
                System.out.println(ID + ", " + question + ", " + correct + ", " + quiz);
            }
            con.close();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public static void readAnswers(){
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * from answers";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("ID, Answer, Question" + '\n' + "--------------------");
            while(resultSet.next()){
                String ID = resultSet.getString("id");
                String answer = resultSet.getString("answer");
                String question = resultSet.getString("question");
                System.out.println(ID + ", " + answer + ", " + question);

            }
            con.close();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
