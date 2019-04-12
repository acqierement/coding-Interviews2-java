package problems;

/**
 * 1.斐波那契数列
 * 2.青蛙跳台阶，完全就是斐波那契数列，都不需要实现了，修改一下初始条件就可以了
 * 3.还有个青蛙跳台阶的题目，就是每次都可以跳n步，数学公式是f(n)=2^(n-1)就是2的n-1次方。
 * 公式都有了，还需要写吗，如果要硬写就把递归改成f(n)=2*f(n-1)，
 * 因为f(n) = f(n-1)+f(n-2)+ ... +f(0) = f(n-1)+[f(n-2)+ ... +f(0)] = f(n-1) + f(n-1) = 2f(n-1)
 * 牛客斐波那契数列：https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3
 * 牛客跳台阶：https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4
 * 牛客变态跳台阶：https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387
 * @author acqierement
 * Data: 2018年11月20日
 * Time: 下午4:08:41
 */
public class NO_10 {
	//循环
	public static int fibonacci(int n) {
		if(n < 0) 
			return -1;
		int result[] = {0,1};
		if(n < 2) 
			return result[n];
		
		int fibNMinusOne = 1;//n-1
		int fibNMinustwo = 0;//n-2
		int fibN = 0;
		//从f(2)开始，f(2)=f(1)+f(0)......
		for(int i = 2; i <= n; i++) {
			fibN = fibNMinusOne + fibNMinustwo;
			fibNMinustwo = fibNMinusOne;
			fibNMinusOne = fibN;
		}
		return fibN;
	}
	
	//递归，这么简单的算法不推荐递归
	public static int fibonacci_2(int n) {
		if(n <= 0)
			return 0;
		if(n == 1)
			return 1;
		return fibonacci_2(n-1) + fibonacci_2(n-2);
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacci_2(5));//5
	}
}
