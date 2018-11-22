package example;

/**
 * 剪绳子
 * @author acqierement
 * Data: 2018年11月22日
 * Time: 下午7:29:08
 */
public class NO_14 {
	//动态规划
	public static int maxProductAfterCutting_solution1(int length) {
		if(length < 2) 
			return 0;
		if(length == 2)
			return 1;
		if(length == 3)
			return 2;
		int products[] = new int[length+1];
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;
		int max = 0;
		for(int i = 4; i <= length; i++) {
			for(int j = 1; j <= i/2; j++) {
				int product = products[j]*products[i-j];
				max = max > product ? max : product;
			}
			products[i] = max;
		}
		max = products[length];
		return max;
	}
	
	//贪婪算法，前提是要有最优的解法，这题最优的解法就是都尽量剪成 长度为3的小绳子，除了4,4要剪成两段2
	public static int maxProductAfterCutting_solution2(int length) {
		if(length < 2) 
			return 0;
		if(length == 2)
			return 1;
		if(length == 3)
			return 2;
		
		int timesOf3 = length/3;
		
		int remain = length - timesOf3*3;
		if(remain == 1) {//4=2*2 > 1*3
			remain = remain + 3;
			timesOf3--;
		}
		int timesOf2 = remain/2;

		return (int) Math.pow(3, timesOf3) * (int)Math.pow(2, timesOf2);
	}

	public static void main(String[] args) {
		//这边测试的方法应该学习一下书上源代码（github）的测试方法
		System.out.println(maxProductAfterCutting_solution2(10));//36
		System.out.println(maxProductAfterCutting_solution2(50));//86093442
		System.out.println(maxProductAfterCutting_solution1(10));
		System.out.println(maxProductAfterCutting_solution2(50));
	}
}
