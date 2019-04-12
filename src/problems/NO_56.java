package problems;

/**
 * 56.数组中数字出现的次数
 * 题目一：数组中只出现一次的两个数字。LeetCode 260. Single Number III
 * 牛客：https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&tPage=2
 * 题目二：数组中唯一只出现一次的数字。LeetCode 137. Single Number II
 * @author acqierement
 * Data: 2018年12月4日
 * Time: 下午4:58:33
 */
public class NO_56 {
	// 题目一
	// num1,num2分别为长度为1的数组。最后返回的参数
	// 将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
    	int diff = 0;
    	// 将数组里面的数字异或，得到的是只出现一次的两个数的异或结果。由于两个数不会相等，diff不可能全0，一定会有1
        for(int num : array) {
        	diff ^= num;
        }
        // 如果数据是 00010010，得到00000010，只拿到最右边的一个1；
        diff &= -diff;
        num1[0] = 0;
        num2[0] = 0;
        // 根据是1的这个位置分组
        for(int num : array) {
        	if((num & diff) == 0) {// 该位是0；
        		num1[0] ^= num;
        	}else {// 该位是1；
        		num2[0] ^= num;
        	}
        }
    }
    
    // 题目二，和书上的思路一样，但是更简洁，LeetCode上有各种简洁到看不懂的代码，可以去学习一下。
    public int singleNumber(int[] nums) {
    	int ans = 0;
    	for(int i = 0; i < 32; i++) {
    		int sum = 0;
    		// 将所有数字的某一位的值加起来
    		for(int num : nums) {
    			if(((num >> i)&1) == 1) {
    				sum++;
    			}
    		}
    		//因为3个数相同，如果不能整除，就说明只出现一次的那个数的这一位为1.
    		sum = sum % 3;
    		// 把答案的这一位数值置为1
    		if(sum == 1) {
    			ans |= sum << i;
    		}
    	}
    	return ans;
    }
}
