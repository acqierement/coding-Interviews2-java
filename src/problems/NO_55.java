package problems;

/**
 * 55.二叉树的深度
 * 题目一：二叉树的深度
 * 题目二：平衡二叉树
 * LeetCode 104. Maximum Depth of Binary Tree
 * LeetCode 110. Balanced Binary Tree
 * @author acqierement
 * Data: 2018年12月3日
 * Time: 下午3:44:17
 */
public class NO_55 {
    public int maxDepth(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    // 题目二 简单实现，自顶向下，很多子树都重复遍历了
    public boolean IsBalanced_Simple(TreeNode root) {
        if(root == null) {
        	return true;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int diff = leftDepth - rightDepth;
        if(diff < -1 || diff > 1) {
        	return false;
        }
        
        return IsBalanced_Simple(root.right) && IsBalanced_Simple(root.left);
    }
    
    // 题目二自底向上的实现，先判断最小子树是不是平衡，在判断大子树是否平衡，最后知道整棵树是否平衡，遍历顺序有点像后序遍历
    public boolean IsBalanced_Solution(TreeNode root) {
    	return dfsDepth(root) != -1;
    }

	private int dfsDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftDepth = dfsDepth(root.left);
		if (leftDepth == -1) {
			return -1;
		}
		int rightDepth = dfsDepth(root.right);
		if (rightDepth == -1) {
			return -1;
		}
		int diff = leftDepth - rightDepth;
		if(diff < -1 || diff > 1) {
			return -1;
		}
		
		return Math.max(leftDepth, rightDepth) + 1;
	}
    
}
