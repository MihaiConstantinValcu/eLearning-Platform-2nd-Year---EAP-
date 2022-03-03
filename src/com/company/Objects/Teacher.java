package com.company.Objects;

import com.company.Services.Audit;
import com.company.Services.User;
import com.company.Singletons.Platform;

import java.util.ArrayList;
import java.util.List;

public class Teacher implements User {
    private final int ID;
    private String username;
    private String password;
    private final ArrayList<Course> ownedCourses = new ArrayList<>();

    public Teacher(String username, String password) {
        this.ID = IDs.generateTeacherID();
        this.username = username;
        this.password = password;
    }

    public Teacher(String username, String password, int ID) {
        this.ID = ID;
        this.username = username;
        this.password = password;
    }

    public void addCourse(Course course) {
        ownedCourses.add(course);
    }

    public List<Course> getCourses(){ return ownedCourses; }

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
    public int getID() {
        return this.ID;
    }

    public void showCourses(){
        for (Course c : ownedCourses)
            System.out.println(c.getName());
        System.out.println();
    }

    public void gradeStudent(String id, String name, int grade){
        Course c = null;
        if(ownedCourses.isEmpty())
            System.out.println("You do not have any courses.");
        else {
            for (Course C : ownedCourses)
                if (C.getName().equals(name))
                    c = C;
            if (c != null){
                for (Student s : Platform.getStudents())
                    if (s.getID() == Integer.parseInt(id))
                        s.addCourse(c, grade);
            }
            else System.out.println("You do not own this course");

        }
    }
}
