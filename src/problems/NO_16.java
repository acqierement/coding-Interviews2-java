package problems;

/**
 * 数值的整数次方
 * 这题牛客的判断不严，不需要考虑Integer.MIN_VALUE的问题
 * 牛客：https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00
 * @author acqierement
 * Data: 2018年11月23日
 * Time: 下午7:13:07
 */
public class NO_16 {
	//这里把书中的递归操作用迭代实现。
	public static double myPow(double x, int n) {
        boolean isNegative = n<0 ? true : false;
      //如果是负数，power = abs(n)-1,避免了n=Integer.MIN_VALUE的情况
        int power = isNegative? -1*(n+1) : n;
        double ans = 1;
        double multi = x;
        while(power != 0){
            if(power % 2 == 1)
                ans = ans * multi;
            multi = multi * multi;
            power = power>>1;
        }
        if(isNegative) return 1/ans*(1/x);//负数的时候，要倒数，而且power少了一次，这里补上
        return ans;
    }
	
	
	public static void main(String[] args) {

	}
}
