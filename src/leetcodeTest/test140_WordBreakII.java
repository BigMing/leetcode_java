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
		if (from == s.length()) { // ��ֹ����
			StringBuilder sb = new StringBuilder();
			for (String current : currents) {
				if (sb.length() > 0)
					sb.append(" ");
				sb.append(current);
			}
			results.add(sb.toString());
			return;
		}
		for (int length : substrings[from]) { // substrings[i]���˶�����е�length
			currents.add(s.substring(from, from + length)); // ������еĵ��ʼ���
			find(s, substrings, from + length, currents, results);
			currents.remove(currents.size() - 1); // ɾ�����һ�����������
			// Removes the element at the specified position in this list
			// (optional operation).
		}
	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		Set<Integer> lengthSet = new HashSet<>();
		for (String word : wordDict) {
			lengthSet.add(word.length());
		} // lengthSet�з�������ʵĳ���
		int[] lengths = new int[lengthSet.size()];
		int l = 0;
		for (int length : lengthSet) {
			lengths[l++] = length;
		} // lengths������ʳ��ȣ����ظ�
		List<Integer>[] substrings = new List[s.length() + 1];
		substrings[0] = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			if (substrings[i] == null)
				continue;
			for (int j = 0; j < lengths.length; j++) {
				if (i + lengths[j] <= s.length() // ��ֹ��һ������Խ��
						&& wordDict.contains(s.substring(i, i + lengths[j]))) {
					substrings[i].add(lengths[j]);
					if (substrings[i + lengths[j]] == null) {
						substrings[i + lengths[j]] = new ArrayList<>();
					}
				}
			}
		} // substrings[i]���뵥�ʳ���
		List<String> results = new ArrayList<>();
		if (substrings[s.length()] == null)
			return results;
		find(s, substrings, 0, new ArrayList<>(), results); // DFS
		return results;
	}

	/**
	 * �ֵ�����DFS
	 */
	class TrieNode {
		boolean isWord; // �൱��֮ǰ�ֵ�����־�Ƿ���Ҷ�ڵ�
		TrieNode[] nexts = new TrieNode[26];

		TrieNode add(char ch) {
			int i = ch - 'a'; // ֻʵ����Сд��ĸ���ֵ�
			if (nexts[i] != null)
				return nexts[i];
			nexts[i] = new TrieNode();
			return nexts[i];
		}
	}

	private TrieNode root;

	private void find(char[] sa, int from, int[] split, int splits, List<String> words) {
		if (from == sa.length) { // ��ֹ����
			char[] word = new char[sa.length + splits - 1];
			int wordPos = 0, splitPos = 0;
			for (int i = 0; i < sa.length; i++) {
				if (i == split[splitPos]) { // һ�����ʽ���
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
			if (current == null) // û�ҵ�
				break;
			if (current.isWord) { // �ҵ���ƥ��ĵ���
				split[splits] = i + 1; // ��һ�Σ�split[0] = i + 1
				find(sa, i + 1, split, splits + 1, words); // ��i + 1��ʼ������
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
		} // ���ΰѵ��ʲ�����root
		
		char[] sa = s.toCharArray();
		boolean[] reachable = new boolean[sa.length + 1];
		reachable[0] = true;
		
		for (int i = 0; i < sa.length; i++) {
			if (!reachable[i])
				continue;
			TrieNode current = root;
			for (int j = i; j < sa.length && current != null; j++) {
				current = current.nexts[sa[j] - 'a']; // �����в���
				if (current != null && current.isWord)
					reachable[j + 1] = true; // ǰj + 1����ĸ�ҵ��˿���ƥ��ĵ���
			}
		}
		if (!reachable[sa.length])
			return results;
		find(sa, 0, new int[sa.length], 0, results);
		return results;
	}
}
