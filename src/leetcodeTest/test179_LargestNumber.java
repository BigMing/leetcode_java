package leetcodeTest;

import java.util.Arrays;
import java.util.Comparator;

public class test179_LargestNumber {
	/*
	 * Given a list of non negative integers, arrange them such that they form
	 * the largest number.
	 * 
	 * Example 1:
	 * 
	 * Input: [10,2] Output: "210" Example 2:
	 * 
	 * Input: [3,30,34,5,9] Output: "9534330"
	 */
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		String[] s_num = new String[nums.length];
		for (int i = 0; i < nums.length; i++) { // 把nums中所有数放入string数组
			s_num[i] = String.valueOf(nums[i]);
		}
		Comparator<String> comp = new Comparator<String>() {
			public int compare(String str1, String str2) {
				String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1);
			}
		};
		Arrays.sort(s_num, comp); // 用自定义的比较器排序
		if (s_num[0].charAt(0) == '0') {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (String s : s_num)
			sb.append(s);
		return sb.toString();
	}
}
