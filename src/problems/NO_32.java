package problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 32.从上到下打印二叉树
 * 这里只实现了分行打印二叉树和之字形打印二叉树
 * 参考LeetCode 102题-从上到下打印； 107题-从下到上打印 103题-之字形打印二叉树
 * 从上到下打印
 * 牛客：https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213
 * 之字形打印
 * 牛客：https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&tqId=11212
 * @author acqierement
 * Data: 2018年11月28日
 * Time: 上午9:33:12
 */
public class NO_32 {
	//由于返回的参数是List<List<Integer>>，所以从上到下和从下到上差别不大，就写在一起了
	//分层打印二叉树，广度优先，使用队列比较方便
	 public List<List<Integer>> levelOrderBFS(TreeNode root) {
		 Queue<TreeNode> queue = new LinkedList<>();
		 List<List<Integer>> res = new LinkedList<>();
		 if (root == null) {
			return res;
		 }

		 queue.add(root);
		 while(!queue.isEmpty()){
			 int levelNum = queue.size();
			 List<Integer> subList = new LinkedList<>();
			 for(int i = 0; i < levelNum; i++) {
				 TreeNode curNode = queue.poll();
				 if(curNode.left != null) {
					 queue.add(curNode.left);
				 }
				 if(curNode.right != null) {
					 queue.add(curNode.right);
				 }
				 subList.add(curNode.val);
			 }
			 //res.add(0,subList); 从下到上，每层的结果都放在前一层的前面
			 res.add(subList);
		 }
		 return res;
	 }

	 //分层打印二叉树，深度优先
	 public List<List<Integer>> levelOrderDFS(TreeNode root) {
		 List<List<Integer>> res = new LinkedList<>();
		 levelHelper(res, root, 0);
		 return res;
	 }

	private void levelHelper(List<List<Integer>> res, TreeNode root, int level) {
		if (root == null) {
			return;
		}
		if(level >= res.size()) {
			//res.add(0,new LinkedList<Integer>()); 从下往上打印 ，每次加在最前面
			res.add(new LinkedList<Integer>());
		}
		levelHelper(res, root.left, level+1);
		levelHelper(res, root.right, level+1);
		//res.get(res.size()-level-1).add(root.val);从下往上打印的时候，获得每一层也要相应改变
		res.get(level).add(root.val);
	}

	//使用书上的方法，使用两个栈，定义一个变量isLeftToRight来判断打印的顺序
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	Stack<TreeNode> stack1 = new Stack<>();
    	Stack<TreeNode> stack2 = new Stack<>();
    	List<List<Integer>> res = new LinkedList<>();
        if(root == null) {
        	return res;
        }
    	boolean isLeftToRight = true;
    	stack1.add(root);
    	while(!stack1.isEmpty() || !stack2.isEmpty()) {
			List<Integer> subList;
    		if(isLeftToRight) {//当前打印的顺序是从左到右
				subList = new LinkedList<>();
    			while(!stack1.isEmpty()) {
    				TreeNode curNode = stack1.pop();
    				subList.add(curNode.val);
    				// 下一层打印的顺序是从右到左，要先打印右边，所以右边要最后放入栈
    				if(curNode.left != null) {
    					stack2.add(curNode.left);
    				}
    				if(curNode.right != null) {
    					stack2.add(curNode.right);
    				}
    			}
    		}else {
    			subList = new LinkedList<>();
    			while(!stack2.isEmpty()) {
    				TreeNode curNode = stack2.pop();
    				subList.add(curNode.val);
    				if(curNode.right != null) {
    					stack1.add(curNode.right);
    				}
    				if(curNode.left != null) {
    					stack1.add(curNode.left);
    				}
    			}
    		}
			isLeftToRight = !isLeftToRight;
    		res.add(subList);
    	}
    	return res;
    }

    // 使用一个队列实现，书上说使用一个栈是无法实现的，其实确实是如此。
    // 这里其实是用队列来实现树的层级遍历，然后在返回值的时候用LinkedList的addFirst()方法来实现逆序。所以本质上就是层次遍历
    public static List<List<Integer>> zigzagLevelOrderByQueue(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<>();
    	List<List<Integer>> res = new LinkedList<>();
    	boolean isLeftToRight = true;
    	if(root == null) {
    		return res;
    	}
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		LinkedList<Integer> subList = new LinkedList<>();
    		for(int i = 0; i < size; i++) {
    			TreeNode curNode = queue.poll();
    			if(curNode.left != null) {
    				queue.add(curNode.left);
    			}
    			if(curNode.right != null) {
    				queue.add(curNode.right);
    			}
    			if(isLeftToRight) {
    				subList.add(curNode.val);
    			}else {
					subList.addFirst(curNode.val);
				}
    		}
    		isLeftToRight = !isLeftToRight;
    		res.add(subList);
    	}
    	return res;
    }

    public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left = new TreeNode(5);
		List<List<Integer>> zigzagLevelOrder = zigzagLevelOrder(root);
		for (List<Integer> list : zigzagLevelOrder) {
			for (Integer integer : list) {
				System.out.println(integer);
			}
		}
	}
}
