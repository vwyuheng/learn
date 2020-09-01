package arra;

public class RemoveArrayElement {


    public int removeElement(int[] nums, int val) {


        int[] ret = new int[nums.length] ;

        if(nums.length!=0) {

            int j=0;
            for(int i=0;i<nums.length;i++) {
                if (nums[i]!=val) {  //只移动不相等的即可
                    ret[j]=nums[i];
                    j++;
                }

            }

            System.out.println("ret:"+ret.length);
            return j;
        }

        return 0;
    }


    public static void main(String[] args) {
        RemoveArrayElement removeArrayElement = new RemoveArrayElement();

        int[] nums = {0,1,2,2,3,0,4,2};

        System.out.println(removeArrayElement.removeElement(nums,2));
    }
}
