package top.clydezhou.lab.demo.algorithms.sort;

import static top.clydezhou.lab.demo.algorithms.sort.SortUtils.swap;

/**
 * @author clyde
 * @date 2020-11-04 23:01
 */
public class SimpleSort {

    /**
     * 冒泡排序 时间复杂度 n^2
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 选择排序，时间复杂度 n^2
     * 从第一个开始，找当前最小的数字
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int leastIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < temp) {
                    leastIndex = j;
                    temp = arr[j];
                }
            }
            if (leastIndex != i) {
                swap(arr, leastIndex, i);
            }
        }
    }

    /**
     * 插入排序
     * 先排序前两个，从第三个开始，向前插入。在找到第一个大于数的位置，从这个位置的数，向后移动，最后将当前待插入的数字放到这个位置
     * 当数组大部分是排序好的，则性能会很好，如果全部是排序好的，那性能最好
     *
     * @param a
     */
    public static void insertSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        for (int i = 1; i <= a.length - 1; i++) {
            int current = a[i];
            for (int j = i - 1; j >= 0; j--) {
                // 前一位大于 current 则前后交换
                if (a[j] > current) {
                    swap(a, j, j + 1);
                } else {
                    break;
                }
            }
        }

        // java.util.DualPivotQuicksort.sort(int[], int, int, int[], int, int) 里数组规模小于47使用插入排序
        //        for (int i = left, j = i; i < right; j = ++i) {
        //            int ai = a[i + 1];
        //            while (ai < a[j]) {
        //                a[j + 1] = a[j];
        //                if (j-- == left) {
        //                    break;
        //                }
        //            }
        //            a[j + 1] = ai;
        //        }
    }

    /**
     * 归并排序 时间复杂度：nlogn，空间复杂度 n
     * 使用分治的思想，将整体数组的排序分解成小数组的排序
     * java.util.Arrays#legacyMergeSort(java.lang.Object[])
     * java.util.Arrays#mergeSort(java.lang.Object[], java.lang.Object[], int, int, int)
     * java.util.TimSort#sort(java.lang.Object[], int, int, java.util.Comparator, java.lang.Object[], int, int)
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        int[] copyArr = arr.clone();
        mergeSort(copyArr, arr, 0, arr.length);
    }

    /**
     * 执行归并排序
     * 1. 递归终结条件，high - low 为 6 的时候，使用插入排序进行排序
     * 2. 取中间节点 mid
     * 3. 递归排序左边数组
     * 4. 递归排序右边数组
     * 5. 将左右数组进行合并到目标数组
     *
     * @param src  原数组
     * @param dest 目标数组
     * @param low  目标数组需要排序的第一个索引
     * @param high 目标数组结束索引，不需要参与排序
     */
    private static void mergeSort(int[] src, int[] dest, int low, int high) {
        int length = high - low;
        // Insertion sort on smallest arrays
        if (length <= 6) {
            for (int i = low; i < high; i++) {
                for (int j = i; j > low && dest[j - 1] > dest[j]; j--) {
                    swap(dest, j, j - 1);
                }
            }
            return;
        }

        // Recursively sort halves of dest into src
        int destLow = low;
        int destHigh = high;
        int mid = (low + high) >>> 1;
        mergeSort(dest, src, low, mid);
        mergeSort(dest, src, mid, high);

        // 如果左边最大的值，小于等于右边最小值，则直接复制就可以了
        // If list is already sorted, just copy from src to dest.  This is an
        // optimization that results in faster sorts for nearly ordered lists.
        if (src[mid - 1] <= src[mid]) {
            System.arraycopy(src, low, dest, destLow, length);
            return;
        }
        // 将左右数组进行合并到目标数组
        // Merge sorted halves (now in src) into dest
        for (int i = destLow, p = low, q = mid; i < destHigh; i++) {
            if (q >= high || p < mid && src[p] <= src[q]) {
                dest[i] = src[p++];
            } else {
                dest[i] = src[q++];
            }
        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (high <= low) {
            return;
        }
        int pivote = quickSortPartition(nums, low, high);
        quickSort(nums, low, pivote - 1);
        quickSort(nums, pivote + 1, high);
    }

    private static int quickSortPartition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];//取基准值
        int pivoteIndex = startIndex;//Mark初始化为起始下标

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                //小于基准值 则mark+1，并交换位置。
                pivoteIndex++;
                swap(arr, pivoteIndex, i);
            }
        }
        //基准值与mark对应元素调换位置
        swap(arr, startIndex, pivoteIndex);
        return pivoteIndex;
    }



}
