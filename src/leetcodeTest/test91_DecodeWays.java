package leetcodeTest;

public class test91_DecodeWays {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		
		char[] sa = s.toCharArray();
		
		int[] nums = new int[sa.length + 1];
		
		nums[0] = 1;
		
		for (int i = 1; i <= sa.length; i++) {
			if (sa[i - 1] != '0') // 1λ
				nums[i] += nums[i - 1];
			if (i > 1 && sa[i - 2] == '1') // 2λ��10~19 
				nums[i] += nums[i - 2];
			if (i > 1 && sa[i - 2] == '2' && sa[i - 1] >= '0' && sa[i - 1] <= '6') // 20~26
				nums[i] += nums[i - 2];
		}
		return nums[sa.length];
	}
}
