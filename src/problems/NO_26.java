package problems;

/**
 * 26.树的子结构
 * leetcode 572题
 * @author acqierement
 * Data: 2018年11月26日
 * Time: 下午5:40:49
 */
public class NO_26 {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(s == null) {
			return false;
		}
		if(isSame(s,t)) {
			return true;
		}
		return isSubtree(s.left, t.left) || isSubtree(s.right, t.right);
	}

	private boolean isSame(TreeNode s, TreeNode t) {
		if(s == null && t == null) {
			return true;
		}
		if(s == null || t == null) {
			return false;
		}
		return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
	}
}
