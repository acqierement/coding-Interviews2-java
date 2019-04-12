package problems;

import java.util.ArrayList;

/**
 * 34.二叉树中和为某一个值的路径
 * 牛客：https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca
 * @author acqierement
 * Data: 2018年11月28日
 * Time: 下午3:04:20
 */
public class NO_34 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    	ArrayList<Integer> curRes = new ArrayList<>();
    	FindPath(root, target, res, curRes);
    	return res;
    }

	private void FindPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> res,
			ArrayList<Integer> curRes) {
		if(root == null) {
			return;
		}
		curRes.add(root.val);
		if(target == root.val && root.left == null && root.right == null) {
			res.add(new ArrayList<>(curRes));// 注意这里，别像我不注意把curRes直接放进去。
		}
		FindPath(root.left, target - root.val, res, curRes);
		FindPath(root.right, target - root.val, res, curRes);
		curRes.remove(curRes.size()-1);
	}
    
}
