package com.example.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Classroom {

    private String name;
    private List<Student> students;

    public Classroom(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        if (this.students == null) {
            this.students = new ArrayList<>();
        }
        this.students.add(student);
    }
}
