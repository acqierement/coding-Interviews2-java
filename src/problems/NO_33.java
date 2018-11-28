package problems;

/**
 * 33.二叉搜索树的后序遍历序列
 * @author acqierement
 * Data: 2018年11月28日
 * Time: 下午2:44:02
 */
public class NO_33 {
	
	public boolean verifySquenceOfBST(int [] sequence) {
		return verifySquenceOfBST(sequence, 0, sequence.length-1);
    }

	private boolean verifySquenceOfBST(int[] sequence, int start, int end) {
		if(sequence == null || sequence.length == 0) {
			return false;
		}
		int root = sequence[end];
		int index = start;
		//找到左子树和右子树的区分位置
		for(; index < end; index++) {
			if(sequence[index] > root) {
				break;
			}
		}
		//右子树都要比根节点大
		for(int i = index; i < end; i++) {
			if(sequence[i] < root) {
				return false;
			}
		}
		
		boolean verifyLeft = true;
		boolean verifyRight = true;
		if(index > start) {//存在左子树的话，判断左子树是不是二叉搜索树
			verifyLeft = verifySquenceOfBST(sequence, start, index - 1);
		}
		if(index < end) {//存在右子树的话，判断右子树是不是二叉搜索树
			verifyRight = verifySquenceOfBST(sequence, index, end - 1);
		}
		return (verifyLeft && verifyRight);
	}
}
