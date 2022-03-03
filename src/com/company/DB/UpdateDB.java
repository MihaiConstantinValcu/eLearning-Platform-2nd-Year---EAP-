package com.company.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDB {
    static String url = "jdbc:mysql://localhost:3306/e-learning-platform";
    static String username = "root";
    static String password = "faszar77";

    public static void updateStudent(int id, String name){
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "UPDATE students SET username = '" + name+"' WHERE ID = '" + id+"';";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.execute();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void updateTeacher(int id, String name){
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "UPDATE teachers SET username = '" + name+"' WHERE ID = '" + id+"';";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.execute();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void updatePassword(int id, String newPassword, String rank){
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "UPDATE "+ rank +" SET password = '" + newPassword +"' WHERE ID = '" + id + "';";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.execute();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public static void updateChapter(int id, String name){
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "UPDATE chapters SET name = '" + name+"' WHERE ID = '" + id+"';";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.execute();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public static void updateCourse(int id, String name){
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "UPDATE courses SET name = '" + name+"' WHERE ID = '" + id+"';";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.execute();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
