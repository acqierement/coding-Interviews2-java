package problems;

/**
 * 47.礼物的最大价值
 * 这个名字根本看不出题目的意思，参考LeetCode 64. Minimum Path Sum，
 * 其实这题就是求走过路径的最大值，只能往下和往右走。很典型的动态规划题目。(前提数字都是非负数)
 * @author acqierement
 * Data: 2018年12月1日
 * Time: 下午7:45:55
 */
public class NO_47 {
	// 我这里直接使用一维数组了，以前没接触过这个题目的可以看一下书上二维的实现，剩下的可以看一下解题思路
    public int maxPathSum(int[][] grid) {
    	if(grid == null || grid.length <= 0 || grid[0].length <= 0) {
    		return -1;
    	}
    	int colLen = grid[0].length;
    	int[] dp = new int[colLen];
    	dp[0] = grid[0][0];
    	for(int i = 1; i < colLen; i++) {
    		dp[i] += grid[0][i] + dp[i - 1];
    	}

    	for(int i = 1; i < grid.length; i++) {
    		int[] rows = grid[i];
    		for(int j = 0; j < grid[0].length; j++) {
    			if(j == 0) {
    				dp[j] = dp[j] + rows[j];
    			}else {
    				dp[j] = Math.max(dp[j - 1], dp[j]) + rows[j];
    			}
    		}
    	}
    	return dp[colLen - 1];
    }
}
