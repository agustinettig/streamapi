package com.example.model;

import com.example.ScenarioFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    @Test
    void givenStudentList_getOldestStudent() {
        List<Student> students = ScenarioFactory.getStudentList();

        Student expected = new Student("TEST", 0);
        for (Student student : students) {
            if (student.getAge() > expected.getAge()) {
                expected = student;
            }
        }

        Student streamApiResult = students.stream()
                .max(Comparator.comparing(Student::getAge))
                .get();

        System.out.println("Old way: " + expected.getName());
        System.out.println("Stream API: " + streamApiResult.getAge());

        assertEquals(expected.getName(), streamApiResult.getName());
    }

    @Test
    void givenStudentList_getNewestStudent() {
        List<Student> students = ScenarioFactory.getStudentList();

        Student expected = new Student("TEST", Integer.MAX_VALUE);
        for (Student student : students) {
            if (student.getAge() < expected.getAge()) {
                expected = student;
            }
        }

        Student streamApiResult = students.stream()
                .min(Comparator.comparing(Student::getAge))
                .get();

        System.out.println("Old way: " + expected.getName());
        System.out.println("Stream API: " + streamApiResult.getName());

        assertEquals(expected.getName(), streamApiResult.getName());
    }

    @Test
    void givenStudentList_getStudentsWithAgeHigherThan30() {
        List<Student> students = ScenarioFactory.getStudentList();

        List<Student> expected = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() > 30) {
                expected.add(student);
            }
        }

        List<Student> streamApiResult = students.stream()
                .filter(student -> student.getAge() > 30)
                .collect(Collectors.toList());

        System.out.println("Old way: " + expected);
        System.out.println("Stream API: " + streamApiResult);

        assertEquals(expected, streamApiResult);
    }

    @Test
    void givenStudentList_getSumOfAgesOfNameStartsWithT() {
        List<Student> students = ScenarioFactory.getStudentList();

        int expected = 0;
        for (Student student : students) {
            if (student.getName().startsWith("T")) {
                expected += student.getAge();
            }
        }

        int streamApiResult = students.stream()
                .filter(student -> student.getName().startsWith("T"))
                .mapToInt(Student::getAge)
                .sum();

        System.out.println("Old way: " + expected);
        System.out.println("Stream API: " + streamApiResult);

        assertEquals(expected, streamApiResult);
    }

    @Test
    void givenStudentList_getAgeAverageAgeOfNamesWithTwelveCharacters() {
        List<Student> students = ScenarioFactory.getStudentList();

        int som = 0;
        int count = 0;
        for (Student student : students) {
            if (student.getName().length() == 12) {
                som += student.getAge();
                count += 1;
            }
        }
        double expected = (double) som / count;

        double streamApiResult = students.stream()
                .filter(student -> student.getName().length() == 12)
                .mapToInt(Student::getAge)
                .average()
                .getAsDouble();

        System.out.println("Old way: " + expected);
        System.out.println("Stream API: " + streamApiResult);

        assertEquals(expected, streamApiResult);
    }
}
