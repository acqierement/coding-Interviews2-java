package problems;

/**
 * 33.二叉搜索树的后序遍历序列
 * 力扣：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/submissions/
 * 牛客： https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd
 * @author acqierement
 * Data: 2018年11月28日
 * Time: 下午2:44:02
 */
public class NO_33 {

	/**
	 * 后续遍历，你可以知道根节点，
	 * 判断条件是：左子树的值都比根节点小，右子树的值都比根节点大，并且左右子树都是二叉搜索树
	 * @param postorder
	 * @return
	 */
	public boolean verifyPostorder(int[] postorder) {
		return verifyPostorder(postorder, 0, postorder.length - 1);
	}

	public boolean verifyPostorder(int[] postorder, int s, int e) {
		if (s >= e) {
			return true;
		}
		int root = postorder[e];
		int index = s;
		// 找到左右子树的分界点
		while (postorder[index] < root) {
			index++;
		}
		// 判断右子树是不是都大于根节点，不是的话返回false;
		for (int i = index; i < e; i++) {
			if (postorder[i] < root) {
				return false;
			}
		}
		// 验证左右子树是不是都满足后续遍历
		return verifyPostorder(postorder, s, index - 1) && verifyPostorder(postorder, index, e - 1);
	}
}
