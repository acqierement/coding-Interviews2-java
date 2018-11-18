package example;

public class NO_6 {
	public static TreeNode constructCore(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) throws Exception{
		//递归中一些没必要的比较判断都会很影响效率，在数据量大的情况下
		//下面空指针的判断就可以在输入参数前进行判断会比较好
		if (preorder == null || inorder == null) {
			return null;
		}
		if(preStart > preorder.length - 1 || inStart > inEnd) return null;
		TreeNode root = new TreeNode(preorder[preStart]);
		int rootIndex = inStart;
		for(int i = inStart; i <= inEnd; i++) {
			if(inorder[i] == root.val) {
				rootIndex = i;
			}
		}
		
		if(rootIndex == inEnd && root.val != inorder[rootIndex] ) {
			throw new Error("输入错误");
		}
		
		root.left = constructCore(preStart+1, inStart, rootIndex - 1, preorder, inorder);
		root.right = constructCore(preStart+rootIndex - inStart + 1, rootIndex + 1, inEnd, preorder, inorder);			
		
		return root;
	}
	public static void main(String[] args) {
		int preorder[] = {3,9,20,15,7};
		int inorder[] = {9,3,15,20,7};

		try {
			TreeNode constructCore = constructCore(0, 0, inorder.length - 1, preorder, inorder);
		} catch (Exception e) {
			e.printStackTrace();
		}

 
	}

}
