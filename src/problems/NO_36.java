package problems;

/**
 * 36.二叉搜索树与双向链表
 * @author acqierement
 * Data: 2018年11月29日
 * Time: 上午9:52:10
 */
public class NO_36 {
	//定义个变量，保存上一个节点
	private TreeNode prev;
    public TreeNode Convert(TreeNode root) {
    	if(root == null) {//如果不判断，下面dummy.right.left = null会报错
    		return null;
    	}
    	TreeNode dummy = new TreeNode(0);
    	prev = dummy;
    	converByInorder(root);
    	dummy.right.left = null;// 断开联系，否则从右到左会遍历到dummy
    	return dummy.right;
    	
    }
    
    // 其实就是中序遍历，按照中序遍历的顺序找到节点，将这些节点连接起来
	private void converByInorder(TreeNode root) {
		if(root == null) {
			return;
		}
		converByInorder(root.left);
		prev.right = root;
		root.left = prev;
		prev = root;
		converByInorder(root.right);
	}
    
}
