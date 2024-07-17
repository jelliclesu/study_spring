package com.sparta.week02.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본생성자 대신 생성
@Entity // 테이블임을 나타냄
@Getter
public class Course extends Timestamped{

    @Id // ID 값, Primary Key로 사용하겠다는 뜻
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함
    private String title;

    @Column(nullable = false)
    private String tutor;

//    public Long getId() {
//        return this.id;
//    }
//    public String getTitle() {
//        return this.title;
//    }
//
//    public String getTutor() {
//        return this.tutor;
//    }

    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    public void update(Course course) {
        this.title = course.title;
        this.tutor = course.tutor;;
    }
}
