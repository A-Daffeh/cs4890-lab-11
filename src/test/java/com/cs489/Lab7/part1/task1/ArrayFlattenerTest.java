package com.cs489.Lab7.part1.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayFlattenerTest {
    @Test
    public void testFlattenArrayWithValidInput() {
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] expectedOutput = {1, 3, 0, 4, 5, 9};
        int[] actualOutput = ArrayFlattener.flattenArray(input);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testFlattenArrayWithNullInput() {
        int[][] input = null;
        int[] actualOutput = ArrayFlattener.flattenArray(input);
        assertArrayEquals(null, actualOutput);
    }
}

