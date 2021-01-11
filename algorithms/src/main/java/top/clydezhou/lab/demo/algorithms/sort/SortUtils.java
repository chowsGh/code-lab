package top.clydezhou.lab.demo.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author clyde
 * @date 2020-11-03 22:54
 */
public class SortUtils {
    public static Random r = new Random(System.currentTimeMillis());

    /**
     * 交换数组中两个index的数
     *
     * @param arr
     * @param indexa
     * @param indexb
     */
    public static void swap(int[] arr, int indexa, int indexb) {
        int temp = arr[indexa];
        arr[indexa] = arr[indexb];
        arr[indexb] = temp;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 随机生成指定长度的数组
     *
     * @param count
     * @return
     */
    public static int[] randomIntArr(int count) {
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = r.nextInt();
        }
        return arr;
    }

    /**
     * 检查数组是否升序
     *
     * @param arr
     * @return
     */
    public static boolean assertSortError(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                String errorInfo = "index : " + (i + 1) + " not sort, arr:" + Arrays.toString(arr);
                System.out.println(errorInfo);
                return true;
            }
        }
        return false;
    }
}
