package io.neolab.internship.sorting;


import io.neolab.internship.sorting.sorter.ArrayHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


/**
 * Main class.
 */
public final class Main {
    private static Random random = new Random();

    /**
     * psvm, where we testing the sorter work.
     *
     * @param args - command line args.
     */
    public static void main(final String[] args) {
        final int maxNumber = 20;
        final int elementsNum = 15;
        Integer[] array = new Integer[elementsNum];

        for (int i = 0; i < elementsNum; i++) {
            array[i] = random.nextInt(maxNumber);
        }
        // array = new Integer[] {};

        System.out.println("Input massive (random): ");
        for (int item : array) {
            System.out.print(item + " ");
        }

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(array));
        arrayList = ArrayHandler.sortArray(arrayList);
        System.out.println("\nSorted massive: ");
        for (int item : arrayList) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private Main() {}
}