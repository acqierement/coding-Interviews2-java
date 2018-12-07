package problems;

/**
 * 28.对称的二叉树
 * @author acqierement
 * Data: 2018年12月7日
 * Time: 上午10:41:04
 */
public class NO_28 {
	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}
		return isSymmetric(root.left,root.right);
	}

	private boolean isSymmetric(TreeNode Tleft, TreeNode Tright) {
		if(Tleft == null && Tright == null) {
			return true;
		}
		if(Tleft == null || Tright == null) {
			return false;
		}
		return (Tleft.val == Tright.val)
		     && isSymmetric(Tleft.right, Tright.left)
		     && isSymmetric(Tleft.left, Tright.right);
	}
}
