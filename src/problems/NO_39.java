package problems;

/**
 * 39.数组中出现次数超过一半的数字
 * 书上有两种解法，第一种方法其实就是找最小（或者最大）的k个数（使用快排的思路），这里k等于一半，由于后面会用到，这里不再实现。所以这里用第二种方法实现一下
 * 牛客：https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163
 * @author acqierement
 * Data: 2018年11月29日
 * Time: 下午6:12:12
 */
public class NO_39 {
	/*在牛客网上学到了一个新思想，很有意思
	 * 作者：cm问前程
	链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163
	来源：牛客网

	采用阵地攻守的思想：
	第一个数字作为第一个士兵，守阵地；count = 1；
	遇到相同元素，count++;
	遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，
	继续下去，到最后还留在阵地上的士兵，有可能是主元素。
	最后验证一下这个数的次数是否大于数组一半即可。
	 */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length <= 0) {
        	return 0;
        }
		int res = 0, times = 0;
		for (int num : array) {
			if (times == 0) {
				res = num;
			}
			times += res == num ? 1 : -1;
		}
        if(!cheakMoreThanHalf(array,res)) {
        	return 0;
        }
        return res;
    }
    // 检查输入数组是否符合一个数大于一半
	private boolean cheakMoreThanHalf(int[] array, int res) {
		int count = 0;
		for (int num : array) {
			if(num == res) {
				count++;
			}
		}
		return count > array.length / 2;
	}
}
