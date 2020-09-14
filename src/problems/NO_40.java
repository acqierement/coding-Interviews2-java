package problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 40.最小的K个数
 * 牛客：https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf
 * 这里用的是最大堆和快排两种方法
 * @author acqierement
 * Data: 2018年11月29日
 * Time: 下午10:34:25
 */
public class NO_40 {
	// 使用最大堆的方法
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
    	ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
        	@Override
        	public int compare(Integer o1, Integer o2) {
        		return o2.compareTo(o1);
        	}
		});
        for(int num : input) {
        	if(maxHeap.size() < k) {
        		maxHeap.offer(num);
        	}else if(maxHeap.peek() > num){
				maxHeap.poll();
				maxHeap.offer(num);
			}
        }
        for(int num : maxHeap) {
        	res.add(num);
        }
        return res;
    }

	// 使用快排剪枝的方法
	public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        findMinK(input, 0, input.length - 1, k);
        if (k > input.length) return res;
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public void findMinK(int[] input,int start, int end, int k) {
        if (start >= end) return;
        int pos = partition(input, start, end);
        if (pos < k - 1) {
            findMinK(input, pos + 1, end, k);
        } else if (pos > k - 1) {
            findMinK(input, start, pos - 1, k);
        }
    }

    public int partition(int[] input, int start, int end) {
        int povit = input[end];
        while (start < end) {
            while (start < end && input[start] <= povit) start++;
            if (start < end) input[end--] = input[start];
            while (start < end && input[end] > povit) end--;
            if (start < end) input[start++] = input[end];
        }
        input[start] = povit;
        return start;
    }
}
