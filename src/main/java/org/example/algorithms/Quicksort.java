package org.example.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quicksort {


    public static List<Integer> quickSort(List<Integer> arr) {
        //clone arr
        List<Integer> arrCopy = new ArrayList<>(arr);
        quickSortHelper(arrCopy, 0, arr.size() - 1);
        return arrCopy;
    }

    private static void quickSortHelper(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortHelper(arr, low, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr.get(j) <= pivot) {
                i++;
                if (i != j) {
                    Collections.swap(arr, i, j);
                }
            }
        }
        if (i + 1 != high) {
            Collections.swap(arr, i + 1, high);
        }
        return i + 1;
    }
}
