package problems;

/**
 * 44.数字序列中的某一位的数字
 * @author acqierement
 * Data: 2018年12月1日
 * Time: 下午1:45:55
 */
public class NO_44 {
	public static int digitAtIndex(int index) {
		if(index < 0) {
			return -1;
		}
		
		int digits = 1;
		while(true) {
			int numbers = countOfIntegers(digits);
			if(index < numbers*digits) {
				return digitAtIndex(index,digits);
			}
			index -= digits * numbers;
			digits++;
		}
	}

	private static int digitAtIndex(int index, int digits) {
		int num = beginNumber(digits) + index / digits;
		int indexFromRight = digits - index % digits;// 我们是从第0位开始算的
		for(int i = 1; i <indexFromRight; i++) {
			num /= 10;
		}
		return num % 10;
	}

	private static int beginNumber(int digits) {
		if(digits == 1) {
			return 0;
		}
		
		return (int) Math.pow(10, digits - 1);
	}

	private static int countOfIntegers(int digits) {
		if(digits == 1) {
			return 10;
		}
		
		return (int) (9*Math.pow(10, digits - 1));
	}
	
	public static void main(String[] args) {
		int digitAtIndex = digitAtIndex(19);
		System.out.println(digitAtIndex);
	}
}
