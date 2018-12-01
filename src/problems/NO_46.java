package problems;

/**
 * 46.把数字翻译成字符串
 * 这个题目起得不好，容易误解。这个问题其实是一个动态规划的问题。
 * @author acqierement
 * Data: 2018年12月1日
 * Time: 下午6:45:48
 */
public class NO_46 {
	public static int getTranslationCount(int number) {
		if(number < 0) {
			return 0;
		}
		String numStr = String.valueOf(number);
		return getTranslationCount(numStr);
	}

	private static int getTranslationCount(String numStr) {
		int strLen = numStr.length();
		int[] counts = new int[strLen + 1];
		int count = 0;
		counts[strLen] = 1;// 这个位置没有数据，辅助作用
		counts[strLen - 1] = 1; // 最右边的那位数字。
		for(int i = (strLen - 2); i >= 0; i--) {
			count = counts[i + 1];
			int digit1 = numStr.charAt(i) - '0';
			int digit2 = numStr.charAt(i + 1) - '0';
			int converted = digit1 * 10 + digit2;
			if(converted <= 25 && converted >=10) {
				count += counts[i + 2];
			}
			counts[i] = count;
		}
		return counts[0];
	}
	
	public static void main(String[] args) {
//		int count = getTranslationCount(12258);// 5
//		int count = getTranslationCount(101);// 2
//		int count = getTranslationCount(100);// 2
//		int count = getTranslationCount(426);// 1
//		int count = getTranslationCount(10);// 2
//		int count = getTranslationCount(125);// 3
//		int count = getTranslationCount(126);// 2
//		System.out.println(count);
				
				
	}
}
