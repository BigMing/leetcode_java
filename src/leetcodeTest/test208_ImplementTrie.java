package leetcodeTest;

import java.util.HashMap;
import java.util.Map;

public class test208_ImplementTrie {
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
