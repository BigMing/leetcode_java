package leetcodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test15_3Sum {
	/*
	 * Given array nums = [-1, 0, 1, 2, -1, -4],
	 * A solution set is: [[-1, 0, 1],[-1, -1, 2]]
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Set<Integer> set = new HashSet<Integer>();
		Arrays.sort(nums); // ����������
		for (int i = 0; i < nums.length - 2; i++) {
			if (!set.add(nums[i])) // ����set��������ظ�������
				continue; // ��һ��ʹ�ñ�����ÿ��nums[i]���ǲ�ͬ��
			if (nums[i] > 0) // ���nums[i]����0����û�����жϵı�Ҫ��
				break; // ��Ϊ�Ѿ����������ˣ������������󣬲������ٳ��ֺ�Ϊ0
			int head = i + 1;
			int tail = nums.length - 1;
			int last = nums[head]; // ��¼last�����ظ�
			while (head < tail) {
				if (head != i + 1 && nums[head] == last) {
					head++;
					continue;
				}
				int sum = nums[i] + nums[head] + nums[tail]; // ȡi,head,tail������
				if (sum > 0)
					tail--;
				else if (sum < 0) {
					last = nums[head];
					head++;
				} else { // sum == 0ʱ
					List<Integer> arrayList = new ArrayList<Integer>();
					arrayList.add(nums[i]);
					arrayList.add(nums[head]);
					arrayList.add(nums[tail]);
					ans.add(arrayList);
					last = nums[head];
					head++;
					tail--;
				}
			}
		}
		return ans;
	}
}
