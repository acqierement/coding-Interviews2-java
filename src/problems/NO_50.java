package problems;


/**
 * 50.第一个只出现一次的字符
 * 题目一：字符串中只出现一次的字符 
 * 牛客：https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c
 * 题目二：字符流中只出现一次的字符
 * @author acqierement 
 * Data: 2018年12月2日 
 * Time: 下午4:16:27
 */
public class NO_50 {
	// 题目一
	public int FirstNotRepeatingChar(String str) {
		if (str == null) {
			return -1;
		}
		int[] characters = new int[256];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			characters[ch]++;
		}
		for (int i = 0; i < str.length(); i++) {
			if (characters[str.charAt(i)] == 1) {
				return i;
			}
		}
		return -1;
	}

	// 题目二
	// Insert one char from stringstream
	private static int[] occurrence = new int[256];
	// 这里设成static是为了main函数能调用，不然不可以加static，加了会出现错误。
	// 这里的StringBuilder是为了存放字符串，保留了添加顺序。遍历这个StringBuilder，就是按照添加的顺序遍历的，以此来保证输出第一个字符串。
	private static StringBuilder sBuilder = new StringBuilder();
	public static void Insert(char ch) {
		sBuilder.append(ch);
		int count = occurrence[ch];
		if(count == 0) {
			occurrence[ch] = 1;
		}
		if(count > 0) {
			occurrence[ch] = -1;
		}
	}

	// return the first appearence once char in current stringstream
	public static char FirstAppearingOnce() {
		for(int i = 0; i < sBuilder.length(); i++) {
			if(occurrence[sBuilder.charAt(i)] == 1) {
				return sBuilder.charAt(i);
			}
		}
		return '#';
	}
	
	public static void main(String[] args) {
		Insert('h');
		Insert('e');
		Insert('l');
		char c = FirstAppearingOnce();
		System.out.println(c);
	}
}
