package leetcodeTest;

public class test41_FirstMissingPositive {
	/*
	 * Example 1:Input: [1,2,0],Output: 3 Example 2:Input: [3,4,-1,1],Output: 2
	 * Example 3:Input: [7,8,9,11,12],Output: 1
	 */
	/*
	 * ˼·����������Ԫ�أ�ʹ�������е�iλ�����ֵ(i+1)�����������飬Ѱ�ҵ�һ�������ϴ�Ҫ���Ԫ�أ��������±ꡣ
	 * ����������Ҫ�����������飬���Ӷ�ΪO(n)��
	 */
	public static int firstMissingPositive(int[] nums) {
		if (nums.length == 0)
			return 1;
		// ��iλ���i+1����ֵ
		// 3�� 4�� -1�� 1
		// 1, 4, -1, 3
		// 1, 4, 3, -1
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) { // nums[i]Ϊ����
				// ������������ݻ��Ǵ���0��<i+1������ں��ʵ�λ�ã������ݲ���ȣ�������ѭ��
				// ���while�ǹؼ�����������û���Ѷȵģ���ν���λ��
				while (nums[i] > 0 && nums[i] < i + 1 && nums[i] != nums[nums[i] - 1]) { // �뽫Ҫ�������������
//					System.out.println(nums[i] + ":" + i);
					int temp = nums[nums[i] - 1]; // ��������
					nums[nums[i] - 1] = nums[i];
					nums[i] = temp;
				}
			}
		}
		// ѭ��Ѱ�Ҳ�����Ҫ������ݣ�����
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		// ���������Ҫ���򷵻س���+1��ֵ
		return nums.length + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, -1, 1 };
		System.out.println(firstMissingPositive(nums));
	}
}
