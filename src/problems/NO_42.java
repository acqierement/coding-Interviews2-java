package problems;

/**
 * 42.连续子数组的最大和
 * LeetCode 53题
 * 牛客：https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6
 * @author acqierement
 * Data: 2018年11月30日
 * Time: 上午10:33:14
 */
public class NO_42 {
	// 简单实现
    public int maxSubArray(int[] nums) {
    	if(nums == null || nums.length <= 0) {
    		return 0;
    	}
    		
        int curSum =nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	curSum = Math.max(curSum + nums[i], nums[i]);
        	max = Math.max(max, curSum);
        }
        return max;
    }
    
    // 动态规划，因为当前结果只和前一个变量有关，所以只需要一个变量保存就可以了，就像上面的curSum。不需要用动态规划。
    public int maxSubArrayDP(int[] nums) {
    	if(nums == null || nums.length <= 0) {
    		return 0;
    	}
    	int[] dp = new int[nums.length];
    	dp[0] = nums[0];
    	int max = nums[0];
    	for(int i = 1; i <nums.length; i++) {
    		dp[i] =dp[i-1] > 0 ? dp[i-1]+nums[i] : nums[i];
    		max = Math.max(dp[i], max);
    	}
    	return max;
    }
}
