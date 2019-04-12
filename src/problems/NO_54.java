package problems;

/**
 * 54.二叉搜索树的第k大节点
 * LeetCode 230.Kth Smallest Element in a BST
 * 牛客：https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215
 * @author acqierement
 * Data: 2018年12月3日
 * Time: 下午2:33:48
 */
public class NO_54 {
	
	// 方法一，中序遍历递归遍历,书上的方法

	private static int count = 0;

	public int kthSmallest(TreeNode root, int k) {
		count = k;
		return helper(root).val;
	}

	private TreeNode helper(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		TreeNode res = null;
		res = helper(root.left);
		// 左子树找到了答案，不需要看其他了
		if (res != null) {
			return res;
		}
		count--;
		// 左子树没找到答案，看当前节点是不是答案
		if (count == 0) {
			res = root;
			return res;
		}
		// 左子树和当前节点都没找到答案，去右子树找
		return helper(root.right);
	}
	
	// 方法二，这个方法和前面一种挺像的，它是把数据分成左右子树，判断k是在哪一个子树里面
	public int kthSmallest1(TreeNode root, int k) {
		// 左子树的节点个数
		int leftLength = countTreeNode(root.left);
		// 答案在左子树中
		if(k <= leftLength) {
			return kthSmallest(root.left, k);
		}
		// 答案在右子树中
		if(k > leftLength + 1) {
			return kthSmallest(root.right, k - leftLength -1);// 右子树的第k - leftLength -1个节点就是答案
		}
		
		// k == leftLength + 1，当前节点正好是答案。
		return root.val;
	}
	// 计算一棵树的节点数量
	private int countTreeNode(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + countTreeNode(root.left) + countTreeNode(root.right);
	}
}
