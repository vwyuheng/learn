package ksortbignum;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 一个乱序数组，求第K大的数。排序方式使用字典序。
 */
public class kTopNum {

    public static int topK3(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            q.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < q.peek()) {
                q.poll();
                q.add(arr[i]);
            }
        }
        return q.peek();

    }


    public static void main(String[] args) {

    }
}
