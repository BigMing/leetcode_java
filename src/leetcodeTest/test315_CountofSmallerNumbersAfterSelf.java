package leetcodeTest;

import java.util.ArrayList;
import java.util.List;

public class test315_CountofSmallerNumbersAfterSelf {
	/**
	 * 穷举计数，时间复杂度O(n^2)，超时、无法通过。
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
	
	// 使用BST进行统计。时间复杂度O(nlogn)。
	class TreeNode {
		int val;
		int size; // 当前节点为根时，树的大小（节点个数）
		TreeNode left, right;
		TreeNode(int val) {
			this.val = val;
		}
	}

	// 计算BST中比传入的val小的节点的个数，同时也是插入val到BST中
	private int smaller(TreeNode current, int val) {
		current.size++; // 相当于插入节点
		if (current.val < val) { // 传入的val大于（根）节点时
			if (current.right == null) // 如果右子节点是null就插入成为右子节点
				current.right = new TreeNode(val);
			// BST特性，-1是减去val节点本身，左子树都是比val小的
			return current.size - 1 - current.right.size + smaller(current.right, val);
		} else if (current.val > val) { // 传入的val小于（根）节点时
			if (current.left == null) // 如果（根）节点的左子树是空，就插入val成为其左子节点
				current.left = new TreeNode(val);
			return smaller(current.left, val); // 返回其左子树的中比val小的个数
		} else { // 传入的val == （根）节点的值
			// 若（根）节点的左子树为空，自然没有比val小的数，返回0；不为空要返回其左子树的大小就是比val小的个数
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
	
	// 分段树
	class Node {
		int min, max;
		int count;
		Node left, right;
		Node(int min, int max) {
			this.min = min;
			this.max = max;
		}
	}

	// 插入val，返回比val小的数个数
	private int smaller(Node node, int val) {
		node.count++; // 插入节点
		if (node.min == node.max)
			return 0;
		int m = (node.min + node.max) / 2;
		if (m < val) { // 传入的val比中值大，往右子树走
			if (node.right == null)
				node.right = new Node(m + 1, node.max);
			return node.count - 1 - node.right.count + smaller(node.right, val);
		} else if (m > val) { // 传入的val比中值小，往左子树走
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
		// 获得分段树根节点的左、右边界值，并初始化根节点
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
