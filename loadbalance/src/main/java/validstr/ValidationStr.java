package validstr;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidationStr {

    static Map<Character,Character> map = null;

    static {
       map = new HashMap<Character,Character>() {
            {
                put('(',')');
                put('{','}');
                put('[',']');
            }
        };
    }

    public boolean isValid(String str) {

        if (str==null||str=="") {
            return true;
        }

        LinkedList<Character> stack = new LinkedList();
        for (int i=0;i<str.length();i++) {

            if (map.get(str.charAt(i))==null) {
                return  false;
            }

           for (Character c :str.toCharArray()) {
               if (map.containsKey(c)) {
                   stack.addLast(c);
               } else if(!map.get(stack.removeLast()) .equals(c)) {
                   return  false;
               }

           }

        }

        return stack.size()==1;
    }
}
