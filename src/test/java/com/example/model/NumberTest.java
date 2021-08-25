package com.example.model;

import com.example.ScenarioFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberTest {

    @Test
    void givenAnIntegerList_getTheBiggestNumber() {
        List<Integer> numbers = ScenarioFactory.getNumberList();

        int expected = 0;
        for (Integer number : numbers) {
            if (number > expected) {
                expected = number;
            }
        }

        int streamApiResult = numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow();

        System.out.println("Old way: " + expected);
        System.out.println("Stream API: " + streamApiResult);

        assertEquals(expected, streamApiResult);
    }

    @Test
    void givenAnIntegerList_getTheLowestNumber() {
        List<Integer> numbers = ScenarioFactory.getNumberList();

        int expected = Integer.MAX_VALUE;
        for (Integer number : numbers) {
            if (number < expected) {
                expected = number;
            }
        }

        int streamApiResult = numbers.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow();

        System.out.println("Old way: " + expected);
        System.out.println("Stream API: " + streamApiResult);

        assertEquals(expected, streamApiResult);
    }

    @Test
    void givenAnIntegerList_getSumFromList() {
        List<Integer> numbers = ScenarioFactory.getNumberList();

        int expected = 0;
        for (Integer number : numbers) {
            expected += number;
        }

        int streamApiResult = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Old way: " + expected);
        System.out.println("Stream API: " + streamApiResult);

        assertEquals(expected, streamApiResult);
    }

    @Test
    void givenAnIntegerList_getSumOfUniqueNumbersFromList() {
        List<Integer> numbers = ScenarioFactory.getNumberList();

        int expected = 0;
        List<Integer> distinctNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (!distinctNumbers.contains(number)) {
                distinctNumbers.add(number);
                expected += number;
            }
        }

        int streamApiResult = numbers.stream()
                .mapToInt(Integer::intValue)
                .distinct()
                .sum();

        System.out.println("Old way: " + expected);
        System.out.println("Stream API: " + streamApiResult);

        assertEquals(expected, streamApiResult);
    }

    @Test
    void givenAnIntegerList_getMultipliedByTwoListFromIt() {
        List<Integer> numbers = ScenarioFactory.getNumberList();

        List<Integer> expected = new ArrayList<>();
        for (Integer number : numbers) {
            expected.add(number * 2);
        }

        List<Integer> streamApiResult = numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());

        System.out.println("Old way: " + expected);
        System.out.println("Stream API: " + streamApiResult);

        assertEquals(expected, streamApiResult);
    }

    @Test
    void givenAnIntegerList_checkIfAllNumbersAreEven() {
        List<Integer> numbers = ScenarioFactory.getNumberList();

        boolean expected = true;
        for (Integer i : numbers) {
            if (i % 2 != 0) {
                expected = false;
            }
        }

        boolean streamApiResult = numbers.stream()
                .allMatch(number -> number % 2 == 0);

        System.out.println("Old way: " + expected);
        System.out.println("Stream API: " + streamApiResult);

        assertEquals(expected, streamApiResult);
    }
}
