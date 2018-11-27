package problems;

/**
 * 27.二叉树的镜像
 * @author acqierement
 * Data: 2018年11月27日
 * Time: 上午10:30:39
 */
public class NO_27 {
	public void mirrorResursively(TreeNode root) {
		if(root == null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		if(root.left != null) {
			mirrorResursively(root.left);
		}
		
		if(root.right != null) {
			mirrorResursively(root.right);
		}
	}
}
