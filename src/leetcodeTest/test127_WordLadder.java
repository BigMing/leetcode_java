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
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordSet = new HashSet<>(wordList);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		int dist = 1;
		while (!visited.contains(endWord)) { // 访问过的不含endword
			Set<String> temp = new HashSet<>();
			for (String word : visited) { // 遍历每个访问过的word
				for (int i = 0; i < word.length(); i++) { // 每个字母
					char[] chars = word.toCharArray(); // 转为char[]
					for (int j = (int) 'a'; j < (int) 'z' + 1; j++) {
						chars[i] = (char) j; // 变一个字母
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
