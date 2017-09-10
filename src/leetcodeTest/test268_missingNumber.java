package leetcodeTest;

public class test268_missingNumber {
    public int missingNumber(int[] nums) {
    	int sum = 0, n = nums.length;
        for (int i = 0; i < n; i ++) {
            sum += nums[i];
        }
        return n * (n + 1) / 2 - sum;
    }

	public static void main(String[] args) {
		
	}

}
