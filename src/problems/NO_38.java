package problems;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

/**
 * 38.字符串的排列
 * leetcode 46. Permutations
 * 牛客网的测试用例 会有 aa 这样重复的数据，不能用我这里的代码，因为我代码是基于交换的，所以结果会有aa和aa，不符合牛客网的例子。
 * 牛客：https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7
 * @author acqierement
 * Data: 2018年11月29日
 * Time: 下午3:03:28
 */
public class NO_38 {
	// 这个例子通过了leetcode的测试。基于书上的交换来实现，速度比较快。
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0);
        return res;
    }

    public void helper( List<List<Integer>> res, int[] nums, int pos) {
        if (pos >= nums.length) {
            res.add(construct(nums));
        }
        for (int i = pos; i < nums.length; i++) {
			// 这里交换之后，后面要再换回来，原本我不理解，
			// 误以为helper里面会把后面的位置都变了，再换回来就不是原来的数字了。
			// 因为helper里面确实会把后面的位置变了，但是返回的时候又会把每个数字换回来。所以helper在过程中会变换位置，但是最后返回的时候，位置都没有变化。
			// 还有要注意这里交换会出现i和i交换，就是没有交换，因为没有交换也属于一种情况，也要算进去。
            swap(nums, pos, i);
            helper(res, nums, pos + 1);
            swap(nums, pos, i);
        }
    }

    public List<Integer> construct(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        return list;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
