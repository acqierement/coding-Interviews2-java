package problems;

/**
 * 64.求1+2+3+...+n
 * @author acqierement
 * Data: 2018年12月6日
 * Time: 上午9:44:24
 */
public class NO_64 {
	public int getSum(int n) {
		int ans = n;
		// 如果n <= 0,就不会执行&&后面的部分，以此来作为递归结束的条件，刚知道这个有个名词，叫短路特性，还挺形象的。
		boolean stop = (n>0) && ((ans += getSum(--n))>0);
		return ans;
	}
}
