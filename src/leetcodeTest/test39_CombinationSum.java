package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test39_CombinationSum {
	public static List<List<Integer>> ans = new ArrayList<>();
	public static int path[] = new int[100];
	public static int len = 0; // path�ĳ���
	
	public void robot(int idx, int[] c, int target) {
		if (target == 0) { // �����������������¼��
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < len; i++) {
				tmp.add(path[i]);
			}
			ans.add(tmp);
			return;
		}
		if (target < 0 || idx >= c.length) {
			return;
		}
		path[len] = c[idx];
		len++;
		robot(idx, c, target - c[idx]); // ʹ�õ�ǰidx���������滹�����������
		len--; // �����õݹ��ԭһ��
		robot(idx + 1, c, target); // ��ʹ�������������Ҳ�Ͳ����ˣ������������
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans.clear();
        robot(0, candidates, target);
        return ans;
    }
}
