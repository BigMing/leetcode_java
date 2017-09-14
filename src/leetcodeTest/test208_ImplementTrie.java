package leetcodeTest;

import java.util.HashMap;
import java.util.Map;

public class test208_ImplementTrie {
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
