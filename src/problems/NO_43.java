package problems;

import java.awt.Container;

/**
 * 43.1~n整数中1出现的次数
 * 力扣：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * 牛客：https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6
 * @author acqierement
 * Data: 2018年11月30日
 *  Time: 上午11:27:39
 */
public class NO_43 {
    // 一般最先想到的解法，其实这种题深究都是属于数学知识的范畴
    public static int NumberOf1Between1AndN_Simple(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += NumberOf1(i);
        }
        return count;
    }

    private static int NumberOf1(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 10 == 1) {
                count++;
            }
            num /= 10;
        }
        return count;
    }

    //比较巧妙的方法，具体看解题思路。

    public static int countDigitOne(int n) {
        int count = 0;
        // 当前是第几位
        int digit = 1;
        // 高位和低位
        int high = n / 10, low = 0;
        // 当前的数字
        int cur = n % 10;
        while (high != 0 || cur != 0) {
            // 如果当前数字为0，只和高位有关系
            if (cur == 0) {
                count += high * digit;
            }
            // 如果当前数字为1，除了高位，还要加上低位的数字
            if (cur == 1) {
                count += high * digit + low + 1;
            }
            if (cur > 1) {
                count += (high + 1) * digit;
            }
            low = cur * digit + low;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int count = countDigitOne(221);
        System.out.println(count);
    }

}
