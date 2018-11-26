package problems;

/**https://leetcode.com/problems/regular-expression-matching/submissions/
 * 正则表达式匹配
 * @author acqierement
 * Data: 2018年11月24日
 * Time: 下午8:17:07
 */
public class NO_19 {
	
	//递归判断
	public boolean isMatch(String text, String pattern) {
		if(pattern.isEmpty()) {
			return text.isEmpty();
		}
		boolean first_match = !text.isEmpty() && 
				(text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');
		if(pattern.length() >= 2 && pattern.charAt(1) == '*') {
			return isMatch(text, pattern.substring(2)) || // 星号前面的字符出现0次
					(first_match && isMatch(text.substring(1), pattern)); // 第一个字符匹配，星号代表多次的情况
		}else {
			return first_match && isMatch(text.substring(1), pattern.substring(1));// 没有星号，并且第一个字符匹配
		}
	}
	
	//动态规划
	public boolean isMatch2(String s, String p) {

	    if (s == null || p == null) {
	        return false;
	    }
	    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
	    dp[0][0] = true;
	    for (int i = 0; i < p.length(); i++) {
	        if (p.charAt(i) == '*' && dp[0][i-1]) {
	            dp[0][i+1] = true;
	        }
	    }
	    for (int i = 0 ; i < s.length(); i++) {
	        for (int j = 0; j < p.length(); j++) {
	            if (p.charAt(j) == '.') {
	                dp[i+1][j+1] = dp[i][j];
	            }
	            if (p.charAt(j) == s.charAt(i)) {
	                dp[i+1][j+1] = dp[i][j];
	            }
	            if (p.charAt(j) == '*') {
	                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
	                    dp[i+1][j+1] = dp[i+1][j-1];
	                } else {
	                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
	                }
	            }
	        }
	    }
	    return dp[s.length()][p.length()];
	}
	
	
}
