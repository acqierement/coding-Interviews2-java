package problems;


/**
 * 65.不用加减乘除做加法
 * @author acqierement
 * Data: 2018年12月6日
 * Time: 上午10:26:09
 */
public class NO_65 {
	public static int add(int num1,int num2) {
		int sum, carry;
		do {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		} while (carry != 0);
		return sum;
	}
	
	public static int add2(int num1,int num2) {
		 if (num1 == 0) {
			return num2;
		}
		 if(num2 == 0) {
			 return num1;
		 }
		
		int sum = num1 ^ num2;
		int carry = (num1 & num2) << 1;
		sum = add2(sum, carry);
		return sum;
	}
	public static void main(String[] args) {
		int add = add(-5, -6);
		System.out.println("(-5)+(-6)="+add);

		
	}
}
