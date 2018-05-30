package leetcodeTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test140_WordBreakII {
	/*
	 * Example 1:
	 * 
	 * Input: s = "catsanddog" wordDict = ["cat", "cats", "and", "sand", "dog"]
	 * Output: [ "cats and dog", "cat sand dog" ] Example 2:
	 * 
	 * Input: s = "pineapplepenapple" wordDict = ["apple", "pen", "applepen",
	 * "pine", "pineapple"] Output: [ "pine apple pen apple",
	 * "pineapple pen apple", "pine applepen apple" ] Explanation: Note that you
	 * are allowed to reuse a dictionary word. Example 3:
	 * 
	 * Input: s = "catsandog" wordDict = ["cats", "dog", "sand", "and", "cat"]
	 * Output: []
	 */
	private void find(String s, List<Integer>[] substrings, int from, List<String> currents, List<String> results) {
		if (from == s.length()) { // 终止条件
			StringBuilder sb = new StringBuilder();
			for (String current : currents) {
				if (sb.length() > 0)
					sb.append(" ");
				sb.append(current);
			}
			results.add(sb.toString());
			return;
		}
		for (int length : substrings[from]) { // substrings[i]存了多个可行的length
			currents.add(s.substring(from, from + length)); // 存入可行的单词集合
			find(s, substrings, from + length, currents, results);
			currents.remove(currents.size() - 1); // 删掉最后一个，深度优先
			// Removes the element at the specified position in this list
			// (optional operation).
		}
	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		Set<Integer> lengthSet = new HashSet<>();
		for (String word : wordDict) {
			lengthSet.add(word.length());
		} // lengthSet中放入个单词的长度
		int[] lengths = new int[lengthSet.size()];
		int l = 0;
		for (int length : lengthSet) {
			lengths[l++] = length;
		} // lengths存个单词长度，无重复
		List<Integer>[] substrings = new List[s.length() + 1];
		substrings[0] = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			if (substrings[i] == null)
				continue;
			for (int j = 0; j < lengths.length; j++) {
				if (i + lengths[j] <= s.length() // 防止下一个条件越界
						&& wordDict.contains(s.substring(i, i + lengths[j]))) {
					substrings[i].add(lengths[j]);
					if (substrings[i + lengths[j]] == null) {
						substrings[i + lengths[j]] = new ArrayList<>();
					}
				}
			}
		} // substrings[i]放入单词长度
		List<String> results = new ArrayList<>();
		if (substrings[s.length()] == null)
			return results;
		find(s, substrings, 0, new ArrayList<>(), results); // DFS
		return results;
	}

	/**
	 * 字典树加DFS
	 */
	class TrieNode {
		boolean isWord; // 相当于之前字典树标志是否是叶节点
		TrieNode[] nexts = new TrieNode[26];

		TrieNode add(char ch) {
			int i = ch - 'a'; // 只实现了小写字母的字典
			if (nexts[i] != null)
				return nexts[i];
			nexts[i] = new TrieNode();
			return nexts[i];
		}
	}

	private TrieNode root;

	private void find(char[] sa, int from, int[] split, int splits, List<String> words) {
		if (from == sa.length) { // 终止条件
			char[] word = new char[sa.length + splits - 1];
			int wordPos = 0, splitPos = 0;
			for (int i = 0; i < sa.length; i++) {
				if (i == split[splitPos]) { // 一个单词结束
					word[wordPos++] = ' ';
					splitPos++;
				}
				word[wordPos++] = sa[i];
			}
			words.add(new String(word));
			return;
		}
		TrieNode current = root;
		for (int i = from; i < sa.length; i++) {
			current = current.nexts[sa[i] - 'a'];
			if (current == null) // 没找到
				break;
			if (current.isWord) { // 找到了匹配的单词
				split[splits] = i + 1; // 第一次：split[0] = i + 1
				find(sa, i + 1, split, splits + 1, words); // 从i + 1开始继续找
			}
		}
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> results = new ArrayList<>();
		if (s == null || wordDict == null)
			return results;
		root = new TrieNode();
		for (String word : wordDict) {
			char[] wa = word.toCharArray();
			TrieNode current = root;
			for (int i = 0; i < wa.length; i++)
				current = current.add(wa[i]);
			current.isWord = true;
		} // 依次把单词插入树root
		
		char[] sa = s.toCharArray();
		boolean[] reachable = new boolean[sa.length + 1];
		reachable[0] = true;
		
		for (int i = 0; i < sa.length; i++) {
			if (!reachable[i])
				continue;
			TrieNode current = root;
			for (int j = i; j < sa.length && current != null; j++) {
				current = current.nexts[sa[j] - 'a']; // 在树中查找
				if (current != null && current.isWord)
					reachable[j + 1] = true; // 前j + 1个字母找到了可以匹配的单词
			}
		}
		if (!reachable[sa.length])
			return results;
		find(sa, 0, new int[sa.length], 0, results);
		return results;
	}
}
