package problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 62.圆圈中最后剩下的数字
 * @author acqierement
 * Data: 2018年12月5日
 * Time: 下午7:41:41
 */
public class NO_62 {
	// 方法一：模拟圆圈
	public int lastRemaining1(int n, int m) {
		if(n < 1 || m < 1) {
			return -1;
		}
		List<Integer> list = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			list.add(i);
		}
		
		int index = 0;
		while(list.size() > 1) {
			index = (index + m - 1) % list.size();
			list.remove(index);
		}
		return list.get(0);
	}
	
	// 用公式，主要是要懂得推导
	public int lastRemaining2(int n, int m) {
		if(n < 1 || m < 1) {
			return -1;
		}
		
		int last = 0;
		for(int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
		
		return last;
	}

}
