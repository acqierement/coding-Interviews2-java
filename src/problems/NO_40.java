package problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 40.最小的K个数
 * @author acqierement
 * Data: 2018年11月29日
 * Time: 下午10:34:25
 */
public class NO_40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
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
}
