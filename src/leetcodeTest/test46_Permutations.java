package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test46_Permutations {
	public static List<List<Integer>> ans = new ArrayList<>();
	
	public static int[] path = new int[100]; // �ݴ�С��
	
	public static boolean[] v = new boolean[100];
	
	public static void robot(int idx, int nums[]) {
		if (idx >= nums.length) { // �ݹ��һ���Ǳ߽������ж�
			// ĳһ��������ɺ�����
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				temp.add(nums[path[i]]);
			}
			ans.add(temp);
			return; // �����ݹ飬������һ������Ϊ��ͷ���������
		}
		// ������ÿ������Ϊ����Ŀ�ͷ���ݹ�
		for (int i = 0; i < nums.length; i++) {
			if (v[i] == false) { // ĳ������δʹ��ʱ
				path[idx] = i; // path[0];
				v[i] = true; // �±����ʹ�ù�
				robot(idx + 1, nums); // path[1]; path[2]; ...
				v[i] = false; // �����ݹ�� �������
			}
		}
	}
	
    public List<List<Integer>> permute(int[] nums) {
    	ans.clear();
    	robot(0, nums);
        return ans;
    }
}
