package leetcodeTest;

public class test239_SlidingWindowMaximum {
	/*
	 * Example:
	 * 
	 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3 Output: [3,3,5,5,6,7]
	 * Explanation:
	 * 
	 * Window position Max
	 * 
	 * [1 3 -1] -3 5 3 6 7 3
	 * 
	 * 1 [3 -1 -3] 5 3 6 7 3
	 * 
	 * 1 3 [-1 -3 5] 3 6 7 5
	 * 
	 * 1 3 -1 [-3 5 3] 6 7 5
	 * 
	 * 1 3 -1 -3 [5 3 6] 7 6
	 * 
	 * 1 3 -1 -3 5 [3 6 7] 7
	 */
	/*
	 * �����ж�����ĳ���len��k�Ĵ�С�����len<=k����ֻҪ�ҳ�����nums�������Ǹ�ֵ��ֱ�ӷ��ؾͿ����ˡ����len>k�Ļ���
	 * ����һ������data���䳤��Ϊlen-k+1��Ȼ�����ԭ����nums���±�0��ʼɨ�裬ɨ�赽��len-k+1��Ԫ��ֹͣ��ָ��ÿ��ָ��һ��Ԫ��ʱ��
	 * ���Ԫ���±�Ϊbegin�����Ĵ��ڵ����һ��Ԫ�ص��±�����Ϊend��Ȼ����[begin,end]���ҵ�����Ԫ�أ��Ѹ�Ԫ�ط���data[]���棬
	 * ÿ���ƶ�������������������󷵻�data��
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return new int[0]; // ֱ�ӷ���0��
		}
		int len = nums.length;
		int temp = Integer.MIN_VALUE;
		if (len <= k) { // �������ĳ���С�ڵ���k��ֻҪ�������������ֵ�ͺ�
			int[] data = new int[1];
			for (int i = 0; i < len; i++) {
				if (temp < nums[i]) {
					temp = nums[i];
				}
			}
			data[0] = temp;
			return data;
		} else { // ��len��ֵ����kʱ
			int[] data = new int[len - k + 1];
			for (int i = 0; i <= len - k + 1; i++) {
				temp = Integer.MIN_VALUE;
				int begin = i;
				int end = i + k;
				if (end <= len) {
					for (int j = begin; j < end; j++) {
						if (temp < nums[j]) {
							temp = nums[j];
						}
					}
					data[i] = temp;
				} else { // end > len
					i = len; // ����
				}

			}
			return data;
		}
	}
}
