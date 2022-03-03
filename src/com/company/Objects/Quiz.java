package com.company.Objects;

import java.util.ArrayList;

public class Quiz {
    protected int time = 30;
    protected ArrayList<ExamItem> questions;
    int ID;

    public Quiz() {
        this.ID = IDs.generateTestID();
        questions = new ArrayList<>();
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public ArrayList<ExamItem> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList questions) {
        this.questions = questions;
    }

    public void addQuestion(ExamItem question){ questions.add(question); }

    public int getID() {
        return ID;
    }
}
