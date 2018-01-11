package leetcodeTest;

public class test70_ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}else if (n == 2) {
			return 2;
		}
        
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        
        for (int i = 2; i < n; i++) {
        	res[i] = res[i - 1] + res[i - 2];
        }
        
        return res[n - 1];
    }
}
