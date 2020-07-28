package demo;

public class TextTest {
 
	/**
	 * 三、找到一个无序数组中找两个特定数，使其相加等于特定数字，请写代码java将它找出来，并指出时间复杂度。 例如
	 * 【10,25,19,89,75,56,34,54,16，9，-5】找到相加等于28的【19，9 】
	 */
	public static void main(String[] args) {
		 getSpacialNum(28);
	}
	
	public static  int  getSpacialNum(int  num) {
		int[] numArr = { 10, 25, 19, 89, 75, 56, 34, 54, 16, 9, -5 };
		for (int i = 0; i < numArr.length; i++) {
			for (int j =i+1; j < numArr.length; j++) {
				if(numArr[i]+numArr[j]==num) {
					System.out.println("获取到的俩个数字： "+numArr[i]+" , "+numArr[j]);
				}
			}
		}
		return 0;
	}
}