package com.company.Objects;

import com.company.Services.Audit;

import java.util.ArrayList;
import java.util.List;

public class Course implements com.company.Services.Course {
    private final int ID;
    private String name;
    private Teacher owner;
    private List<Chapter> chapters = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Quiz> quizzes = new ArrayList<>();
    private FinalExam finalExam;


    public Course(String name, Teacher owner) {
        this.ID = IDs.generateCourseID();
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getOwner() {
        return owner;
    }

    public void setOwner(Teacher owner) {
        this.owner = owner;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public FinalExam getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(FinalExam finalExam) {
        this.finalExam = finalExam;
    }

    public int getID() {
        return ID;
    }

    // Quizes Management

    @Override
    public void addQuiz(Quiz quiz) {
        Audit.write("Add Quiz");
        this.quizzes.add(quiz);

    }

   // @Override
    //public void addQuiz(){

   // }

    @Override
    public void deleteQuiz(int ID) {
        Audit.write("Delete Quiz");
        quizzes.removeIf(i -> i.getID() == ID);
    }

    @Override
    public void showNoQuizes() {
        Audit.write("Show Number Of Quizzes");
        System.out.println("There are " + quizzes.size() + " quizzes available.");
        System.out.println();
    }

    // Chapters Management
    @Override
    public void addChapter(Chapter chapter) {
        Audit.write("Add Chapter");
        this.chapters.add(chapter);
    }

    @Override
    public void deleteChapter(int ID) {
        Audit.write("Delete Chapter");
        quizzes.removeIf(i -> i.getID() == ID);
    }

    @Override
    public void showChapters() {
        Audit.write("Show Chapters");
        System.out.println("Chapters available in the course " + this.getName());
        for (Chapter i : chapters)
            System.out.println(i.getName());
        System.out.println();
    }

    public void showContent(){
        Audit.write("Show Content");
        System.out.println("Chapters available in the course " + this.getName());
        for (Chapter i : chapters){
            i.seeContent();
        }
        System.out.println();
    }

    // Users Mangement
    @Override
    public void addStudent(Student student) {
        Audit.write("Add Student");
        this.students.add(student);
    }

    @Override
    public void removeStudent(int ID) {
        Audit.write("Remove Student");
        quizzes.removeIf(i -> i.getID() == ID);
    }

    @Override
    public void showStudents() {
        Audit.write("Show Students");
        for (Chapter i : chapters)
            System.out.println(i.getName());
        System.out.println();
    }

}
