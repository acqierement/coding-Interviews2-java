package problems;

/**
 * 51.数组中的逆序对
 * @author acqierement
 * Data: 2018年12月2日
 * Time: 下午7:11:58
 */
public class NO_51 {
	// 其实这个过程就是归并排序的过程，归并函数分成左右两部分，如果左边有数据大于右边的数据，那么就存在逆序对
	// 而且经过排序之后，可以更好地计算逆序对的数量，主要逻辑实现都在merge方法。
	static int  count = 0;
    public static int InversePairs(int [] array) {
    	if(array == null) {
    		return count;
    	}
        mergeCore(array, 0, array.length - 1);
        return count;
    }
    // 这个方法主要实现分解成两部分的操作，重点在merge方法
	private static void mergeCore(int[] array, int start, int end) {
		if(start >= end) {
			return;
		}
		int mid = ((end - start) >> 1) + start;
		mergeCore(array, start, mid);
		mergeCore(array, mid + 1, end);
		
		merge(array, start, mid, end);
	}
	// 主要逻辑实现
	private static void merge(int[] array, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int left = start, right = mid + 1, index = 0;
		while(left <= mid && right <= end) {
			if(array[left] < array[right]) {
				temp[index++] = array[left++];
			}else {
				temp[index++] = array[right++];
				count += mid - left + 1;
			}
		}
		while(left <= mid) {
			temp[index++] = array[left++];
		}
		while(right <= end) {
			temp[index++] = array[right++];
		}
		for(int i = 0; i < temp.length; i++) {
			array[start + i] = temp[i];
		}
	}
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,0};
		int inversePairs = InversePairs(array);
		System.out.println(inversePairs);
	}
}
