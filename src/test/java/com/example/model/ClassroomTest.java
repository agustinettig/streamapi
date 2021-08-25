package com.example.model;

import com.example.ScenarioFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassroomTest {

    @Test
    void givenClassroomList_getStudentsNamesOrderedByAge() {
        List<Classroom> classrooms = ScenarioFactory.getClassroomList();

        List<Student> students = new ArrayList<>();
        for (Classroom classroom : classrooms) {
            for (Student student : classroom.getStudents()) {
                students.add(student);
            }
        }
        students.sort(Comparator.comparing(Student::getAge));
        List<String> expected = new ArrayList<>();
        for (Student student : students) {
            expected.add(student.getName());
        }

        List<String> streamApiResult = classrooms.stream()
                .flatMap(classroom -> classroom.getStudents().stream())
                .sorted(Comparator.comparing(Student::getAge))
                .map(student -> student.getName())
                .collect(Collectors.toList());

        System.out.println("Old way: " + expected);
        System.out.println("Stream API: " + streamApiResult);

        assertEquals(expected, streamApiResult);
    }

    @Test
    void givenClassroomList_geSumOfAgesOfStudentsWhenNameStartsWithTAndAgeIsGreaterOrEquals35() {
        List<Classroom> classrooms = ScenarioFactory.getClassroomList();

        int expected = 0;
        for (Classroom classroom : classrooms) {
            for (Student student : classroom.getStudents()) {
                if (student.getName().startsWith("T") && student.getAge() >= 35) {
                    expected += student.getAge();
                }
            }
        }

        int streamApiResult = classrooms.stream()
                .flatMap(classroom -> classroom.getStudents().stream())
                .filter(student -> student.getName().startsWith("T"))
                .filter(student -> student.getAge() >= 35)
                .mapToInt(Student::getAge)
                .sum();

        System.out.println("Old way: " + expected);
        System.out.println("Stream API: " + streamApiResult);

        assertEquals(expected, streamApiResult);
    }

}
