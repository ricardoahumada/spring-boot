package com.ricardo.api;

import com.ricardo.models.Message;
import com.ricardo.models.Student;
import com.ricardo.services.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    // Inject Service
    @Autowired
    StudentsServices stdServ;

    // GET /students
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents() {
        return stdServ.getAllStudents();
    }

    // POST /students -d {newStudent}
    /*@RequestMapping(
            method = RequestMethod.POST,
            value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
//    public Message postNewStudentTest(@RequestBody Student newStudent) {
    public ResponseEntity<Message> postNewStudentTest(@Valid @RequestBody Student newStudent) {
        System.out.println(newStudent);
        if (newStudent != null && newStudent.isValid()) {
            stdServ.addStudent(newStudent);
//            return new Message("Todo OK");
            return new ResponseEntity(new Message("Todo OK"), HttpStatus.CREATED);
        } else {
//            return new Message("NOK");
            return new ResponseEntity(new Message("NOK"), HttpStatus.BAD_REQUEST);
        }
    }*/


    // POST /students -d {newStudent}
    @RequestMapping(
            method = RequestMethod.POST,
            value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
//    public Message postNewStudentTest(@Valid @RequestBody Student newStudent) {
    public ResponseEntity<Message> postNewStudentTest(@Valid @RequestBody Student newStudent) {
        System.out.println(newStudent);
        stdServ.addStudent(newStudent);
//        return new Message("Todo OK");
        return new ResponseEntity<>(new Message("todo OK"), HttpStatus.CREATED);
    }


    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Student> getOneStudent(@PathVariable Long id) {
        System.out.println("id:" + id);
        Student estudianteADevolver = stdServ.getStudentById(id);
        if (estudianteADevolver != null) {
            return new ResponseEntity<>(estudianteADevolver, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(estudianteADevolver, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Message> updateStudent(
            @PathVariable Long id,
            @RequestBody Student dataToUpdateStudent
    ) {
        System.out.println(id + "::" + dataToUpdateStudent);
        Student updatedStudent = stdServ.updateStudent(id, dataToUpdateStudent);
        if (updatedStudent != null) return new ResponseEntity<>(new Message("OK!!"), HttpStatus.ACCEPTED);
        else return new ResponseEntity<>(new Message("NO EXISTE!!"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> deleteStudent(@PathVariable Long id) {
        boolean isDeleted = stdServ.removeStudent(id);
        if (isDeleted) return new ResponseEntity(new Message("OK!!"), HttpStatus.ACCEPTED);
        else return new ResponseEntity(new Message("No existe!!"), HttpStatus.NOT_FOUND);
    }


}
