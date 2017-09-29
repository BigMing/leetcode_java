package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test78_Subsets {
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		dfs(res, temp, nums, 0);
		return res;
	}

	// ����������ȵݹ鷽��
	private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int j) {
		res.add(new ArrayList<Integer>(temp)); // �ȼ�����Ҳ�ǿ��Ե�
		for (int i = j; i < nums.length; i++) {
			temp.add(nums[i]); // �� ���� nums[i]
			dfs(res, temp, nums, i + 1); // �� �ݹ�
			temp.remove(temp.size() - 1); // �� �Ƴ� nums[i]
		}
	}
	
	// ���
	public List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		for (int num : nums) { // �ٴ�������ȡ��ÿ��Ԫ��
			int size = res.size(); // ǰ���ȼӸ���һ���յģ������Ǵ�1��ʼ
			for (int i = 0; i < size; i++) {
				List<Integer> temp = new ArrayList<>(res.get(i)); // ����һȡ���м�����
				temp.add(num); // �۽� num �����м�����
				res.add(temp); // �ܼ��뵽�������
			}
		}
		return res;
	}
}