package com.sparta.week02;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Week02Application {

    public static void main(String[] args) {
        SpringApplication.run(Week02Application.class, args);
    }
    @Bean
    public CommandLineRunner demo(CourseRepository repository, CourseService courseService, CourseRepository courseRepository) {
        return (args) -> {
            // 데이터 저장하기(Create)
            repository.save(new Course("Spring", "곽두필"));

            // 데이터 전부 조회하기(Read)
            List<Course> courseList = repository.findAll();
            for (int i=0; i < courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            // 데이터 하나 조회하기(Read)
//            Course course = repository.findById(1L).orElseThrow(
//                    () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
//            );

            // Update
            Course new_course = new Course("Spring", "박두식");
            courseService.update(1L, new_course);
            courseList = courseRepository.findAll();
            for (int i=0; i < courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            // Delete
            courseRepository.deleteAll();
        };
    }

}
