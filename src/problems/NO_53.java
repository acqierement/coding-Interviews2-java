package problems;

/**
 * 53.在排序数组中查找数字
 * 这题的思路很有意思，不然这么简单的题就只会想到用最简单的方法做
 * @author acqierement
 * Data: 2018年12月3日
 * Time: 上午11:24:20
 */
public class NO_53 {
	// 主要用二分法来找到第一个k和最后一个k
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
	public static void main(String[] args) {
		int[] array = {1,2,3,3,3,3,4,5};
		getNumberOfK(array, 3);
	}
}
