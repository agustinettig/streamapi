package com.example;

import com.example.model.Classroom;
import com.example.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScenarioFactory {

    public static List<Integer> getNumberList() {
        return Arrays.asList(2, 2, 4, 2, 8, 20, 14, 6);
    }

    public static List<Student> getStudentList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tony Stark ", 50));
        students.add(new Student("Bruce Banner", 47));
        students.add(new Student("Thor Odinson", 130));
        students.add(new Student("Steve Rogers", 20));
        students.add(new Student("T'Challa", 30));
        students.add(new Student("Peter Parker", 16));
        return students;
    }

    public static List<Classroom> getClassroomList() {
        Classroom mathClass = new Classroom("Math");
        mathClass.addStudent(new Student("Peter Parker", 16));
        mathClass.addStudent(new Student("Thor Odinson", 130));

        Classroom biologyClass = new Classroom("Biology");
        biologyClass.addStudent(new Student("T'Challa", 30));
        biologyClass.addStudent(new Student("Steve Rogers", 20));

        Classroom physicsClass = new Classroom("Physics");
        physicsClass.addStudent(new Student("Tony Stark ", 50));
        physicsClass.addStudent(new Student("Bruce Banner", 47));

        return Arrays.asList(mathClass, biologyClass, physicsClass);
    }
}
