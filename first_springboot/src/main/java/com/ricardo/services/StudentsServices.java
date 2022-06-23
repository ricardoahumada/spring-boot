package com.ricardo.services;

import com.ricardo.models.Student;
import com.ricardo.persistence.InMemoryRepoStudents;

import java.util.List;

public class StudentsServices {

    InMemoryRepoStudents repo;

    public List<Student> getAllStudents() {
        return repo.getAll();
    }

    public void setRepo(InMemoryRepoStudents repo) {
        this.repo = repo;
    }

    public void addStudent(Student newStudent) {
        if (newStudent != null && newStudent.isValid()) repo.storeStudent(newStudent);
    }

    public Student getStudentById(Long id) {
        if (id > 0) return repo.loadStudent(id);
        else return null;
    }

    public Student updateStudent(Long id, Student dataReceived) {
        if (id > 0) {
            Student storedStudentToModify = getStudentById(id);
            if (storedStudentToModify != null) {

                if (dataReceived.getName() != null && dataReceived.getName().length() > 0)
                    storedStudentToModify.setName(dataReceived.getName());
                if (dataReceived.getGrade() > 0) storedStudentToModify.setGrade(dataReceived.getGrade());

                return repo.updateStoredStudent(storedStudentToModify);
            } else return null;

        } else return null;
    }

    public boolean removeStudent(Long id) {
        if (id > 0) {
            return repo.deleteStudent(id);
        }
        return false;
    }
}
