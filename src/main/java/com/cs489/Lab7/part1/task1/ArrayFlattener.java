package com.cs489.Lab7.part1.task1;

import java.util.ArrayList;
import java.util.List;

public class ArrayFlattener {
    public static int[] flattenArray(int[][] input) {
        if (input == null) return null;

        List<Integer> flattenedList = new ArrayList<>();
        for (int[] nestedArray : input) {
            for (int num : nestedArray) {
                flattenedList.add(num);
            }
        }

        int[] flattenedArray = new int[flattenedList.size()];
        for (int i = 0; i < flattenedList.size(); i++) {
            flattenedArray[i] = flattenedList.get(i);
        }

        return flattenedArray;
    }
}
