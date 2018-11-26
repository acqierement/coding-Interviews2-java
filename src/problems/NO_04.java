package problems;

/**
 * 二维数组的查找
 * 
 * @author acqierement Data: 2018年11月17日 Time: 下午6:31:40
 */
/*
 * 原本我的想法也是和书里前面说的一样，从矩阵的右下角开始，发现这样最后要找的数在i行i列，
 * 然后还要遍历i行和i列，而且矩形也不一定是正方形。所以总的来说和书中介绍的用右上角或左下角没有太大区别，用书上的方法还比较直观。
 * 以上都是我在挣扎过后得出的教训，结论就是还是书上的方法好啊
 */
public class NO_04 {
	public static boolean find(int[][] matrix, int number) {

		if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
			return false;
		}
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		if (matrix[rowLen - 1][colLen - 1] < number || matrix[0][0] > number) {
			return false;
		}
		int row = 0, col = colLen - 1;
		
		while(row < rowLen && col >= 0 ) {
			if(matrix[row][col] == number) {
				return true;
			}else if (matrix[row][col] > number) {
				col--;
			}else {
				row++;
			}
		}
		
		return false;

	}

}
