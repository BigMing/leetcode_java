package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test77_Combinations {
	public static List<List<Integer>> ans = new ArrayList<List<Integer>>();
	public static int[] path = new int[100];
	public static int K = 0;
	/**
	 * @param idx [0, n) ���ѡ������+1����[1, n]n����
	 * @param n n����
	 * @param k ��n������ȡk��
	 */
	public void robot(int idx, int n, int k) {
		if (k == 0) { // ȡ��һ�������return
			List<Integer> tmp = new ArrayList<>();
			for (int i = 0; i < K; i++) {
				tmp.add(path[i]);
			}
			ans.add(tmp);
			return;
		} 
		for (int i = idx + 1; i <= n ; i++) { // [1, n]��n������+1
			path[k - 1] = i; // �±�-1; path[1]=1,
			robot(i, n, k - 1); // path[0]=2,path[0]=3,path[0]=4
		}
	}
	
    public List<List<Integer>> combine(int n, int k) {
        ans.clear();
        K = k;
        robot(0, n, k);
        return ans;
    }
}
