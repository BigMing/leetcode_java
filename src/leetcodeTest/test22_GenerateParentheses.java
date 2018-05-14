package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test22_GenerateParentheses {
	/*
	 * For example, given n = 3, a solution set is:
	 * ["((()))","(()())","(())()","()(())","()()()"]
	 */
	/*
	 * һ����˵���õݹ�ķ�������Ϊ���Թ��Ϊ������ȥ��������ÿ�εݹ麯���м�¼�����ź������ŵ�ʣ��������
	 * Ȼ��������ѡ��һ���Ƿ�һ�������ţ���һ���Ƿ�һ�������š�
	 * ��Ҫ�ر�ע�����ʣ��������Ų��ܱ��������٣�������������������Ҫ����0��
	 */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        DFS(res, n, n, "");
        return res;
    }

	private void DFS(List<String> res, int left, int right, String path) {
		if (right < left) { // һ��ʼ�������Ŷ���n����������ʣ����������ڵ���������ʣ����
			return;
		}
		if (left == 0 && right == 0) { // ����������
			res.add(path);
		}
		if (left > 0) { // �����Ż���ʣ��
			DFS(res, left - 1, right, path + "(");
		}
		if (right > 0) { // �����Ż���ʣ��
			DFS(res, left, right - 1, path + ")");
		}
	}
}
