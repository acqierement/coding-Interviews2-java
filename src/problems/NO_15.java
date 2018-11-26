package problems;

import java.util.BitSet;

/**
 * 位运算
 * 不要把数字右移，因为不知道是正数还是负数，但是java中可以用>>>无符号右移，解决这个问题
 * @author acqierement
 * Data: 2018年11月22日
 * Time: 下午8:16:45
 */
public class NO_15 {
	//用一个flag一位一位去判断
	public static int numberOfOne1(int n) {
		int flag = 1;
		int count = 0;
		while(flag != 0) {
			if((n&flag)!=0) {
				count++;
			}
			
			flag = flag << 1;
		}
		return count;
	}
	//用java>>>运算符
    public static int numberOfOne2(int n) {
        int result = 0;
        // 对每一个位置与1进行求与操作，再累加就可以求出当前数字的表示是多少位1
        for (int i = 0; i < 32; i++) {
            result += (n & 1);
            n >>>= 1;
        }

        return result;
    }
    
    //最优解，前面要每一位都比较，这个方法有几个1就只有几次。例子：
    //比如1100 1100-1=1001  1001&1100=1000 所以1100->1000,在执行一次1000->0000
    //所以这个操作会把从右往左第一个不是1的数字变成0
    public static int numberOfOne3(int n) {
    	int count = 0;
    	while(n != 0) {
    		count++;
    		n = (n-1) & n;
    	}
    	return count;
    }
	public static void main(String[] args) {
		//如果你输入的是负数，比如-3，在计算机中是0B111111111...101，有31个1
		//所以测试直接输入二进制数就可以了
		System.out.println(numberOfOne1(0));//0
		System.out.println(numberOfOne2(0));
		System.out.println(numberOfOne3(0));
		
		System.out.println(numberOfOne1(10));//2
		System.out.println(numberOfOne2(10));
		System.out.println(numberOfOne3(10));
		
		System.out.println(numberOfOne1(0x80000000));//1
		System.out.println(numberOfOne2(0x80000000));
		System.out.println(numberOfOne3(0x80000000));
	}

}
