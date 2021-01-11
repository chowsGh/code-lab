package top.clydezhou.lab.demo.algorithms.sort.quicksort;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author clyde
 * @date 2020-11-03 21:50
 */
public class QuickSort {

    public void sort(int[] arr) {

    }

    public void jdkSort() {
        Arrays.sort(new int[] {0, 2, 6, 3, 5, 9, 4});
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        sort.jdkSort();
    }
}
