package leetcodeTest;

public class test287_FindtheDuplicateNumber {
	/*
	 * Given an array nums containing n + 1 integers where each integer is
	 * between 1 and n (inclusive), prove that at least one duplicate number
	 * must exist. Assume that there is only one duplicate number, find the
	 * duplicate one.
	 * 
	 * Example 1:
	 * 
	 * Input: [1,3,4,2,2] Output: 2 Example 2:
	 * 
	 * Input: [3,1,3,4,2] Output: 3
	 */
	/*
	 * ���ƣ�
	 * 
	 * �����޸�����
	 * 
	 * �ռ临�Ӷ�O(1)
	 * 
	 * ʱ�临�Ӷ�С��O(n^2)
	 */
	/*
	 * ���ճ���ԭ���������������С�ڵ���n/2��������������n/2��˵��1��n/2��������ǿ϶����ظ����ֵġ�����6�����룬�����7������Ҫ�ŵ�������
	 * ���ǿ϶���һ�����������������ӡ�����������1��n/2��ÿһ�����������Ӿ�������������С�ڵ���n/2����Щ�����������Ǿ���֪���´�ѡ������ķ�Χ��
	 * ���1��n/2�����ڿ϶����ظ����֣����´���1��n/2��Χ���ң�������n/2��n��Χ���ҡ��´��ҵ�ʱ�򣬻�����һ�롣
	 */
	public int findDuplicate(int[] nums) {
		int min = 0, max = nums.length - 1;
		while (min <= max) {
			int mid = min + (max - min) / 2;
			int count = 0; // �������������ж���С�ڵ����м���
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= mid) {
					count++;
				}
			}
			if (count > mid) { // С�ڵ����м����ĸ���>�м���
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return min;
	}

	/*
	 * ����������û���ظ��������ǿ���������ôһ�㣬���ǽ�������±��1��nÿһ����һ��һ��ӳ������������������213,��ӳ���ϵΪ0->2, 1->1,
	 * 2->3���������һ��һӳ���ϵ��һ������f(n)������n���±꣬f(n)��ӳ�䵽������������Ǵ��±�Ϊ0����������������������һ��ֵ��
	 * �����ֵΪ�µ��±꣬��������������㣬�Դ����ƣ�ֱ���±곬�硣ʵ���Ͽ��Բ���һ����������һ�������С�����������������������±�����У�0->2->
	 * 3��
	 * 
	 * ��������ظ��Ļ������м�ͻ�������һ��ӳ�䣬��������2131,��ӳ���ϵΪ0->2, {1��3}->1,
	 * 2->3���������������ݵ����о�һ�����л�·�ˣ������±��������0->2->3->1->1->1->1->...���������������ظ�������
	 */
	public int findDuplicate1(int[] nums) {
		int slow = 0;
		int fast = 0;
		do {
			slow = nums[slow]; // ��һ��
			fast = nums[nums[fast]]; // ������
		} while (slow != fast); // δ�ظ�ʱ
		int find = 0;
		while (find != slow) {
			slow = nums[slow];
			find = nums[find];
		}
		return find;
	}
}
