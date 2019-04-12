package problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用两个栈模拟一个队列的操作
 * 牛客用两个栈模拟一个队列：https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6
 * 还有用两个队列模拟一个栈的操作
 * @author acqierement
 * Data: 2018年11月20日
 * Time: 上午10:24:18
 */
public class NO_09 {
	
	/*
	 * 用两个栈模拟一个队列
	 * 原本我的想法是把两个栈拼在一起，感觉怎么拼都不对，看了思路发现挺简单的，
	 * 两个栈是独立的，一个栈负责插入，要删除的时候就把这个栈的数据全放到另一个栈中，在前面那个栈的顺序是后进先出，
	 * 再倒腾到另一个栈后就变成先进先出（原来是abc，变成了cba，弹出的顺序就变成了a，b，c和进来的顺序一样。
	 */
	public static class queueUseTwoStack<T> {
		//stack1用来插入
		private Stack<T> stack1 = new Stack<>();
		//stack2用来弹出
		private Stack<T> stack2 = new Stack<>();
		
		public void appendTail(T t) {
			stack1.push(t);
		}
		
		public T deleteHead(T t) throws Exception {
			//当stack2里面没有数据的时候，就把stack1里面的数据倒腾过来
			if(stack2.isEmpty()) {
				while(!stack1.empty()) {
					stack2.push(stack1.pop());
				}
			}
			//把1的数据都弄过来之后发现2里面还是没有数据，说明1和2都没有数据了，没法弹出
			if (stack2.isEmpty()) {
				throw new Exception("queue is empty");
			}
			//如果2里面有数据就弹出数据
			return stack2.pop();
		}
	}
	
	/*
	 * 用两个队列实现栈 思路：
	 * 我们现在按顺序在1中放入abc，现在要弹出，按栈的结构要弹出c,所以我们要把ab依次放入2中，现在1只有c，2中有ab。弹出1中的c
	 * 现在再插入d，1为空，我们要往2中插入d，2变成abd，弹出就把ab放入1,2只留下d，弹出d，现在1为ab，2为空
	 * 所以，插入就往有数据的队列中放，弹出就把当前有数据的队列的数据放到另一队列中，只留下一个，弹出这一个。
	 */
	public static class stackUseTwoQueue<T> {
		private Queue<T> queue1 = new LinkedList<>();
		private Queue<T> queue2 = new LinkedList<>();
		
		public void push(T t) {
			if(!queue1.isEmpty()) {//1不为空，往1放(1不为空，按我们的设计2肯定是空的)
				queue1.add(t);
			}else {//1是空的，2可能为空，也可能不为空（2有数据或者两者都是空，就往2放）
				queue2.add(t);
			}
		}
		
		public T pop() {
			T res = null;
			if (queue1.isEmpty() && queue2.isEmpty()) {
				try {
					throw new Exception("stack is empty");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(queue1.isEmpty()) {//1为空，2不为空
				while(queue2.size() > 1) {
					queue1.add(queue2.poll());
				}
				res = queue2.poll();
			}else {//1不为空
				while(queue1.size() > 1) {
					queue2.add(queue1.poll());
				}
				res = queue1.poll();
			}
			return res;
		}
		
	}

}
