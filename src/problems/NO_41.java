package problems;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 41.数据流中的中位数
 * LeetCode 295题
 * @author acqierement
 * Data: 2018年11月30日
 * Time: 上午10:15:28
 */
public class NO_41 {
	private PriorityQueue<Integer> min = new PriorityQueue<>();
	private PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
	private boolean isEven = true;
    public void Insert(Integer num) {
        if (isEven) {
			max.offer(num);
			min.offer(max.poll());
		}else {
			min.offer(num);
			max.offer(min.poll());
		}
        isEven = !isEven;
    }

    public Double GetMedian() {
        if(isEven) {
        	return (min.peek() - max.peek())/2.0 + max.peek();
        }else {
        	return (double)min.peek();
        }
    }
    
    public static void main(String[] args) {


	}
}
