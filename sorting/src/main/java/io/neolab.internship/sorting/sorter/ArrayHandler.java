package io.neolab.internship.sorting.sorter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Class for the task.
 */
public final class ArrayHandler {

    /**
     * Function, that sorts array in ascending order, keeping even numbers in their places (including 0).
     *
     * Algorithm is directly Hoar sort (Fast sort) with some special task amendments.
     * its complexity is O(n*log(n)) in average cases for n elements.
     *
     * @param inputArray {@link ArrayList<Integer>} - an array we sort.
     * @return {@link ArrayList<Integer>} sorted Array list.
     */
    public static ArrayList<Integer> sortArray(final ArrayList<Integer> inputArray) {
        ArrayList<Integer> array = new ArrayList<>(inputArray);

        if (inputArray.size() <= 1) {
            return array;
        }

        final int barrier = array.get(0);
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> equalsList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        for (Integer item : array) {
            if (item % 2 == 0) {
                continue;
            }

            if (item < barrier) {
                leftList.add(item);
            } else if (item > barrier) {
                rightList.add(item);
            } else {
                equalsList.add(item);
            }
        }

        ArrayList<Integer> finalLeftList = sortArray(leftList);
        ArrayList<Integer> finalRightList = sortArray(rightList);

        Queue<Integer> queue = new ArrayDeque<>(new ArrayList<Integer>() {
            {
                addAll(finalLeftList);
                addAll(equalsList);
                addAll(finalRightList);
            }
        });

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) % 2 == 0) {
                continue;
            }
            array.set(i, queue.poll());
        }

        return array;
    }

    private ArrayHandler() {}
}
