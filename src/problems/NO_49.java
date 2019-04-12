package problems;


/**
 * 49.丑数
 * 牛客：https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b
 * @author acqierement 
 * Data: 2018年12月2日 
 * Time: 上午11:02:29
 */
public class NO_49 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] uglyNums = new int[index];
        int last2 = 0, last3 = 0, last5 = 0;
        uglyNums[0] = 1;
        int curIndex = 1;
        while (curIndex < index) {
            int min = findMin(uglyNums, last2, last3, last5);
            uglyNums[curIndex] = min;
            // 原本我以为以为下面这几个判断只会执行其中一个，就想着用if-else替换，结果发现，3*2和2*3的情况下，两个都需要+1，否则出现两个6了。
            if (uglyNums[last2] * 2 == min) last2++;
            if (uglyNums[last3] * 3 == min) last3++;
            if (uglyNums[last5] * 5 == min) last5++;
            curIndex++;
        }

        return uglyNums[curIndex - 1];
    }

    private int findMin(int[] uglyNums, int last2, int last3, int last5) {
        int min = Math.min(uglyNums[last2] * 2, uglyNums[last3] * 3);
        min = Math.min(uglyNums[last5] * 5, min);
        return min;
    }
}
