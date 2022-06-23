package com.ricardo.persistence;

import com.ricardo.models.Student;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepoStudents {
    List<Student> estudiantes = new ArrayList<>();

    public InMemoryRepoStudents() {
        estudiantes.add(new Student(1L, "rosa", 3));
        estudiantes.add(new Student(2L, "juan", 5));
        estudiantes.add(new Student(3L, "luisa", 4));
    }

    public List<Student> getAll() {
        return estudiantes;
    }

    public void storeStudent(Student newStudent) {
        Long newId = (long) (estudiantes.size() + 1);
        newStudent.setId(newId);
        estudiantes.add(newStudent);
    }

    public Student loadStudent(Long id) {
        for (Student unStd : estudiantes) {
            if (unStd.getId() == id) return unStd;
        }
        return null;
    }

    public Student updateStoredStudent(Student storedStudentToModify) {
        for (Student unStd : estudiantes) {
            if (unStd.getId() == storedStudentToModify.getId()) {
                estudiantes.remove(unStd);
                estudiantes.add(storedStudentToModify);
                return storedStudentToModify;
            }
        }
        return null;
    }

    public boolean deleteStudent(Long id) {
        for (Student unStd : estudiantes) {
            if (unStd.getId() == id) {
                estudiantes.remove(unStd);
                return true;
            }
        }
        return false;
    }

}
