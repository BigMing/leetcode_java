package leetcodeTest;

import java.util.HashMap;
import java.util.Map;

public class test337_HouseRobberIII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	 	
	public static Map<TreeNode, Integer> trueCache = new HashMap<>();
	public static Map<TreeNode, Integer> falseCache = new HashMap<>();
    public int rob(TreeNode root) {
    	trueCache.clear();
    	falseCache.clear();
        return robot(root, true);
    }
    /**
     * @param root
     * @param b 这个节点还是否偷了
     */
	private int robot(TreeNode root, boolean canRob) {
		if (root == null) {
			return 0;
		}
		if (canRob && trueCache.containsKey(root)) {
			return trueCache.get(root);
		}
		if (!canRob && falseCache.containsKey(root)) {
			return falseCache.get(root);
		}
		int ans = 0;
		if (canRob) { // 直接关联的节点不能偷
			ans = Math.max(ans, root.val + robot(root.left, false) + robot(root.right, false));
		}
		ans =  Math.max(ans, robot(root.left, true) + robot(root.right, true));
		if (canRob) {
			trueCache.put(root, ans);
		}
		if (!canRob) {
			falseCache.put(root, ans);
		}
		return ans;
	}
}
