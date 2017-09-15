package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test315_CountofSmallerNumbersAfterSelf {
	/**
	 * ��ټ�����ʱ�临�Ӷ�O(n^2)����ʱ���޷�ͨ����
	 * 
	 * @param nums
	 * @return
	 */
	public List<Integer> countSmaller1(int[] nums) {
		int[] smaller = new int[nums.length];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j])
					smaller[i]++;
			}
		}
		List<Integer> results = new ArrayList<>(smaller.length);
		for (int i = 0; i < smaller.length; i++)
			results.add(smaller[i]);
		return results;
	}
	
	// ʹ��BST����ͳ�ơ�ʱ�临�Ӷ�O(nlogn)��
	class TreeNode {
		int val;
		int size; // ��ǰ�ڵ�Ϊ��ʱ�����Ĵ�С���ڵ������
		TreeNode left, right;
		TreeNode(int val) {
			this.val = val;
		}
	}

	// ����BST�бȴ����valС�Ľڵ�ĸ�����ͬʱҲ�ǲ���val��BST��
	private int smaller(TreeNode current, int val) {
		current.size++; // �൱�ڲ���ڵ�
		if (current.val < val) { // �����val���ڣ������ڵ�ʱ
			if (current.right == null) // ������ӽڵ���null�Ͳ����Ϊ���ӽڵ�
				current.right = new TreeNode(val);
			// BST���ԣ�-1�Ǽ�ȥval�ڵ㱾�����������Ǳ�valС��
			return current.size - 1 - current.right.size + smaller(current.right, val);
		} else if (current.val > val) { // �����valС�ڣ������ڵ�ʱ
			if (current.left == null) // ����������ڵ���������ǿգ��Ͳ���val��Ϊ�����ӽڵ�
				current.left = new TreeNode(val);
			return smaller(current.left, val); // ���������������б�valС�ĸ���
		} else { // �����val == �������ڵ��ֵ
			// ���������ڵ��������Ϊ�գ���Ȼû�б�valС����������0����Ϊ��Ҫ�������������Ĵ�С���Ǳ�valС�ĸ���
			return current.left == null ? 0 : current.left.size;
		}
	}

	public List<Integer> countSmaller2(int[] nums) {
		List<Integer> result = new ArrayList<>(nums.length);
		int[] smaller = new int[nums.length];
		if (nums == null || nums.length == 0)
			return result;
		TreeNode root = new TreeNode(nums[nums.length - 1]);
		for (int i = nums.length - 1; i >= 0; i--) {
			smaller[i] = smaller(root, nums[i]);
		}
		for (int i = 0; i < smaller.length; i++)
			result.add(smaller[i]);
		return result;
	}
	
	// �ֶ���
	class Node {
		int min, max;
		int count;
		Node left, right;
		Node(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

	// ����val�����ر�valС��������
	private int smaller(Node node, int val) {
		node.count++; // ����ڵ�
		if (node.min == node.max)
			return 0;
		int m = (node.min + node.max) / 2;
		if (m < val) { // �����val����ֵ������������
			if (node.right == null)
				node.right = new Node(m + 1, node.max);
			return node.count - 1 - node.right.count + smaller(node.right, val);
		} else if (m > val) { // �����val����ֵС������������
			if (node.min == m)
				return 0;
			if (node.left == null)
				node.left = new Node(node.min, m - 1);
			return smaller(node.left, val);
		} else { // val == m
			if (node.left == null)
				return 0;
			return node.left.count;
		}
	}

	public List<Integer> countSmaller(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		// ��÷ֶ������ڵ�����ұ߽�ֵ������ʼ�����ڵ�
		Node root = new Node(min, max);
		int[] smaller = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			smaller[i] = smaller(root, nums[i]);
		}
		List<Integer> result = new ArrayList<>(nums.length);
		for (int i = 0; i < smaller.length; i++)
			result.add(smaller[i]);
		return result;
	}
}
