package problems;

/**
 * 63.股票的最大利润
 * LeetCode 121. Best Time to Buy and Sell Stock 
 * 还有Best Time to Buy and Sell Stock II~IV各种相似的题目，这里是最简单的一题，其他题目也很值得去看一下
 * @author acqierement
 * Data: 2018年12月5日
 * Time: 下午8:07:54
 */
public class NO_63 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
        	return 0;
        }
        
        int minprice = prices[0];
        int maxprofit = 0;
        for(int i = 1; i < prices.length; i++) {
        	if(prices[i] < minprice) {
        		minprice = prices[i];
        	}
        	if(prices[i] - minprice > maxprofit) {
        		maxprofit = prices[i] - minprice;
        	}
        }
        return maxprofit;
    }
}
