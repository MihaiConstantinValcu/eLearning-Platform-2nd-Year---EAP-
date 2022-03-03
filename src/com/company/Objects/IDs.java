package com.company.Objects;

public class IDs {
    private static int StudentID = 0;
    private static int TeacherID = -1;
    private static int CourseID = 0;
    private static int TestID = 0;

    public static int generateStudentID() {
        StudentID++;
        return StudentID;
    }

    public static int generateTeacherID() {
        TeacherID++;
        return TeacherID;
    }

    public static int generateCourseID() {
        CourseID++;
        return CourseID;
    }

    public static int generateTestID() {
        TestID++;
        return TestID;
    }

    public static void updateStudentID(int newID) {
        StudentID = newID;
    }

    public static void updateTeacherID(int newID) {
        TeacherID = newID;
    }

    public static void updateCourseID(int newID) {
        CourseID = newID;
    }

    public static void updateTestID(int newID) {
        TestID = newID;
    }
}
