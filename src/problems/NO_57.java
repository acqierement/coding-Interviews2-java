package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 57.和为s的数字
 * 题目一：和为s的两个数字 LeetCode 167题
 * 题目二：和为s的连续正数序列
 * @author acqierement
 * Data: 2018年12月4日
 * Time: 下午6:52:07
 */
public class NO_57 {
	// 题目一
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    	ArrayList<Integer> res = new ArrayList<>();
        if(array == null || array.length < 2) {
        	return res;
        }
        int start = 0;
        int end = array.length - 1;
        while(start < end) {
        	int value = array[start] + array[end];
        	if(value == sum) {
        		res.add(array[start]);
        		res.add(array[end]);
        	}
        	if(value < sum) {
        		start++;
        	}else {
        		end--;
        	}
        }
        return res;
    }
    
    // 题目二，在牛客网上这一题还有一个比较极限的做法，我写在解题思路里面
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(sum < 3) {
        	return res;
        }
        int small = 1;
        int big = 2;
        int mid = (sum + 1) / 2;
        int curSum = 3;
        while(small < mid) {
        	if(curSum == sum) {
        		ArrayList<Integer> temp = new ArrayList<>();
        		for(int i = small; i <= big; i++) {
        			temp.add(i);
        		}
        		res.add(temp);
        	}
        	while(curSum > sum && small < mid) {
        		curSum -= small;
        		small++;
        		if(curSum == sum) {
        			ArrayList<Integer> temp = new ArrayList<>();
            		for(int i = small; i <= big; i++) {
            			temp.add(i);
            		}
            		res.add(temp);
        		}
        	}
        	big++;
        	curSum += big;
        }
        return res;
    }
}
