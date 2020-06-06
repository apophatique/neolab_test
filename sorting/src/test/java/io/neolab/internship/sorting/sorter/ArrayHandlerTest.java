package io.neolab.internship.sorting.sorter;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayHandlerTest {
    private static final int MAX_NUMBER = 20;
    private static final int ELEMENTS_NUM = 15;

    @Test
    public void shouldWorkCorrectlyWithEmptyList() {
        Integer[] array = new Integer[] {};

        ArrayList<Integer> expectedList = new ArrayList<Integer>();
        ArrayList<Integer> actualList = ArrayHandler.sortArray(new ArrayList<Integer>(Arrays.asList(array)));

        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void shouldWorkCorrectlyWithFilledAtFirst() {
        Integer[] inputArray =    {2, 5, 13, 17, 11, 17, 1, 18, 16, 13, 14, 2, 2, 1, 18};
        Integer[] expectedArray = {2, 1, 1, 5, 11, 13, 13, 18, 16, 17, 14, 2, 2, 17, 18};

        ArrayList<Integer> expectedList = ArrayHandler.sortArray(new ArrayList<Integer>(Arrays.asList(expectedArray)));
        ArrayList<Integer> actualList = new ArrayList<Integer>(Arrays.asList(inputArray));
    }

    @Test
    public void shouldWorkCorrectlyWithFilledAtSecond() {
        Integer[] inputArray =    {2, 9, 4, 7, 6, 5, 8, 3, 10, 1, 0, 1, 0, 1};
        Integer[] expectedArray = {2, 1, 4, 1, 6, 1, 8, 3, 10, 5, 0, 7, 0, 9};

        ArrayList<Integer> expectedList = ArrayHandler.sortArray(new ArrayList<Integer>(Arrays.asList(expectedArray)));
        ArrayList<Integer> actualList = new ArrayList<Integer>(Arrays.asList(inputArray));

        actualList = ArrayHandler.sortArray(actualList);


        Assert.assertEquals(expectedList, actualList);
    }

    @Test
    public void shouldWorkCorrectlyWithFilledAtThird() {
        Integer[] inputArray =    {10, 10, 10, 11, 9, 7, 5, 3, 1, 0, 0, 0, -1, -3, -5, -7, -9, -11, 20, 20, 20};
        Integer[] expectedArray = {10, 10, 10, -11, -9, -7, -5, -3, -1, 0, 0, 0, 1, 3, 5, 7, 9, 11, 20, 20, 20};

        ArrayList<Integer> expectedList = ArrayHandler.sortArray(new ArrayList<Integer>(Arrays.asList(expectedArray)));
        ArrayList<Integer> actualList = new ArrayList<Integer>(Arrays.asList(inputArray));

        actualList = ArrayHandler.sortArray(actualList);

        Assert.assertEquals(expectedList, actualList);
    }
}
