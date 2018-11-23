package example;

/**
 * 打印从1到最大的n位数
 * @author acqierement
 * Data: 2018年11月23日
 * Time: 下午7:13:36
 */
public class NO_17 {
	public static void print1ToMaxOfNDigits(int n) {
		if(n <= 0) 
			return;
		char[] number = new char[n];
		for(int i = 0; i < number.length; i++) {
			number[i] = '0';
		}
		while(increment(number)) {
			printNumber(number);
		}
	}

	private static boolean increment(char[] number) {
		int carry = 1;
		int index = number.length - 1;
		while( index >= 0){
			int nSum = number[index] - '0' + carry;
			if(nSum == 10) {
				number[index] = '0';
				index--;
			}else {
				number[index] = (char) (nSum + '0');
				carry = 0;
				break;
			}
		}
		if(index < 0 && carry == 1)
			return false;
		
		return true;
	}
	
	private static void printNumber(char[] number) {
		int index = 0;
		while(index < number.length && number[index] == '0') {
				index++;
		}
		//都是0的时候，因为我们从1开始打印
		if(index == number.length)
			return;
		for(int i = index; i < number.length; i++) {
			System.out.print(number[i]);
		}
		System.out.println();
	}

	//递归调用
	public static void print1ToMaxOfNDigits2(int n) {
		if(n <= 0) 
			return;
		char[] number = new char[n];
		for(int i = 0; i < 10; i++) {
			number[0] = (char) ('0' + i);
			print1ToMaxOfNDigitsRecursively(number,1);
		}
	}
	private static void print1ToMaxOfNDigitsRecursively(char[] number, int index) {
		if(index == number.length) {
			printNumber(number);
			return ;
		}
		for(int i = 0; i < 10; i++) {
			number[index] = (char) ('0'+i);
			print1ToMaxOfNDigitsRecursively(number, index+1);
		}

	}

	public static void main(String[] args) {
//		print1ToMaxOfNDigits(4);
		print1ToMaxOfNDigits2(4);
	}
}
