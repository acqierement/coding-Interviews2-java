package problems;

import java.util.Stack;
/**
 * 从尾到头打印链表的值
 * 牛客：https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035
 * @author acqierement
 * Data: 2018年11月16日
 * Time: 下午7:47:46
 */
public class NO_06 {
	/*
	 * 用栈的方法实现，从尾到头打印链表的值
	 */
	public static void printListReversingly_Iteratively(ListNode listNode) {
		Stack<Integer> stack = new Stack<>();
		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}

		while(!stack.isEmpty()) {		
			System.out.print(stack.pop() + " ");
		}
	}
	
	/*
	 * 用递归的方法实现，从尾到头打印链表的值
	 */
	public static void printListReversingly_Recursively(ListNode listNode) {
		if(listNode != null) {
			printListReversingly_Recursively(listNode.next);
			System.out.print(listNode.val + " ");
		}
	}
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		ListNode root = ListUtil.contruct(array);
		
		printListReversingly_Iteratively(root);
		System.out.println();
		printListReversingly_Recursively(root);
	}

}
