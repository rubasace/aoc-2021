package com.twentyninetech.aoc;

import com.twentyninetech.aoc.util.FileUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Day3 {

    static int calculatePowerConsumption(final String fileName) {
        List<char[]> lines = FileUtils.getLines(fileName)
                                      .map(String::toCharArray)
                                      .collect(Collectors.toList());
        int[] positionCounter = new int[lines.get(0).length];

        for (char[] instruction : lines) {
            for (int i = 0; i < instruction.length; i++) {
                if ('1' == instruction[i]) {
                    positionCounter[i]++;
                }
            }
        }

        String commonValues = Arrays.stream(positionCounter)
                                    .mapToObj(e -> e > lines.size() / 2 ? "y" : "n")
                                    .collect(Collectors.joining(""));
        int gamma = Integer.parseInt(commonValues.replace('y', '1').replace('n', '0'), 2);
        int epsilon = Integer.parseInt(commonValues.replace('y', '0').replace('n', '1'), 2);

        return gamma * epsilon;
    }

    static int calculateLifeSupportRating(final String fileName) {
        List<char[]> lines = FileUtils.getLines(fileName)
                                      .map(String::toCharArray)
                                      .collect(Collectors.toList());

        int oxygen = filterByCriteria(lines, (character, mostCommonCharacter) -> character == mostCommonCharacter);
        int co2 = filterByCriteria(lines, (character, mostCommonCharacter) -> character != mostCommonCharacter);

        return oxygen * co2;

    }

    private static int filterByCriteria(final List<char[]> lines, final BiFunction<Character, Character, Boolean> comparator) {

        List<char[]> selectedLines = lines;

        for (int i = 0; i < lines.get(0).length; i++) {
            if (selectedLines.size() == 1) {
                break;
            }
            char mostCommonCharacter = findMostCommonCharacter(selectedLines, i);
            int position = i;
            selectedLines = selectedLines.stream()
                                         .filter(line -> comparator.apply(line[position], mostCommonCharacter))
                                         .collect(Collectors.toList());

        }

        int value = Integer.parseInt(String.valueOf(selectedLines.get(0)), 2);

        return value;

    }

    private static char findMostCommonCharacter(List<char[]> lines, int position) {
        int limit = lines.size() / 2;
        int zeros = 0;
        int ones = 0;
        for (char[] line : lines) {
            if (line[position] == '0') {
                zeros++;
            } else {
                ones++;
            }
            if (zeros > limit || ones > limit) {
                break;
            }
        }
        return zeros > ones ? '0' : '1';
    }


    public static void main(final String[] args) {
        System.out.println("Part 1: " + calculatePowerConsumption("day3-input.txt"));
        System.out.println("Part 2: " + calculateLifeSupportRating("day3-input.txt"));
    }

}
