package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test22_GenerateParentheses {
	/*
	 * For example, given n = 3, a solution set is:
	 * ["((()))","(()())","(())()","()(())","()()()"]
	 */
	/*
	 * 一般来说是用递归的方法，因为可以归结为子问题去操作。在每次递归函数中记录左括号和右括号的剩余数量，
	 * 然后有两种选择，一个是放一个左括号，另一种是放一个右括号。
	 * 需要特别注意的是剩余的右括号不能比左括号少，左括号右括号数量都要大于0。
	 */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        DFS(res, n, n, "");
        return res;
    }

	private void DFS(List<String> res, int left, int right, String path) {
		if (right < left) { // 一开始左右括号都有n个，右括号剩余数必须大于等于左括号剩余数
			return;
		}
		if (left == 0 && right == 0) { // 左括号用完
			res.add(path);
		}
		if (left > 0) { // 左括号还有剩余
			DFS(res, left - 1, right, path + "(");
		}
		if (right > 0) { // 右括号还有剩余
			DFS(res, left, right - 1, path + ")");
		}
	}
}
