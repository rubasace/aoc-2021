package com.twentyninetech.aoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Test {

    @Test
    void shouldTrackPosition() {
        int result = Day2.trackPosition("day2-test.txt");

        assertEquals(150, result);
    }

    @Test
    void shouldTrackPositionWithAim() {
        int result = Day2.trackPositionWithAim("day2-test.txt");

        assertEquals(900, result);
    }
}