package leetcodeTest;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class test297_SerializeandDeserializeBinaryTree {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private final String delimiter = ","; // �ָ���
	private final String emptyNode = "#"; // �սڵ�

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder(); // StringBuilder����append
		serialize(root, sb);
		return sb.toString();
	}

	private void serialize(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append(emptyNode).append(delimiter);
		} else { // ǰ�����
			sb.append(root.val).append(delimiter);
			serialize(root.left, sb);
			serialize(root.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Deque<String> nodes = new LinkedList<>(); // ˫�˶���
		nodes.addAll(Arrays.asList(data.split(delimiter)));
		return deserialize(nodes);
	}

	private TreeNode deserialize(Deque<String> nodes) {
		String nodeVal = nodes.pollFirst(); // �Ƚ��ȳ�
		if (nodeVal.equals(emptyNode)) {
			return null;
		} else { // ���յĽڵ�
			TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
			node.left = deserialize(nodes);
			node.right = deserialize(nodes);
			return node;
		}
	}
}
