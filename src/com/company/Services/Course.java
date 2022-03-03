package com.company.Services;

import com.company.Objects.Chapter;
import com.company.Objects.Quiz;
import com.company.Objects.Student;

public interface Course {
    void addQuiz(Quiz quiz);

    void deleteQuiz(int ID);

    void showNoQuizes();

    void addChapter(Chapter chapter);

    void deleteChapter(int ID);

    void showChapters();

    void addStudent(Student student);

    void removeStudent(int ID);

    void showStudents();
}
