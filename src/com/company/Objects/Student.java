package com.company.Objects;

import com.company.Services.Audit;
import com.company.Services.User;

public class Student implements User {
    private final int ID;
    private String username;
    private String password;
    private final History courseHistory;

    public Student(String username, String password) {
        this.ID = IDs.generateStudentID();
        this.username = username;
        this.password = password;
        courseHistory = new History();
    }

    public void addCourse(Course course, int grade) {
        courseHistory.addCourse(course, grade);
    }

    public void showHistory() {
        this.courseHistory.showHistory();
    }

    @Override
    public String getUsername() {
        //Audit.write("Get Username");
        return this.username;
    }

    @Override
    public void changeUsername(String username) {
        Audit.write("Change Username");
        this.username = username;
    }

    @Override
    public String getPassword() {
        Audit.write("Get Password");
        return this.password;
    }

    @Override
    public void changePassword(String password) {
        Audit.write("Change Password");
        this.password = password;
    }

    @Override
    public int getID(){
        return this.ID;
    }
}
