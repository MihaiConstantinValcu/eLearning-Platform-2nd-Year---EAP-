package com.company.Objects;

public class FinalExam extends Quiz {
    private final int time = 120;
    int ID;

    public FinalExam() {
        this.ID = IDs.generateTestID();
    }
}
