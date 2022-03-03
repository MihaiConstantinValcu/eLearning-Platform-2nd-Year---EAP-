package com.company.DB;
import com.company.Objects.*;
import com.company.Singletons.Platform;

import java.util.ArrayList;

import java.sql.*;

public class LoaderDB {
    static String url = "jdbc:mysql://localhost:3306/e-learning-platform";
    static String username = "root";
    static String password = "faszar77";

    public static void loadStudents(ArrayList<Student> students){
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "SELECT * from students";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                students.add(new Student(username, password));
            }
            con.close();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void loadTeachers(ArrayList<Teacher> teachers){
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "SELECT * from teachers";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                teachers.add(new Teacher(username, password));
            }
            for (Teacher teacher : teachers) {
                String ID = String.valueOf(teacher.getID());
                String query2 = "SELECT * from courses WHERE owner = " + ID + ";";
                Statement statement2 = con.createStatement();
                ResultSet resultSet2 = statement2.executeQuery(query2);
                while (resultSet2.next()) {
                    String name = resultSet2.getString("name");
                    String ID2 = String.valueOf(resultSet2.getString("id"));
                    Course course = new Course(name, teacher);

                    String query3 = "SELECT * from chapters WHERE course = " + ID2 + ";";
                    Statement statement3 = con.createStatement();
                    ResultSet resultSet3 = statement3.executeQuery(query3);
                    while (resultSet3.next()) {
                        String name3 = resultSet3.getString("name");
                        String description = resultSet3.getString("description");
                        course.addChapter(new Chapter(name3, description));
                    }

                    String query4 = "SELECT * from quizzes WHERE course = " + ID2 + ";";
                    Statement statement4 = con.createStatement();
                    ResultSet resultSet4 = statement4.executeQuery(query4);

                    while (resultSet4.next()) {
                        String ID4 = resultSet4.getString("id");

                        Quiz quiz = new Quiz();

                        String query5 = "SELECT * from questions WHERE quiz = " + ID4 + ";";
                        Statement statement5 = con.createStatement();
                        ResultSet resultSet5 = statement5.executeQuery(query5);
                        while (resultSet5.next()) {
                            String ID5 = resultSet5.getString("id");
                            String question = resultSet5.getString("question");
                            String correct = resultSet5.getString("correct");

                            ExamItem examItem = new ExamItem(question,"",correct);

                            String query6 = "SELECT * from answers WHERE question = " + ID5 + ";";
                            Statement statement6 = con.createStatement();
                            ResultSet resultSet6 = statement6.executeQuery(query6);

                            while (resultSet6.next()) {
                                String Answer = resultSet6.getString("answer");
                                examItem.addAnswer(Answer);
                            }
                            quiz.addQuestion(examItem);
                        }
                        course.addQuiz(quiz);
                    }
                    teacher.addCourse(course);
                }
            }
            con.close();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void generalLoad(){

        IDs.updateCourseID(0);
        IDs.updateStudentID(0);
        IDs.updateTeacherID(-1);
        IDs.updateTestID(0);

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        Platform.setCourses(new ArrayList<>());

        LoaderDB.loadStudents(students);
        LoaderDB.loadTeachers(teachers);

        Platform.setStudents(students);
        Platform.setTeachers(teachers);

        for(Teacher t: Platform.getTeachers())
            for(Course c : t.getCourses())
                Platform.addCourse(c);
    }
}
