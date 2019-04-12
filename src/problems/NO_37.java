package problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 37.序列化二叉树
 * 参考LeetCode 297题
 * 牛客：https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=13&tqId=11214
 * @author acqierement 
 * Data: 2018年11月29日 
 * Time: 上午11:30:01
 */
public class NO_37 {
	private static final String SPLITER = ",";
	private static final String NULLCODE = "#";
	public static String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		bulidString(root, sb);
		return sb.toString();
	}

	private static void bulidString(TreeNode root, StringBuilder sb) {
		if(root == null) {
			sb.append(NULLCODE).append(SPLITER);
		}else {
			sb.append(String.valueOf(root.val)).append(SPLITER);
			bulidString(root.left, sb);
			bulidString(root.right, sb);		
		}
	}

	public  static TreeNode Deserialize(String str) {
		String[] strArrays = str.split(SPLITER);
		Queue<String> queue = new LinkedList<>();
		queue.addAll(Arrays.asList(strArrays));
		return buildTree(queue);
	}
	private static TreeNode buildTree(Queue<String> queue) {
		String word = queue.poll();
		if(word.equals(NULLCODE)) {
			return null;
		}else {
			TreeNode node = new TreeNode(Integer.valueOf(word));
			node.left = buildTree(queue);
			node.right = buildTree(queue);
			return node;
		}
	}

	public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        String serialize = Serialize(n1);
        System.out.println(serialize);
        Deserialize(serialize);
	}
}
