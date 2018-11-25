package example;

/**
 * 表示数值的字符串
 * leetcode 65题
 * @author acqierement
 * Data: 2018年11月25日
 * Time: 下午3:14:28
 */
public class NO_20 {
	public static boolean isNumber(String s) {
		s = s.trim();
		boolean pointSeen = false;
		boolean eSeen = false;
		boolean numberSeen = false;
		boolean numberAfterE = true;
		char c ;
		for(int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(c >= '0' && c <= '9') {
				numberSeen = true;
				numberAfterE = true;
			}else if (c == '.') {
				if(eSeen || pointSeen) {
					return false;
				}
				pointSeen = true;
			}else if (c == 'e' || c == 'E') {
				if(eSeen || !numberSeen) {
					return false;
				}
				eSeen = true;
				numberAfterE = false;
			}else if (c == '+' || c == '-') {
				if(i != 0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E') {
					return false;
				}
			}else {
				return false;
			}
		}
		return numberSeen && numberAfterE;
	}
}
