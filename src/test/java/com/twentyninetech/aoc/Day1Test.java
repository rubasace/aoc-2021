package com.twentyninetech.aoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day1Test {

    @Test
    void shouldCountIncrements() {
        int result = Day1.countIncrements("day1-test.txt");

        assertEquals(7, result);
    }

    @Test
    void shouldCountIncrementsByWindows() {
        int result = Day1.countIncrementsByWindows("day1-test.txt");

        assertEquals(5, result);
    }
}