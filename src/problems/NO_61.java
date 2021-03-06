package problems;

import java.util.Arrays;

/**
 * 61.扑克牌中的顺子
 * 牛客：https://www.nowcoder.com/practice/762836f4d43d43ca9deb273b3de8e1f4?tpId=13&tqId=11198&tPage=3
 * 大小王可以当成任意数，所以主要是处理大小王
 * @author acqierement
 * Data: 2018年12月5日
 * Time: 下午12:41:09
 */
public class NO_61 {
    public boolean isContinuous(int [] numbers) {
    	if(numbers == null || numbers.length <= 0) {
    		return false;
    	}
    	Arrays.sort(numbers);
    	int cur = 0;
    	int numberOfZero = 0;
    	int numberOfGap = 0;
    	
    	while(cur < numbers.length && numbers[cur] == 0) {
    		cur++;
    	}
    	numberOfZero = cur;
    	int prev = cur;
    	cur = prev + 1;
    	while(cur < numbers.length) {
    		if (numbers[cur] == numbers[prev]) {
				return false;
			}
    		numberOfGap += numbers[cur] - numbers[prev] - 1;
    		prev = cur;
    		cur++;
    	}
    	return (numberOfGap <= numberOfZero) ? true : false;
    }
}
