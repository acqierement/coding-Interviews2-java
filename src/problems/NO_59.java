package problems;

import java.util.ArrayDeque;
import java.util.ArrayList;


/**
 * 59.队列的最大值
 * 题目一：滑动窗口的最大值
 * 题目二：队列的最大值,题目二差不多一样，这里就不写了
 * @author acqierement
 * Data: 2018年12月4日
 * Time: 下午9:22:15
 */
public class NO_59 {
	
	// 题目一
	public static ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> res = new ArrayList<>();
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		if(size > num.length || size <= 0) {
			return res;
		}
		
		// 先装size个数据进去，因为小于窗口的大小是不算最大值的
		for(int i = 0; i < size; i++) {
			while(!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
				deque.pollLast();
			}
			deque.addLast(i);
		}
		
		for(int i = size; i < num.length; i++) {
			// 把deque的代表最大值的第一个数字放进去
			res.add(num[deque.peekFirst()]);
			// 当前加入的数据比deque最后一个大的话，就将最后一个去除。后面再将这个数据加进去
			while(!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
				deque.pollLast();
			}
			// 如果deque的数量大于size，就将第一个弹出。
			if(!deque.isEmpty() && (i - deque.peekFirst()) >= size) {
				deque.pollFirst();
			}
			// 无论哪种情况，都是需要把当前数据加进去
			deque.addLast(i);
		}
		// 把最后一个窗口的最大值加进去
		res.add(num[deque.peekFirst()]);
		return res;
	}
	

	public static void main(String[] args) {
		int[] num = {2,3,4,2,6,2,5,1};
		maxInWindows(num, 3);
	}
}
