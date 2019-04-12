package problems;

import java.util.Arrays;
import java.util.Comparator;



/**
 * 调整数组顺序使奇数位于偶数前面
 * 牛客 https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593 牛客要求顺序不能变化，不能用这里写的方法，
 * 可以考虑使用插入排序或者冒泡法来保证顺序，时间复杂度O(n^2)。或者新建一个数组遍历两次，分别将奇数和偶数放进去，时间复杂度O(2n),利用空间换时间。
 * @author acqierement
 * Data: 2018年11月25日
 * Time: 下午4:43:13
 */
public class NO_21 {
	private static class ReorderPattern {
		public boolean isEven(int n) {
			return (n & 1) == 0;
		}
	}
	public static void reorderOddEven(int[] nums) {
		ReorderPattern reorderPattern = new ReorderPattern();
		if (nums == null || nums.length < 2) {
			return;
		}
		int start = 0;
		int end = nums.length - 1;
		while(start < end) {
			while(start < end && !reorderPattern.isEven(nums[start])) {
				start++;
			}
			while(start < end && reorderPattern.isEven(nums[end])) {
				end--;
			}
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
		}
	}
}
