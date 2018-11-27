package problems;

import java.util.Arrays;
import java.util.Stack;

/**
 * 30.包含min函数的栈 
 * 因为这里pop返回的类型是void，所以好像不需要实现栈的pop功能，也就不需要数据栈了，可以参考leetCode的题目
 * 参考LeetCode 155题 ，没有数据栈，这里我实现的是有数据栈的
 * @author acqierement
 * Data: 2018年11月27日
 * Time: 下午7:00:43
 */
public class NO_30 {
	private int size = 0;
	private int min = Integer.MAX_VALUE;
    private Stack<Integer> minStack = new Stack<>();// 存放最小值
    private Integer[] dataArray = new Integer[10];// 存放数据
    
    private void ensureCapacity(int size) {
    	int len = dataArray.length;
    	if(size > len) {
    		int newLen = len*3/2+1;
    		dataArray = Arrays.copyOf(dataArray, newLen);
    	}
    }
    public void push(int node) {
    	ensureCapacity(size+1);
    	dataArray[size++] = node;
        if (node < min ) {
			minStack.push(node);
			min = node;
		}else {
			minStack.push(min);
		}
    }
    
    public void pop() {
       if(size <= 0) {
    	   throw new RuntimeException("The stack is already empty");
       }
        size--;
        min = minStack.pop();
    }
    
    public int top() {
        if(size > 0) {
        	return dataArray[size - 1];
        }else {
        	throw new RuntimeException("The stack is already empty");
        }
    }
    
    public int min() {
        return minStack.peek();
    }
}
