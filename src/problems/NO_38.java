package problems;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;

/**
 * 38.字符串的排列
 * @author acqierement
 * Data: 2018年11月29日
 * Time: 下午3:03:28
 */
public class NO_38 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        char[] charArray = str.toCharArray();
        helper(charArray, res, 0);
        Collections.sort(res);//为了满足牛客网上的测试用例
        return res;
    }

	private void helper(char[] charArray, ArrayList<String> res, int index) {
		if(index == charArray.length - 1) {
			if (!res.contains(String.valueOf(charArray)))
			res.add(String.valueOf(charArray));
		}
		for(int i = index; i < charArray.length; i++) {
			swap(charArray,index,i);
			helper(charArray, res, index+1);
		}
	}

	private void swap(char[] charArray, int index, int i) {
		char temp = charArray[index];
		charArray[index] = charArray[i];
		charArray[i] = temp;
	}
}
