package com.twentyninetech.aoc;

import com.twentyninetech.aoc.util.FileUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Day1 {

    static int countIncrements(final String fileName) {
        List<Integer> numbers = FileUtils.getLines(fileName)
                                         .map(Integer::parseInt)
                                         .collect(Collectors.toList());
        int counter = 0;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > numbers.get(i - 1)) {
                counter++;
            }
        }
        return counter;
    }

    static int countIncrementsByWindows(final String fileName) {
        List<Integer> numbers = FileUtils.getLines(fileName)
                                         .map(Integer::parseInt)
                                         .collect(Collectors.toList());
        int counter = 0;
        for (int i = 3; i < numbers.size(); i++) {
            int current = numbers.get(i) + numbers.get(i - 1) + numbers.get(i - 2);
            int previous = numbers.get(i - 1) + numbers.get(i - 2) + numbers.get(i - 3);
            if (current > previous) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(final String[] args) {
        System.out.println("Part 1: " + countIncrements("day1-input.txt"));
        System.out.println("Part 2: " + countIncrementsByWindows("day1-input.txt"));
    }
}
