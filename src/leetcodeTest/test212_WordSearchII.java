package leetcodeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class test212_WordSearchII {
	/*
	 * Given a 2D board and a list of words from the dictionary, find all words
	 * in the board.
	 * 
	 * Each word must be constructed from letters of sequentially adjacent cell,
	 * where "adjacent" cells are those horizontally or vertically neighboring.
	 * The same letter cell may not be used more than once in a word.
	 */
	public List<String> findWords(char[][] board, String[] words) {
		Set<String> res = new HashSet<String>();
		if (board == null || words == null || board.length == 0 || words.length == 0) {
			return new ArrayList<String>(res);
		}
		boolean[][] visited = new boolean[board.length][board[0].length];
		Trie trie = new Trie(); // 初始化一个前缀树
		for (String word : words) {
			trie.insert(word); // 把给出的word插入前缀树中方便搜索
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				search(board, visited, trie, i, j, new StringBuilder(), res);
			}
		}
		return new ArrayList<String>(res);
	}

	private void search(char[][] board, boolean[][] visited, Trie trie, int i, int j, StringBuilder sb,
			Set<String> res) {
		if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j])
			return;
		sb.append(board[i][j]);
		String s = sb.toString();
		visited[i][j] = true;
		if (trie.startsWith(s)) { // 如果前缀是s
			if (trie.search(s)) { // 如果是前缀树中找到了s，说明s是给出的word之一的时候，主要是加快搜索速度
				res.add(s); // 把s加入结果的list
			}
			// 再深度遍历
			search(board, visited, trie, i - 1, j, sb, res);
			search(board, visited, trie, i + 1, j, sb, res);
			search(board, visited, trie, i, j - 1, sb, res);
			search(board, visited, trie, i, j + 1, sb, res);
		}
		sb.deleteCharAt(sb.length() - 1);
		visited[i][j] = false; // 因为字符是课重用的，找完一个word后需要初始下
	}

	// 前缀树节点
	class TrieNode {
		char c;
		boolean leaf;
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

		public TrieNode(char c) {
			this.c = c;
		}

		public TrieNode() {
		}
	}

	// 前缀树
	class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			Map<Character, TrieNode> children = root.children;
			for (int i = 0; i < word.length(); i++) { // 遍历word的每个字符
				char c = word.charAt(i);
				TrieNode t;
				if (children.containsKey(c)) { // 看root节点是children是否有这个字符
					t = children.get(c);
				} else { // 如果有这个字符就把它对应的节点t取得，若没有则new一个值为该字符的节点放入children中
					t = new TrieNode(c);
					children.put(c, t);
				}
				children = t.children; // 向下一层遍历
				if (i == word.length() - 1) // word的长度就是树的层级数
					t.leaf = true;
			}
		}

		public boolean search(String word) {
			TrieNode t = searchNode(word);
			return t != null && t.leaf;
		}

		public boolean startsWith(String prefix) {
			return searchNode(prefix) != null;
		}

		private TrieNode searchNode(String word) {
			Map<Character, TrieNode> children = root.children;
			TrieNode t = null;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!children.containsKey(c))
					return null;
				t = children.get(c);
				children = t.children; // 向下一层搜
			}
			return t;
		}
	}
}
