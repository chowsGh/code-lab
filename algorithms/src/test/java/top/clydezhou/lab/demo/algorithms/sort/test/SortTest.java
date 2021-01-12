package top.clydezhou.lab.demo.algorithms.sort.test;

import org.junit.Assert;
import org.junit.Test;
import top.clydezhou.lab.demo.algorithms.sort.SimpleSort;

import java.util.Arrays;
import java.util.function.Consumer;

import static top.clydezhou.lab.demo.algorithms.sort.SortUtils.*;

/**
 * @author clyde
 * @date 2020-11-04 23:04
 */
public class SortTest {

    int[] ints = randomIntArr(10000);


    @Test
    public void testSelectSort() {
        testSort(SimpleSort::selectSort);
    }

    @Test
    public void testInsertSort() {
        testSort(SimpleSort::insertSort);
    }

    /**
     * 已经排序好的数组，性能最好。
     */
    @Test
    public void testInsertSortBest() {
        int[] arr = Arrays.copyOf(ints, ints.length);
        Arrays.sort(arr);
        testSort(arr, SimpleSort::insertSort);
    }

    @Test
    public void testbubbleSort() {
        for (int i = 0; i < 10; i++) {
            testSort(randomIntArr(100000), SimpleSort::bubbleSort);
        }
    }

    @Test
    public void testMergeSort() {
        for (int i = 0; i < 10; i++) {
            testSort(randomIntArr(100000), SimpleSort::mergeSort);
        }
    }

    @Test
    public void testQuickSort() {
        for (int i = 0; i < 10; i++) {
            testSort(randomIntArr(100000), SimpleSort::quickSort);
        }
    }

    private void testSort(Consumer<int[]> sort) {
        testSort(null, sort);
    }

    private void testSort(int[] arr, Consumer<int[]> sort) {
        if (arr == null) {
            arr = Arrays.copyOf(ints, ints.length);
        }
        int[] copy =  Arrays.copyOf(arr, arr.length);
        //            Assert.assertTrue("未排序", assertSortError(copy));
        sort.accept(copy);
        Assert.assertFalse("已排序", assertSortError(copy));
        print(copy);
    }

}
