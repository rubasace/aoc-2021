package com.twentyninetech.aoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Test {

    @Test
    void shouldCalculatePowerConsumption() {
        int result = Day3.calculatePowerConsumption("day3-test.txt");

        assertEquals(198, result);
    }

    @Test
    void shouldCalculateLifeSupportRating() {
        int result = Day3.calculateLifeSupportRating("day3-test.txt");

        assertEquals(230, result);
    }
}