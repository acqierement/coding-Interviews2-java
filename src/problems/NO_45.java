package problems;


import java.util.Arrays;
import java.util.Comparator;


/**
 * 45.把数组排成最小的数
 * @author acqierement
 * Data: 2018年12月1日
 * Time: 下午5:31:10
 */
public class NO_45 {
	// 用Arrays.sort对数据按照我们的要求进行排列
	public String printMinNumber(int[] numbers) {
		String[] strNums = new String[numbers.length];
		for(int i = 0; i <numbers.length; i++) {
			strNums[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(strNums, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				return s1.compareTo(s2);
			}		
		});
		StringBuilder sBuilder = new StringBuilder();
		for(String strNum : strNums ) {
			sBuilder.append(strNum);
		}
		return sBuilder.toString();
	}
}
