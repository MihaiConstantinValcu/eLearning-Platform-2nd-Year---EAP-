package com.company.Services;

import com.company.Objects.Course;

public interface History {
    void addCourse(Course course, int grade);

    void showHistory();
}
