package com.company.Singletons;

import com.company.Objects.Course;
import com.company.Objects.Student;
import com.company.Objects.Teacher;

import java.util.ArrayList;

public class Platform {
    private static ArrayList<Course> courses = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    private static Platform platform;
    private static int ID;
    private static String username;
    private static String password;


    private Platform() {
    }

    public static Platform getPlatforma() {
        if (platform == null)
            platform = new Platform();
        return platform;
    }

    public static void addCourse(Course course) {
        Platform.courses.add(course);
    }

    public static void setCourses(ArrayList<Course> _courses) { Platform.courses = _courses; }

    public static ArrayList<Course> getCourses() { return courses; }

    public static void addStudent(Student student) {
        Platform.students.add(student);
    }

    public static void setStudents(ArrayList<Student> _students) { Platform.students = _students; }

    public static ArrayList<Student> getStudents() { return students; }

    public static void addTeachers(Teacher teacher) {
        Platform.teachers.add(teacher);
    }

    public static void setTeachers(ArrayList<Teacher> _teachers) { Platform.teachers = _teachers; }

    public static ArrayList<Teacher> getTeachers() { return teachers; }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Platform.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Platform.password = password;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Platform.ID = ID;
    }

    public static void showTeachers() {
        System.out.println("The teachers are:");
        for (Teacher i : Platform.teachers)
            System.out.println(i.getID() + ". " + i.getUsername());
        System.out.println();
    }
    public static void showStudents() {
        System.out.println("The students are:");
        for (Student i : Platform.students)
            System.out.println(i.getID() + ". " + i.getUsername());
        System.out.println();
    }

    public static void showAvailableCourses() {
        System.out.println("The available courses are:");
        for (Course i : Platform.courses)
            System.out.println(i.getID() + ". " + i.getName() + ", by " + i.getOwner().getUsername());
        System.out.println();

    }
}
