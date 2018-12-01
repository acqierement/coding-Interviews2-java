package problems;

/**
 * 1~n整数中
 * 
 * @author acqierement Data: 2018年11月30日 Time: 上午11:27:39
 */
public class NO_43 {
	// 一般最先想到的解法，其实这种题深究都是属于数学知识的范畴
	public static int NumberOf1Between1AndN_Simple(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			count += NumberOf1(i);
		}
		return count;
	}

	private static int NumberOf1(int num) {
		int count = 0;
		while (num != 0) {
			if (num % 10 == 1) {
				count++;
			}
			num /= 10;
		}
		return count;
	}
	
	//比较巧妙的方法，具体看解题思路。
	public int NumberOf1Between1AndN_Solution(int n) {
		int count = 0;
		int i = 1;// 当前位
		int current = 0, after = 0, before = 0;
		while ((n / i) != 0) {
			current = (n / i) % 10; // 当前数字
			before = n / (i * 10); // 高位的数值大小
			after = n - (n / i) * i; // 低位数值
			// 如果为0,出现1的次数由高位决定,等于高位数值* 当前位数
			if (current == 0)
				count += before * i;
			// 如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
			else if (current == 1)
				count += before * i + after + 1;
			// 如果大于1,出现1的次数由高位决定,与等于0的情况相比，0到2又会再经过1，所以要多乘一次
			else {
				count += (before + 1) * i;
			}
			// 前移一位
			i = i * 10;
		}
		return count;
	}

}
