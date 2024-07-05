package com.sparta.week01.prac;

public class Course {
    public String title;
    public String tutor;
    public int days;

    /* Getter, Setter 만들기 */
    // Getter
    public String getTitle() {
        return this.title;
    }

    // Getter
    public String getTutor() {
        return this.tutor;
    }

    // Getter
    public int getDays() {
        return this.days;
    }

    // Setter
    public void setTitle(String title) {
        this.title = title;
    }

    // Setter
    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    // Setter
    public void setDays(int days) {
        this.days = days;
    }
}
