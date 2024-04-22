package com.cs489.Lab7.part1.task2;

public class ArrayReversorImpl implements ArrayReversor {
    private ArrayFlattenerService arrayFlattenerService;

    public ArrayReversorImpl(ArrayFlattenerService arrayFlattenerService) {
        this.arrayFlattenerService = arrayFlattenerService;
    }

    @Override
    public int[] reverseArray(int[][] input) {
        if (input == null) return null;

        int[] flattenedArray = arrayFlattenerService.flattenArray(input);
        int[] reversedArray = new int[flattenedArray.length];
        for (int i = 0; i < flattenedArray.length; i++) {
            reversedArray[i] = flattenedArray[flattenedArray.length - 1 - i];
        }
        return reversedArray;
    }
}

