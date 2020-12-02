package shortestpath;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    /**
     * 思路：
     * 利用广度优先从每个节点出发进行搜索。搜索到任意节点时，保存已经经历过的节点。
     * 已经经历过的节点不需要保存顺序，因为采用的是广度优选搜索，所以第一次搜索到此状态的路径一定是最短的。
     * 所有节点都搜完时，结束搜索
     */
    public int shortestPathLength(int[][] graph) {
        int len = graph.length;
        // 记录访问某个节点时，已经访问过的节点集合(状态)，每个bit表示一个节点
        // 由于采用的是广度优选搜索，所以走过已经访问过的节点的路径一定是最短的
        boolean[][] visited = new boolean[len][1 << len];
        // 记录正在搜索的中间状态
        // queue中的元素为有两个元素的数组：节点，访问此节点对应的状态
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {// 从每个节点出发搜索结果
            queue.add(new int[] {i, 1 << i});
        }
        int step = 0;
        int endState = (1 << len) - 1; //当所有节点都走到过之后便可以结束搜索
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] entry = queue.poll();
                int point = entry[0];
                int state = entry[1];
                for (int next : graph[point]) {
                    int nextState = state | (1 << next);
                    if (nextState == endState) {
                        return step + 1;
                    }
                    if (visited[next][nextState]) {
                        continue;
                    }
                    visited[next][nextState] = true;
                    queue.add(new int[] {next, nextState});
                }
            }
            step++;
        }
        return 0;//graph为空
    }

    /*******************UT********************/
    public static void main(String[] args) {
        Solution solution = new Solution();
        test2(solution);
        test1(solution);
    }

    private static void test2(Solution solution) {
        int result = solution.shortestPathLength(new int[][] {{1}, {0, 2, 4}, {1, 3, 4}, {2}, {1, 2}});
        int expected = 4;
        if (result != 4) {
            System.out.println("expected result:\n" + expected);
            System.out.println("         result:\n" + result);
            throw new RuntimeException("wrong result!");
        }
    }

    private static void test1(Solution solution) {
        int result = solution.shortestPathLength(new int[][] {{1, 2, 3}, {0}, {0}, {0}});
        int expected = 4;
        if (result != 4) {
            System.out.println("expected result:\n" + expected);
            System.out.println("         result:\n" + result);
            throw new RuntimeException("wrong result!");
        }
    }
}
