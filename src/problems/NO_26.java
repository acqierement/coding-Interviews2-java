package problems;

/**
 * 26.树的子结构
 * leetcode 572题Subtree of Another Tree
 * 牛客：https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88
 * leetcode上的题目是判断是不是子树，而牛客的题目和书上一样，判断是不是子结构
 * @author acqierement
 * Data: 2018年11月26日
 * Time: 下午5:40:49
 */
public class NO_26 {
	//leetcode 判断是不是子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if(isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

	private boolean isSame(TreeNode s, TreeNode t) {
		if(s == null && t == null) return true;
		if(s == null || t == null) return false;
		return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
	}
	
	// 判断是不是子结构，牛客上默认null不是任何子树的子结构
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null || root1 == null) return false;
        if(hasSame(root1,root2)) return true;
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    
    public boolean hasSame(TreeNode n1, TreeNode n2) {
        if (n2 == null) return true;
        if (n1 == null) return false;
        if(n1.val != n2.val) return false;
        return (hasSame(n1.left, n2.left) && hasSame(n1.right, n2.right));
    }
}
