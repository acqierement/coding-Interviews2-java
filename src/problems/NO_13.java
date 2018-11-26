package problems;import java.awt.Checkbox;

/**
 * 机器人的运动范围
 * @author acqierement
 * Data: 2018年11月22日
 * Time: 下午6:09:59
 */
public class NO_13 {
	public int movingCount(int threshold, int row, int col) {
		if(threshold <= 0 || row <= 0 || col <= 0)
			return 0;
		boolean[][] visited = new boolean[row][col];
		int count = movingCountCore(threshold, row, col, 0, 0, visited);
		return count;
	}

	private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
		int count = 0;
		if(check(threshold, rows, cols, row, col, visited)) {
			visited[row][col] = true;
			count = 1 + movingCountCore(threshold, rows, cols, row+1, col, visited)
					+ movingCountCore(threshold, rows, cols, row-1, col, visited)
					+ movingCountCore(threshold, rows, cols, row, col+1, visited)
					+ movingCountCore(threshold, rows, cols, row, col-1, visited);
		}
		return count;
	}

	private boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
		if(row >= 0 && row < rows && col >= 0 && col < cols 
			&& (getDigitSum(row)+getDigitSum(col) <= threshold)
			&& !visited[row][col]){
				return true;
		}
		return false;
	}

	private int getDigitSum(int num) {
		int sum = 0;
		while(num > 0) {
			sum += num%10;
			num = num/10;
		}
		return sum;
	}
}
