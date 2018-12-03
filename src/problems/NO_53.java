package problems;

/**
 * 53.在排序数组中查找数字
 * 这一题主要都是二分查找
 * 题目一：数字在排序数组中出现的次数
 * 题目二：0~n-1中缺失的数字
 * 题目三：数组中数值和下标相等的元素
 * 
 * @author acqierement
 * Data: 2018年12月3日
 * Time: 上午11:24:20
 */
public class NO_53 {
	// 题目一,主要用二分法来找到第一个k和最后一个k
	public static int getNumberOfK(int [] array , int k) {
		int count = 0;
		int firstIndex = getFirstK(array, k, 0, array.length - 1);
		int lastIndex = getLastK(array, k, 0, array.length - 1);
		if(firstIndex != -1 && lastIndex != -1) {
			count = lastIndex - firstIndex + 1;
		}
		return count;
	}

	private static int getFirstK(int[] array, int k, int start, int end) {
		if(start > end) {
			return -1;
		}
		int mid = ((end - start)>>1) + start;
		if(array[mid] < k) {
			start = mid + 1;
		}
		if(array[mid] > k) {
			end = mid - 1;
		}
		if(array[mid] == k) {
			//找到第一个k或者k在数组第一个的时候，返回k的位置
			if((mid > 0 && array[mid - 1] != k) || mid == 0) {
				return mid;
			}else {
				end = mid - 1;
			}
		}
		return getFirstK(array, k, start, end);
	}
	private static int getLastK(int[] array, int k, int start, int end) {
		if(start > end) {
			return -1;
		}
		int mid = ((end - start)>>1) + start;
		if(array[mid] < k) {
			start = mid + 1;
		}
		if(array[mid] > k) {
			end = mid - 1;
		}
		if(array[mid] == k) {
			//找到最后一个k或者k在数组最后一个的时候，返回k的位置
			if((mid < array.length - 1 && array[mid + 1] != k) || mid == array.length - 1) {
				return mid;
			}else {
				start = mid + 1;
			}
		}
		return getLastK(array, k, start, end);
	}
	
	// 题目二
	public static int getMissNumber(int[] arrays, int length) {
		int left = 0, right = length - 1;
		while(left <= right) {
			int mid = (left + right)>>1;
			if(arrays[mid] != mid) {
				//判断当前是否是要找的缺失的那个数字
				if(mid == 0 || arrays[mid - 1] == mid - 1) {
					return mid;
				}else {//往左边找
					right = mid - 1;
				}
			}else {// 相等证明缺失的数字在右边
				left = mid + 1;
			}
		}
		
		if(left == length) {// 不存在缺失的数据
			return length;
		}
		
		return -1;
	}
	
	// 题目三
	public static int getNumberSameAsIndex(int[] array) {
		if(array == null || array.length <= 0) {
			return -1;
		}
		int left = 0, right = array.length - 1;
		while(left <= right) {
			int mid = (right + left) >> 1;
			if(array[mid] == mid) {
				return mid;
			}
			if(array[mid] < mid) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
//		int[] array = {1,2,3,3,3,3,4,5};
//		int[] array = {1,2,3,4,5,6,7};
		int[] array = {-3,-1,1,3,5};
//		int num = getMissNumber(array, array.length);
		int num = getNumberSameAsIndex(array);
		System.out.println(num);
	}
}
