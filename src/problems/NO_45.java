package problems;


import java.util.Arrays;
import java.util.Comparator;


/**
 * 45.把数组排成最小的数
 * 此题思路就是把数字转换成字符串来进行排序，定义好排序规则
 * 牛客：https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993
 * @author acqierement
 * Data: 2018年12月1日
 * Time: 下午5:31:10
 */
public class NO_45 {
	// 用Arrays.sort使用自定义排序规则按照我们的要求对数据进行排列
	public String printMinNumber(int[] numbers) {
		String[] strNums = new String[numbers.length];
		for(int i = 0; i <numbers.length; i++) {
			strNums[i] = String.valueOf(numbers[i]);
		}
		// 这里也可以使用lambda表达式，简洁一点，但是不直观
		Arrays.sort(strNums, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = o1 + o2;
				String s2 = o2 + o1;
				return s1.compareTo(s2);
			}		
		});
//      Arrays.sort(strNums, (String o1,String o2)-> {
//      	String s1 = o1 + o2;
//      	String s2 = o2 + o1;
//      	return s1.compareTo(s2);
//      });
		
		StringBuilder sBuilder = new StringBuilder();
		for(String strNum : strNums ) {
			sBuilder.append(strNum);
		}
		return sBuilder.toString();
	}
}
