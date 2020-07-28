package demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * 三、找到一个无序数组中找两个特定数，使其相加等于特定数字，请写代码java将它找出来，并指出时间复杂度。 例如
 * 【10,25,19,89,75,56,34,54,16，9，-5】找到相加等于28的【19，9 】
 */
public class TwoSum {
     //最low的方法
     public int[] twoSum(int[] nums, int target) {
         int[] ret = new int[2];
         for (int i = 0; i < nums.length; i++) {
             for (int j = i + 1; j < nums.length; j++) {
                 if (nums[i] + nums[j] == target) {
                     ret[0] = i + 1;
                     ret[1] = j + 1;
                 }
             }
         }
         return ret;
 
     }
 
     // 利用map,只需要遍历一次即可
     public int[] twoSum1(int[] numbers, int target) {
         int[] ret = new int[2];    //初始化一个数组，默认值为0
         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
         for (int i = 0; i < numbers.length; i++) {
             if (map.containsKey(target - numbers[i])) {
                 ret[1] = i + 1; //map中放的数字必然是比较早遍历过的
                 ret[0] = map.get(target - numbers[i]);
                 return ret;
             }
             map.put(numbers[i], i + 1);
         }
         return ret;
     }
 
     //测试
     public static void main(String[] args) {
         //int[] numbers = { 2, 7, 11, 15 };
         //int target = 9;

         int[] numbers = { 10,25,19,89,75,56,34,54,16,9,-5 };
         int target = 28;
         TwoSum test = new TwoSum();
         int[] result = test.twoSum2(numbers, target);
         System.out.println(Arrays.toString(result));
     }



    public int[] twoSum2(int[] nums, int target) {
        int[] ret = new int[2];

        Map<Integer,Integer> mapNums = new HashMap<Integer,Integer>();

        int cnt = 0;
        for(int i=0;i<nums.length;i++) {

            if(mapNums.get(target-nums[i])!=null) {
                ret[0] = mapNums.get(target-nums[i]);
                ret[1] = i;

            }
            mapNums.put(nums[i],i);
        }
        return ret;
    }

 }