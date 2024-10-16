package com.sparta.week01hw.Controller;

import com.sparta.week01hw.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/myinfo")
    public Person getPerson() {
        Person person = new Person();
        person.setName("jelliclesu");
        person.setAge(25);
        person.setGender("w");
        return person;
    }
}
