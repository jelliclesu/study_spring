package com.sparta.week01.prac;

public class Tutor {
    // 멤버 변수
    private String name;
    private int bio;

    // 기본 생성자
    public Tutor() {

    }

    // 생성자
    public Tutor(String name, int bio) {
        this.name = name;
        this.bio = bio;
    }

    // Getter
    public String getName() {
        return this.name;
    }
    public int getBio() {
        return this.bio;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
    public void setBio(int Bio) {
        this.bio = bio;
    }
}
