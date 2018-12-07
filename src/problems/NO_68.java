package problems;

import java.util.LinkedList;


/**
 * 68.树中两个节点的最低公共祖先
 * @author acqierement
 * Data: 2018年12月6日
 * Time: 下午9:12:56
 */
public class NO_68 {
	// 二叉搜索树
	public static TreeNode getLastCommonParent1(TreeNode root, TreeNode p1, TreeNode p2){
		if(root == null || root == p1 || root == p2) {
			return root;
		}
		if(root.val < p1.val && root.val < p2.val) {
			return getLastCommonParent1(root.right, p1, p2);
		}
		if(root.val > p1.val && root.val > p2.val) {
			return getLastCommonParent1(root.left, p1, p2);
		}
		return root;
	}
	
	// 带有父指针的树可以转换成两个单链表的公共节点，因为每个节点只有一个父节点，沿着父节点一直遍历下去就是一个单链表
	// 链表的这题前面做过了，这里就不写了
	
	// 普通树，这里就拿普通二叉树来实现
	// 递归方法
	public static TreeNode getLastCommonParent2(TreeNode root, TreeNode p1, TreeNode p2){
		if(root == null || root == p1 || root == p2) {
			return root;
		}
		
		TreeNode left = getLastCommonParent2(root.left, p1, p2);
		TreeNode right = getLastCommonParent2(root.right, p1, p2);
		// 左子树没找到，就去右子树找
		if(left == null) {
			return right;
		}
		// 右子树没找到，就去左子树找
		if(right == null) {
			return left;
		}
		// 左右子树都有，当前节点就是父节点。
		return root;
	}
	
	// 迭代算法
	public static TreeNode getLastCommonParent3(TreeNode root, TreeNode p1, TreeNode p2){
		if(root == null) {
			return root;
		}
		LinkedList<TreeNode> path1 = new LinkedList<>();
		LinkedList<TreeNode> path2 = new LinkedList<>();

		getNodePath(root, p1, path1);
		getNodePath(root, p2, path2);
		TreeNode node = null;
		for(int i = 0; i < path1.size() && i < path2.size(); i++) {
			if(path1.get(i) == path2.get(i)) {
				node = path1.get(i);
			}else {
				break;
			}
		}
		return node;
	}

	private static boolean getNodePath(TreeNode root, TreeNode p, LinkedList<TreeNode> path) {
		path.add(root);
		if(root == p) {
			return true;
		}
		if(root.left != null) {
			if(getNodePath(root.left, p, path)) {
				return true;
			}
		}
		if(root.right != null) {
			if(getNodePath(root.right, p, path)) {
				return true;
			}
		}
		path.remove(path.size() - 1);
		return false;
		
	}
	
	public static void main(String[] args) {
		// 百度百科找了个二叉树搜索树的图
		//https://baike.baidu.com/pic/%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91/7077855/0/8644ebf81a4c510f0b3dafdf6359252dd52aa57e?fr=lemma&ct=single#aid=0&pic=8644ebf81a4c510f0b3dafdf6359252dd52aa57e
		TreeNode n12 = new TreeNode(12);
		TreeNode n5 = new TreeNode(5);
		TreeNode n18 = new TreeNode(18);
		TreeNode n2 = new TreeNode(2);
		TreeNode n9 = new TreeNode(9);
		TreeNode n15 = new TreeNode(15);
		TreeNode n19 = new TreeNode(19);
		TreeNode n17 = new TreeNode(17);
		TreeNode n16 = new TreeNode(16);
		n12.left = n5;
		n12.right = n18;
		n5.left = n2;
		n5.right = n9;
		n18.left = n15;
		n18.right = n19; 
		n15.right = n17;
		n17.left = n16;
		TreeNode parent1 = getLastCommonParent1(n12, n15, n19);
		TreeNode parent2 = getLastCommonParent2(n12, n15, n19);
		TreeNode parent3 = getLastCommonParent3(n12, n15, n19);
		System.out.println(parent1.val);
		System.out.println(parent2.val);
		System.out.println(parent3.val);
	}


}
