package problems;

/**
 * 39.数组中出现次数超过一半的数字
 * 书上有两种解法，这里只实现了第二种
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
	再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
	 */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length <= 0) {
        	return 0;
        }
        int res = array[0];
        int times = 1;
        for (int num : array) {
			if(times == 0) {
				res = num;
				times = 1;
			}else {
				if(res == num) {
					times++;
				}else {
					times--;
				}
			}
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
		return count > array.length/2 ? true : false;
	}
}
