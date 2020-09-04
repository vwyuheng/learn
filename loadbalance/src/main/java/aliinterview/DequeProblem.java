package aliinterview;

import java.util.*;

/*问题描述：
 * 输入包含两行，第一行有两个整数N和M，N代表第二行的数字的数量，M代表一个子数组窗口的长度
 * 请打印输出在子数组窗口内，为不重复的数字最长数量
 * 比如输入为：
 * 6 5
 * 3 4 1 1 1 3
 * 可以得到4个子数组：{3 4 1}, {4 1 1}, {1 1 1}, {1 1 3}
 * 它们的不重复的数字的数量分别为 3, 2, 1, 2
 * 那么不重复的数字最长值为第一个子数组，打印3
 *
 *例如在 console 输入 6 4
 * */

public class DequeProblem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        // deque.addFirst(); deque.addLast(); deque.removeFirst(); deque.removeLast()
        // deque.size();

        //1参数校验
      /*if(args.length==0) {
        System.out.println(0);
      }*/

        // int n = Integer.parseInt(args[0]);
        //int m = Integer.parseInt(args[1]);

        int n = in.nextInt();
        int m = in.nextInt();

        if (m == n) {
            System.out.println(m);
        }
        //1 构造数组
        for (int i = 0; i < n; i++) {
            int num = new Random().nextInt(10);
            //开始实现，任何代码都可以修改
            deque.addLast(num);
            System.out.println("source:" + num);
        }


        //2. 找子数组
        List<int[]> subArray = new ArrayList();

        while (deque.size() >= m) {
            int[] arrayTmp = new int[m];
            for (int j = 0; j < m; j++) {
                Object[] objArray = deque.toArray();
                arrayTmp[j] = (int) objArray[j];
            }
            subArray.add(arrayTmp);
            deque.removeFirst();
        }

        //3.找出子数组重复元素个数并缓存起来
        List<Integer> sumArrayRepeatNum = new ArrayList<>();
        Set<Integer> setTmp = new HashSet<>(m);
        int u = 0;
        for (int[] suba :
                subArray) {
            u++;
            for (Integer ela :
                    suba) {
                System.out.println("suba" + u + ":" + ela);
                setTmp.add(ela);
            }
            sumArrayRepeatNum.add(setTmp.size());
        }

        //4.对子数组进行排序 从大到小
        Collections.reverse(sumArrayRepeatNum);

        for (Integer sizeNum :
                sumArrayRepeatNum) {
            System.out.println("sizeNum:" + sizeNum);
        }


    }
}