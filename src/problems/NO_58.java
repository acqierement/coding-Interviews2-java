package problems;

/**
 * 58.翻转字符串  java使用stringBuilder处理这些字符串的题目比较简单
 * 题目一：翻转单词顺序
 * 题目二：左旋转字符串
 * 相关LeetCode 344. Reverse String 557. Reverse Words in a String III
 * @author acqierement
 * Data: 2018年12月4日
 * Time: 下午8:01:54
 */
public class NO_58 {
	
	public static String reverseSentence(String str) {
		if (str == null) {
			return null;
		}
		StringBuilder res = new StringBuilder();
		StringBuilder word = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != ' ') {
				word.append(str.charAt(i));
			}else {
				res.insert(0, word.toString());
				res.insert(0, ' ');
				word.setLength(0);
			}
		}
		res.insert(0, word.toString());
		return res.toString();
	}
	
	public static String leftRotateString(String str, int n) {
		if(n <= 0 || n > str.length() || str == null) {
			return str;
		}
		StringBuilder res = new StringBuilder();
		for(int i = n; i < str.length(); i++) {
			res.append(str.charAt(i));
		}
		for(int i = 0; i < n; i++) {
			res.append(str.charAt(i));
		}
		return res.toString();
	}
	public static void main(String[] args) {
		String string = "abcdefg";
//		String reverseSentence = reverseSentence(string);
		String leftRotateString = leftRotateString(string, 2);
		System.out.println(leftRotateString);
//		System.out.println(reverseSentence);
	}
}
