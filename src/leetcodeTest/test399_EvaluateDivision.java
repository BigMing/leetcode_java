package leetcodeTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class test399_EvaluateDivision {
	Map<String, Map<String, Double>> map = new HashMap<>();// �ڽӱ�
	public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
		Set<String> set = new HashSet<String>();// ��¼���ʽ�г��ֵ��ַ�����ʹ��set���Բ��ظ�
		for (int i = 0; i < equations.length; i++) {// ��ͼ
			set.add(equations[i][0]);
			set.add(equations[i][1]);
			Map<String, Double> m;
			if (map.containsKey(equations[i][0])) {
				m = map.get(equations[i][0]);
			} else {
				m = new HashMap<String, Double>();
			}
			m.put(equations[i][1], values[i]);
			map.put(equations[i][0], m);
			if (map.containsKey(equations[i][1])) {
				m = map.get(equations[i][1]);
			} else {
				m = new HashMap<String, Double>();
			}
			m.put(equations[i][0], 1.0 / values[i]);
			map.put(equations[i][1], m);
		} // ˫��س�ʼ��ͼ
		double result[] = new double[query.length];
		for (int i = 0; i < query.length; i++) {
			Iterator<String> it = set.iterator();
			Map<String, Boolean> visited = new HashMap<String, Boolean>();
			while (it.hasNext()) {
				visited.put(it.next(), false);
			} // ��ʼ��visited��ǣ�ÿһ��query����ʼ��һ��
			if (query[i][0].equals(query[i][1]) && set.contains(query[i][0])) {
				result[i] = 1;
				continue;
			}
			double res = dfs(query[i][0], query[i][1], 1, visited);
			result[i] = res;
		}
		return result;
	}

	public double dfs(String s, String t, double res, Map<String, Boolean> visited) {
		if (map.containsKey(s) && !visited.get(s)) {
			visited.put(s, true); // s��ѯ����
			Map<String, Double> m = map.get(s);
			if (m.containsKey(t)) { // t����sֱ���������
				return res * m.get(t);
			} else {
				Iterator<String> keys = m.keySet().iterator();
				while (keys.hasNext()) { // ������s��صĽڵ�
					String key = keys.next();
					double state = dfs(key, t, res * m.get(key), visited);
					if (state != -1.0) {
						return state;
					}
				}
			}
		} else {
			return -1.0;
		}
		return -1.0;
	}
}
