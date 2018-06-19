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
		Trie trie = new Trie(); // ��ʼ��һ��ǰ׺��
		for (String word : words) {
			trie.insert(word); // �Ѹ�����word����ǰ׺���з�������
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
		if (trie.startsWith(s)) { // ���ǰ׺��s
			if (trie.search(s)) { // �����ǰ׺�����ҵ���s��˵��s�Ǹ�����word֮һ��ʱ����Ҫ�Ǽӿ������ٶ�
				res.add(s); // ��s��������list
			}
			// ����ȱ���
			search(board, visited, trie, i - 1, j, sb, res);
			search(board, visited, trie, i + 1, j, sb, res);
			search(board, visited, trie, i, j - 1, sb, res);
			search(board, visited, trie, i, j + 1, sb, res);
		}
		sb.deleteCharAt(sb.length() - 1);
		visited[i][j] = false; // ��Ϊ�ַ��ǿ����õģ�����һ��word����Ҫ��ʼ��
	}

	// ǰ׺���ڵ�
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

	// ǰ׺��
	class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			Map<Character, TrieNode> children = root.children;
			for (int i = 0; i < word.length(); i++) { // ����word��ÿ���ַ�
				char c = word.charAt(i);
				TrieNode t;
				if (children.containsKey(c)) { // ��root�ڵ���children�Ƿ�������ַ�
					t = children.get(c);
				} else { // ���������ַ��Ͱ�����Ӧ�Ľڵ�tȡ�ã���û����newһ��ֵΪ���ַ��Ľڵ����children��
					t = new TrieNode(c);
					children.put(c, t);
				}
				children = t.children; // ����һ�����
				if (i == word.length() - 1) // word�ĳ��Ⱦ������Ĳ㼶��
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
				children = t.children; // ����һ����
			}
			return t;
		}
	}
}
