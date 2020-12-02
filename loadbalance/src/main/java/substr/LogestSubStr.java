package substr;

import java.util.LinkedList;
import java.util.Queue;

public class LogestSubStr {


    public int theLogestSubStr(String str) {

        int result = 0;
        if (str==""||str==null) {
            return result;
        }
        Queue<Character> queue = new LinkedList<>();
        for (char c:str.toCharArray())  {
            while (queue.contains(c)) {
                queue.poll();
            }
            queue.add(c);

            /**
             * math max非常关键
             */
            result = Math.max(result,queue.size());
        }
        return  result;
    }


    public static void main(String[] args) {
        String str = "abcabcbb";
        LogestSubStr subStr = new LogestSubStr();
        System.out.println(subStr.theLogestSubStr(str));



    }
}
