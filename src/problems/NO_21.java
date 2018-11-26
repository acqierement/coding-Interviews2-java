package problems;

import java.util.Arrays;
import java.util.Comparator;



/**
 * 调整数组顺序使奇数位于偶数前面
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
