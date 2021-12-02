package com.twentyninetech.aoc;

import com.twentyninetech.aoc.util.FileUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

    static int trackPosition(final String fileName) {
        List<String> instructions = FileUtils.getLines(fileName)
                                             .collect(Collectors.toList());
        int horizontal = 0;
        int depth = 0;

        for (String instruction : instructions) {
            String[] parts = instruction.split(" ");
            int value = Integer.parseInt(parts[1]);
            switch (parts[0]) {
                case "up":
                    depth -= value;
                    break;
                case "down":
                    depth += value;
                    break;
                case "forward":
                    horizontal += value;
                    break;
            }
        }
        return horizontal * depth;
    }

    static int trackPositionWithAim(final String fileName) {
        List<String> instructions = FileUtils.getLines(fileName)
                                             .collect(Collectors.toList());
        int aim = 0;
        int horizontal = 0;
        int depth = 0;

        for (String instruction : instructions) {
            String[] parts = instruction.split(" ");
            int value = Integer.parseInt(parts[1]);
            switch (parts[0]) {
                case "up":
                    aim -= value;
                    break;
                case "down":
                    aim += value;
                    break;
                case "forward":
                    horizontal += value;
                    depth += value * aim;
                    break;
            }
        }
        return horizontal * depth;
    }


    public static void main(final String[] args) {
        System.out.println("Part 1: " + trackPosition("day2-input.txt"));
        System.out.println("Part 2: " + trackPositionWithAim("day2-input.txt"));
    }

}
