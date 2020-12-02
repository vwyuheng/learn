package dictory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *269. 火星词典
 *现有一种使用字母的全新语言，这门语言的字母顺序与英语顺序不同。
 *
 * 假设，您并不知道其中字母之间的先后顺序。但是，会收到词典中获得一个 不为空的 单词列表。因为是从词典中获得的，所以该单词列表内的单词已经 按这门新语言的字母顺序进行了排序。
 *
 * 您需要根据这个输入的列表，还原出此语言中已知的字母顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 * 输出: "wertf"
 * 示例 2：
 *
 * 输入:
 * [
 *   "z",
 *   "x"
 * ]
 * 输出: "zx"
 * 示例 3：
 *
 * 输入:
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 * 输出: "" 
 * 解释: 此顺序是非法的，因此返回 ""。
 *  
 *
 * 提示：
 *
 * 你可以默认输入的全部都是小写字母
 * 若给定的顺序是不合法的，则返回空字符串即可
 * 若存在多种可能的合法字母顺序，请返回其中任意一种顺序即可
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/alien-dictionary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public String alienOrder(String[] words) {
        // 提取边(整个题目的核心就在这里了，提取出来边以后剩下的就是拓扑排序的模板题了)
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            int len = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < len; j++) {
                if (words[i].charAt(j) == words[i + 1].charAt(j)) {
                    continue;
                }
                Set<Character> set = map.getOrDefault(words[i].charAt(j), new HashSet<>());
                set.add(words[i + 1].charAt(j));
                map.putIfAbsent(words[i].charAt(j), set);
                break;
            }
        }
        // 计算并保存节点的入度
        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1);
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree[c - 'a'] = 0;
            }
        }
        for (Character key : map.keySet()) {
            for (Character v : map.get(key)) {
                inDegree[v - 'a']++;
            }
        }
        // bfs
        StringBuilder builder = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0) {
                queue.add((char) (i + 'a'));
            }
            if (inDegree[i] != -1) {
                count++;
            }
        }
        while (!queue.isEmpty()) {
            Character node = queue.poll();
            builder.append(node);
            if (map.containsKey(node)) {
                for (Character nei : map.get(node)) {
                    inDegree[nei - 'a']--;
                    if (inDegree[nei - 'a'] == 0) {
                        queue.add(nei);
                    }
                }
            }
        }
        if (builder.length() != count) {
            return "";
        }
        return builder.toString();
    }
}
