package leetcodeTest;

public class test11_ContainerWithMostWater {
	/*
	 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
	 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
	 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
	 */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1; // 从左右开始的两个下标
        int res = 0; // 容量
        while (l < r) {
			res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
        return res;
    }
}
