package com.ricardo.models;

import javax.validation.constraints.*;

public class Student {
    private Long id;
    @NotNull (message = "Name debe tener un valor")
    @NotBlank(message = "Name debe tener un valor")
    @NotEmpty(message = "Name debe tener un valor")
    private String name;
    @Min(value = 1,message = "Debe ser entre 1 y 5")
    @Max(value = 5,message = "Debe ser entre 1 y 5")
    private int grade;

    public Student() {
    }

    public Student(Long id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean isValid(){
        if(this.name!=null && this.name.length()>0 && grade>=1 && grade <=5) return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
