package top.clydezhou.lab.demo.algorithms.queue;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author clyde
 * @date 2020-09-04 21:03
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        List<Integer> l = Arrays.asList(9,3,4,5,8,1);
        for (Integer i : l) {
            q.add(i);
            System.out.println(q.toString());
        }
        for (Integer integer : l) {
            q.poll();
            System.out.println(q.toString());
        }
    }
}
