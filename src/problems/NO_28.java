package problems;

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
