package leetcodeTest;

public class test42_TrappingRainWater {
	/*
	 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
	 * compute how much water it is able to trap after raining.
	 */
	/*
	 * Example:Input: [0,1,0,2,1,0,1,3,2,1,2,1],Output: 6
	 */
	/*
	 * ������˼·�ǲ���l��r����ָ�룬ά��װˮ���ߵ�λ�á�
	 * ��l���߶ȵ�ʱ��˵��l�Ҳ�װ��ˮ�϶���l��һ���ߣ���ʱ������l��ͬʱ����l�������ƺ�λ�ø߶Ȳ��Ϊ���ﶼ��װˮ������ֱ��������ͬ���߻��߸��ߵ�λ�á�
	 * Ȼ�������һ���жϡ�
	 * ͬ������r���߶ȵ�ʱ��˵��r����ˮ�϶���r��һ���ߣ���ʱ������r��ͬ�Ǽ���r�������ƺ�λ�ø߶Ȳֱ��������ͬ���߻��߸��ߵ�λ�á�
	 * ���ֱ��l��r������������
	 */
    public int trap(int[] height) {
        int res = 0, l = 0, r = height.length - 1;
        while (l < r) {
			int minH = Math.min(height[l], height[r]);
			if (height[l] == minH) { // ��ߵ�
				while (++l < r && height[l] < minH) { // ����l
					res += minH - height[l];
				}
			} else { // ����r
				while (l < --r && height[r] < minH) {
					res += minH - height[r];
				}
			}
		}
        return res;
    }
}
