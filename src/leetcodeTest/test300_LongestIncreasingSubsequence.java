package leetcodeTest;

public class test300_LongestIncreasingSubsequence {
	public static int[] f = new int[10000];
	public static int[] p = new int[10000];
	public static int n;
	public static int robot(int idx, int[] nums) {
		if (idx < 0) {
			return 0;
		}
		if (f[idx] > 0) { // i计算过
			return f[idx];
		}
		int ans = 0;
		for (int i = 0; i < idx; i++) {
			if (nums[idx] > nums[i]) {
				ans = Math.max(ans, robot(i, nums));
			}
		}
		f[idx] = ans + 1;
		return ans + 1;
	}
	
    public int lengthOfLIS(int[] nums) {
    	for (int i = 0; i < 10000; i++) {
    		f[i] = 0;
    	}
    	for (int i = 0; i < nums.length; i++) {
    		p[i] = nums[i];
    	}
    	int n = nums.length;
    	p[n] = Integer.MAX_VALUE;
    	n++; // 尾部加一个最大值
    	// 改成非递归
    	int min[] = new int[10000];
    	int path = 0;
    	for (int i = 0; i < 10000; i++) {
    		min[i] = Integer.MAX_VALUE;
    	}
    	for (int idx = 0; idx < n; idx++) {
    		int ans = 0;
//    		for (int i = 0; i < idx; i++) {
//    			if (p[idx] > p[i]) {
//    				ans = Math.max(ans, f[i]);
//    			}
//    		}
//    		for (int i = 1; i <= path; i++) {
//    			if (p[idx] > min[i]) {
//    				ans = Math.max(ans, i);
//    			}
//    		}
    		int L = 1;
    		int R = path;
    		while (L <= R) {
    			int mid = (L + R) / 2;
    			if (min[mid] < p[idx]) {
    				ans = mid;
    				L = mid + 1;
    			} else {
    				R = mid - 1;
    			}
    		}
    		// [10,9,2,5,3,7,10]中，min[2] = 3 (2,3) 
    		f[idx] = ans + 1;
    		min[f[idx]] = Math.min(min[f[idx]], p[idx]); // min的下标是答案的长度，值是最后一个子序列最小是多少
    		path = Math.max(path, f[idx]); // 当前最大可能串的长度
    	}
        return f[n - 1] - 1;
//        return robot(n - 1, p) - 1;
    }
}
