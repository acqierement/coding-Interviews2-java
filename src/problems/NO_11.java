package problems;

/**
 * 旋转数组的最小数字
 * 可以看看Leetcode 153和154题
 * 牛客：https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba
 * 这里我只实现可以有重复数字的
 * @author acqierement
 * Data: 2018年11月20日
 * Time: 下午6:24:43
 */
public class NO_11 {
	
	//从旋转数组中找到最小数，数组里的数字可以重复
	public static int min(int nums[]) {
		int start = 0, end = nums.length - 1;
		while(start < end) {
			if(nums[start] < nums[end])
				return nums[start];
			int mid = ((end - start)>>2) + start; 
			if(nums[start] > nums[mid]) {
				end = mid;
			}else if(nums[start] < nums[mid]) {
				start = mid + 1;
			}else {
				while(nums[start] == nums[mid] && start < end) {
					start++;
				}
			}
		}
		return nums[start];
	}
}
