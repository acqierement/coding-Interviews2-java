package problems;

/**
 * 中序遍历的下一个节点
 * @author acqierement
 * Data: 2018年11月19日
 * Time: 下午9:08:59
 */
public class NO_08 {
	public TreeLinkNode getNext(TreeLinkNode pNode) {
		if(pNode == null) 
			return null;
		TreeLinkNode pNext = null;
		if(pNode.right != null) {
			TreeLinkNode root = pNode.right;
			while(root.left != null) {
				root = root.left;
			}
			pNext = root;
		}else if(pNode.next != null) {
			TreeLinkNode parent = pNode.next;
			TreeLinkNode cur = pNode;
			while(parent!= null && parent.right == cur) {
				cur = parent;
				parent = parent.next;
			}
			pNext = parent;
		}
		return pNext;
	}
	public static void main(String[] args) {


	}

}
