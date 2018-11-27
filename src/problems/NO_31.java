package problems;

import java.util.Stack;

/**
 * 31.栈的压入和弹出，参考书上和LeetCode写了两个解法
 * LeetCode 946题
 * @author acqierement
 * Data: 2018年11月27日
 * Time: 下午8:03:36
 */
public class NO_31 {
	//用书上的方法
    public boolean IsPopOrder1(int[] pushA,int[] popA) {
    	int pushIndex = 0;
    	int popIndex = 0;
    	Stack<Integer> stack = new Stack<>();
    	//当出栈还有没处理的数据
    	while(popIndex < popA.length) {
    		//把入栈数组中的数据依次入栈，直到栈顶的元素和出栈的元素一样，或者入栈数组已经全部入栈了
    		while(pushIndex < pushA.length && (stack.isEmpty() || stack.peek() != popA[popIndex])) {
    			stack.push(pushA[pushIndex]);
    			pushIndex++;
    		}
    		// 找到了与出栈数据相同的数据，继续处理下一个出栈数据
    		if(stack.peek() == popA[popIndex]) {
    			stack.pop();
    			popIndex++;
    		}else {//入栈数组的元素已经全部入栈了，但是栈顶元素跟出栈元素不相等，可以判断这两个数据是错误的
    			return false;
    		}
    	}
    	return true;
    }
    
    //第二种方法明显简洁了很多，根本就不需要写注释
    public boolean IsPopOrder2(int[] pushA, int[] popA) {
    	int popIndex = 0;
    	Stack<Integer> stack = new Stack<>();
    	
    	for(int pushNum : pushA) {
    		stack.push(pushNum);
    		while(!stack.isEmpty() && stack.peek() == popA[popIndex]) {
    			stack.pop();
    			popIndex++;
    		}
    	}
    	return stack.isEmpty();
    }
}
