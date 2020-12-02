package substr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法一：贪心算法 + 双指针
 * 思路与算法
 *
 * 由于同一个字母只能出现在同一个片段，显然同一个字母的第一次出现的下标位置和最后一次出现的下标位置必须出现在同一个片段。因此需要遍历字符串，得到每个字母最后一次出现的下标位置。
 *
 * 在得到每个字母最后一次出现的下标位置之后，可以使用贪心算法和双指针的方法将字符串划分为尽可能多的片段，具体做法如下。
 *
 * 从左到右遍历字符串，遍历的同时维护当前片段的开始下标 \textit{start}start 和结束下标 \textit{end}end，初始时 \textit{start}=\textit{end}=0start=end=0。
 *
 * 对于每个访问到的字母 cc，得到当前字母的最后一次出现的下标位置 \textit{end}_cend
 * c
 * ​
 *  ，则当前片段的结束下标一定不会小于 \textit{end}_cend
 * c
 * ​
 *  ，因此令 \textit{end}=\max(\textit{end},\textit{end}_c)end=max(end,end
 * c
 * ​
 *  )。
 *
 * 当访问到下标 \textit{end}end 时，当前片段访问结束，当前片段的下标范围是 [\textit{start},\textit{end}][start,end]，长度为 \textit{end}-\textit{start}+1end−start+1，将当前片段的长度添加到返回值，然后令 \textit{start}=\textit{end}+1start=end+1，继续寻找下一个片段。
 *
 * 重复上述过程，直到遍历完字符串。
 *
 * 上述做法使用贪心的思想寻找每个片段可能的最小结束下标，因此可以保证每个片段的长度一定是符合要求的最短长度，如果取更短的片段，则一定会出现同一个字母出现在多个片段中的情况。由于每次取的片段都是符合要求的最短的片段，因此得到的片段数也是最多的。
 *
 * 由于每个片段访问结束的标志是访问到下标 \textit{end}end，因此对于每个片段，可以保证当前片段中的每个字母都一定在当前片段中，不可能出现在其他片段，可以保证同一个字母只会出现在同一个片段。
 *
 *
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/partition-labels/solution/hua-fen-zi-mu-qu-jian-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SplitSubStr {


    /**
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
     *
     *  
     *
     * 示例：
     *
     * 输入：S = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     *  
     *
     * 提示：
     *
     * S的长度在[1, 500]之间。
     * S只包含小写字母 'a' 到 'z' 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-labels
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        for (int i = 0; i < S.length(); i++) {
            //找到每个字符在字符串中的最大位置
            map[S.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        while (idx < S.length()) {
            int curRight = map[S.charAt(idx) - 'a'];
            int i = idx;
            for (; i <= curRight; i++) {
                //找区间
                curRight = Math.max(curRight, map[S.charAt(i) - 'a']);
            }
            res.add(i - idx);
            idx = i;
        }
        return res;
    }



    public static void main(String[] args) {
        SplitSubStr splitSubStr = new SplitSubStr();

        String S = "ababcbacadefegdehijhklij";

        System.out.println(S.substring(0,splitSubStr.partitionLabels(S).get(0)));
        System.out.println(S.substring(splitSubStr.partitionLabels(S).get(0)+1,splitSubStr.partitionLabels(S).get(0)+splitSubStr.partitionLabels(S).get(1)));
        System.out.println(S.substring(splitSubStr.partitionLabels(S).get(0)+2,splitSubStr.partitionLabels(S).get(0)+splitSubStr.partitionLabels(S).get(1)+splitSubStr.partitionLabels(S).get(2)));
    }
}
