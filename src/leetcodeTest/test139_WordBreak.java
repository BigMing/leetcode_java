package leetcodeTest;

import java.util.List;

public class test139_WordBreak {
	/**
	 * 定义A[i]表示0到下标为i的子字符能否被分割成dict中的多个单词。 
	 * 那么A[i]与A[j],0<=j< i都有关系，即A[i]与前A[]中的前i-1项都有关系，具体为：
	 * 如果A[0]为1，判断s中下标从1开始到i结束的字符是否在dict中，如果在，设置A[i]为1，跳出，否则进入第二步；
	 * 如果A[1]为1，判断s中下标从2开始到i结束的字符是否在dict中，如果在，设置A[i]为1，跳出，否则进入第二步； 
	 * …..
	 * 这样一直遍历到A[i-1]位置。
	 * 在上面的遍历过程中如果遍历到某一步j,A[j]=1并且j+1到i表示的字符串出现在dict中，
	 * 表示前j个字符串能分割成dict中的单词，j+1到i中的字符串串也能分割成dict中的单词，这样表示前i个字符能被分割成dict中的单词。
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		int length = s.length();
		boolean[] words = new boolean[length];

		for (int i = 1; i <= length; i++) {
			int j;
			for (j = 0; j < i; j++) {
				String substr = s.substring(j, i);
				if (wordDict.contains(substr) && (j == 0 || words[j - 1])) {
					words[i - 1] = true;
					break;
				}
			}
			if (j == i)
				words[i - 1] = false;
		}
		return words[length - 1];
	}
}
