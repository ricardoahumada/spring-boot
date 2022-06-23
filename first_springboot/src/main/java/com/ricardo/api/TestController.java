package com.ricardo.api;

import com.ricardo.models.Message;
import com.ricardo.models.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    // GET /test/hi
    @RequestMapping(value = "/hi")
    public String sayHello() {
        return "Hello springboot!!!";
    }

    // GET /test/test-tudent
    @RequestMapping(value = "/test-student", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Student getTestStudent(){
        Student testStudent=new Student(1L,"ric",3);
        return testStudent;
    }

    // POST /test/test-tudent -d {newStudent}
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/add-student",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Message postNewStudentTest(@RequestBody  Student newStudent){
        System.out.println(newStudent);
        return new Message("Todo OK");
    }

}
