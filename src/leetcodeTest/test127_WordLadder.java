package leetcodeTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test127_WordLadder {
	/*
	 * Example 1:
	 * 
	 * Input: beginWord = "hit", endWord = "cog", wordList =
	 * ["hot","dot","dog","lot","log","cog"]
	 * 
	 * Output: 5
	 * 
	 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
	 * "dog" -> "cog", return its length 5. Example 2:
	 * 
	 * Input: beginWord = "hit" endWord = "cog" wordList =
	 * ["hot","dot","dog","lot","log"]
	 * 
	 * Output: 0
	 * 
	 * Explanation: The endWord "cog" is not in wordList, therefore no possible
	 * transformation.
	 * 
	 * https://www.jianshu.com/p/753bd585d57e
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		int dist = 1;
		while (!visited.contains(endWord)) {
			Set<String> temp = new HashSet<>();
			for (String word : visited) { // 每个word
				for (int i = 0; i < word.length(); i++) {
					char[] chars = word.toCharArray(); // 转为char[]
					for (int j = (int) 'a'; j < (int) 'z' + 1; j++) {
						chars[i] = (char) j; // 变第一个字母
						String newWord = new String(chars);
						if (wordSet.contains(newWord)) {
							temp.add(newWord);
							wordSet.remove(newWord);
						}
					}
				}
			} // BFS
			dist += 1;
			if (temp.size() == 0) { // it never get to the endWord
				return 0;
			}
			visited = temp;
		}
		return dist;
	}
}
