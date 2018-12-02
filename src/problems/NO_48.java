package problems;


/**
 * 48.最长不含重复字符的子字符串
 * 参考LeetCode 3题
 * @author acqierement
 * Data: 2018年12月2日
 * Time: 上午10:26:20
 */
public class NO_48 {
	public int lengthOfLongestSubstring(String s) {
		// 分别对应ASCII的各个字符
		int[] positon = new int[128];
		int res = 0;
		
		for(int start = 0, cur = 0; cur < s.length(); cur++) {
			start = Math.max(positon[s.charAt(cur)], start);
			res = Math.max(res, cur - start + 1);
			positon[s.charAt(cur)] = cur + 1;
		}
		return res;
	}
}
