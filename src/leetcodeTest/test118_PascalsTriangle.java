package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test118_PascalsTriangle {
	/*
	 * Input: 5,Output: [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1]]
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows == 0) {
			return result;
		}
		for (int i = 0; i < numRows; i++) {
			List<Integer> eachRow = new ArrayList<>();
			eachRow.add(0, 1); // 每行第一个元素设为1
			for (int j = 1; j < i; j++) {
				if (i - 1 >= 0) {
					List<Integer> last = result.get(i - 1);
					int num = last.get(j - 1) + last.get(j);
					eachRow.add(j, num);
				}
			}
			if (i > 0)
				eachRow.add(i, 1); // 每一行的最后一个元素为1
			result.add(i, eachRow);
		}
		return result;
	}
}
