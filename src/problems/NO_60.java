package problems;

import sun.launcher.resources.launcher;

/**
 * 60.n个骰子的点数
 * 新增动态规划的实现 2020年10月22日 15:43:12
 * @author acqierement
 * Data: 2018年12月5日
 * Time: 上午10:28:41
 */
public class NO_60 {
    static int max_value = 6;

    // 递归实现
    public static void findProbability(int number) {
        if (number < 1) {
            return;
        }
        int maxSum = number * max_value;
        // 假设有6个骰子，则结果为6~36，总共有36-6+1个数
        int[] probilities = new int[maxSum - number + 1];
        probability(number, probilities);
        double total = (int) Math.pow(max_value, number);
        for (int i = number; i <= max_value * number; i++) {
            double ratio = probilities[i - number] / total;
            System.out.printf("%d:%.5f ", i, ratio);

//			System.out.printf("%d:%e\t",i,ratio);
        }
        System.out.println("");
    }

    private static void probability(int number, int[] probilities) {
        for (int i = 1; i <= max_value; i++) {
            probability(number, number, i, probilities);
        }

    }

    private static void probability(int number, int curNum, int curSum, int[] probilities) {

        if (curNum == 1) {// 已经掷了6个骰子了
            probilities[curSum - number]++;
        } else {// 掷下一个骰子，有6种情况
            for (int i = 1; i <= max_value; i++) {
                // 递归投掷下一个骰子
                probability(number, curNum - 1, i + curSum, probilities);
            }
        }
    }

    // 循环实现
    public static void findProbability2(int number) {
        if (number < 1) {
            return;
        }
        int maxSum = number * max_value;
        int[][] probabilities = new int[2][maxSum + 1];
        int flag = 0;
        // 第一个骰子的结果，1~6各出现一次
        for (int i = 1; i <= max_value; i++) {
            probabilities[flag][i] = 1;
        }
        // 继续投掷骰子，k代表骰子的数量
        for (int k = 2; k <= number; k++) {
            // 把不会出现的结果清零，不然下次计算会加上这些结果，造成答案错误。
            for (int i = 0; i < k; i++) {
                probabilities[1 - flag][i] = 0;
            }
            // 如果现在投第二个骰子，那么两个骰子可能的值从2~2*6；
            for (int i = k; i <= k * max_value; i++) {
                // f(n) = f(n-1)+f(n-2)+...+f(n-6);
                // 清零
                probabilities[1 - flag][i] = 0;
                // 注意边界条件，当只有两个骰子的时候，和为2的值没办法减6
                for (int j = 1; j < i && j <= max_value; j++) {
                    probabilities[1 - flag][i] += probabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        double total = (int) Math.pow(max_value, number);
        for (int i = number; i <= max_value * number; i++) {
            double ratio = probabilities[flag][i] / total;
            System.out.printf("%d:%.5f ", i, ratio);
        }
        System.out.println("");
    }


    // 动态规划的实现
    public double[] twoSum(int n) {
        double[] pre = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < pre.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += pre[j] / 6;
                }
            }
            pre = temp;
        }
        return pre;
    }


    public static void main(String[] args) {
        findProbability(6);
        findProbability2(6);
    }
}
