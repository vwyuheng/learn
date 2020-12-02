package mergearrays;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] numstmp = new int[m+n];
        for(int i=0;i<m;i++) {
            numstmp[i]=nums1[i];
        }

        int index2 = 0;
        for(int j=Math.max(m,n);j<(m+n);j++ ) {

            numstmp[j]=nums2[index2++];
        }

       Arrays.sort(numstmp);
        for (int tmp:numstmp) {
            System.out.println(tmp);
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1={1,2,3,1};
        int m = 4;
        int [] nums2={2,5,6};
        int n =3;
        solution.merge(nums1,m,nums2,n);


    }
}
