package com.cs489.Lab7.part1.task2;

public class ArrayFlattenerServiceMock implements ArrayFlattenerService {
    @Override
    public int[] flattenArray(int[][] input) {
        return new int[]{9, 5, 4, 0, 3, 1};
    }
}

