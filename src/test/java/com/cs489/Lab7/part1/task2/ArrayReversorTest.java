package com.cs489.Lab7.part1.task2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ArrayReversorTest {
    @Test
    public void testReverseArrayWithValidInput() {
        // Arrange
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        ArrayFlattenerService arrayFlattenerServiceMock = Mockito.mock(ArrayFlattenerService.class);
        when(arrayFlattenerServiceMock.flattenArray(input)).thenReturn(new int[]{9, 5, 4, 0, 3, 1});
        ArrayReversor arrayReversor = new ArrayReversorImpl(arrayFlattenerServiceMock);

        int[] actualOutput = arrayReversor.reverseArray(input);

        int[] expectedOutput = {9, 5, 4, 0, 3, 1};
        assertArrayEquals(expectedOutput, actualOutput);
        verify(arrayFlattenerServiceMock).flattenArray(input);
    }

    @Test
    public void testReverseArrayWithNullInput() {
        int[][] input = null;
        ArrayFlattenerService arrayFlattenerServiceMock = Mockito.mock(ArrayFlattenerService.class);
        ArrayReversor arrayReversor = new ArrayReversorImpl(arrayFlattenerServiceMock);

        int[] actualOutput = arrayReversor.reverseArray(input);

        assertArrayEquals(null, actualOutput);
        verifyNoInteractions(arrayFlattenerServiceMock);
    }
}

