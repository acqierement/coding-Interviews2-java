package problems;

import java.util.Arrays;
import java.util.HashMap;

/*
 * 长度为n的数组里面的数字范围都是从0~n-1范围的，找出数组中任意一个重复的数字
 * 利用这个条件可以找到类似桶排序的比较好的解法
 * 
 * 题目一可以修改数组 duplicate()
 * 题目二不可以修改数组 getDuplicate()
 */
public class NO_03 {

	/**
	 * 最简单和暴力的方法，给数组排序之后就可以很方便找出
	 * @param numbers 输入的数组
	 * @param length	输入数组的长度
	 * @param duplication 输出数组，存放找到的第一个重复的数字
	 * @return 数字中是否有重复的数字
	 */
	public static boolean duplicate1(int[] numbers, int length, int[] duplication) {
		if(numbers == null || length <= 0) {
			return false;
		}

		Arrays.sort(numbers);
		for (int i = 0; i < length - 1; i++) {
			if(numbers[i] == numbers[i + 1]) {
				duplication[0] = numbers[i];
				return true;
			}
		}
		return false;
	}
	
	/*
	 * 用哈希表
	 */
	public static boolean duplicate2(int[] numbers, int length, int[] duplication) {
		if (numbers == null) {
			return false;
		}

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i : numbers) {
			if (!hashMap.containsKey(i)) {
				hashMap.put(i, 1);
			}else {
				duplication[0] = i;
				return true;
			}
		}
		return false;
	}
	
	/*
	 * 类似桶排序
	 */
	public static boolean duplicate3(int[] numbers, int length, int[] duplication) {
		if(numbers == null || length <= 0) {
			return false;
		}
		
		for (int num : numbers) {
			if (num >= length) {
				return false;
			}
		}
		
		for (int i = 0; i < length; i++) {
			while (numbers[i] != i) {
				if(numbers[numbers[i]] == numbers[i]) {
					duplication[0] = numbers[i];
					return true;
				}
//				交换，原本的错误做法，因为numbers[i]在过程中改变了
//				到头来连交换都没写好
//				int temp = numbers[i];
//				numbers[i] = numbers[numbers[i]];
//				numbers[numbers[i]] = temp;
				//正确的交换
				int temp = numbers[i];
				numbers[i] = numbers[temp];
				numbers[temp] = temp;
			}
		}
		return false;
	}
	
//	这里题目原本是n+1个数字，1~n，我实现的和前面一样，n个数字，0~n-2;
	public static int getDuplication(int[] numbers, int length) {
		if(numbers == null || length <= 0) {
			return -1;
		}
		int start = 0;
		int end = length - 2;
		while (end >= start) {
			int mid = ((end - start)>>1) + start;
			int count = getRange(numbers, start, mid);
			if(end == start) {
				if(count > 1) {
					return start;
				}else {
					break;
				}
			}
			if(count > mid-start+1) {
				end = mid; 
			}else {
				start = mid + 1;
			}
		}
		return -1;
	}
	
	public static int  getRange(int[] numbers, int start, int end) {
		int count = 0;
		for (int num : numbers) {
			if (num >= start && num <= end) {
				count++;
			}
		}
		System.out.println("count:"+count);
		return count;
	}
	public static void main(String[] args) {
		//两题题目不一样，第一题数字范围等于数字个数，就是按顺序排列正好能填满整个数组,所以有可能没有重复的数字
		//第二题数字范围比数字个数小一，一定会有一个数字重复了。
        int[] numbers1 = {4,3,2,2,0};
        int[] numbers2 = {0,3,2,1,2};
        int[] dup = new int[1];
        if (duplicate3(numbers1, numbers1.length, dup)) {
			System.out.println(dup[0]);
		}else {
			System.out.println("numbers不重复");
		}
        
        int duplication = getDuplication(numbers2, numbers2.length);
        System.out.println(duplication ==-1?"没有重复":"重复数字是"+duplication);


	}
}
