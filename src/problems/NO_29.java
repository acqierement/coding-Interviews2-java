package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 29.顺时针打印矩阵
 * 参考 leetCode 54. Spiral Matrix
 * 牛客：https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a
 * @author acqierement
 * Data: 2018年11月27日
 * Time: 下午4:10:06
 */
public class NO_29 {
	public ArrayList<Integer> printMatrix(int[][] matrix){
		ArrayList<Integer> res = new ArrayList<>();
		if(matrix == null || matrix.length == 0) {
			return res;
		}
		
		int rowStart = 0, rowEnd = matrix.length - 1, colStart = 0, colEnd = matrix[0].length - 1;
		while(rowStart <= rowEnd && colStart <= colEnd) {
			for(int i = colStart; i <= colEnd; i++) {
				res.add(matrix[rowStart][i]);
			}
			rowStart++;
			for(int i = rowStart; i <= rowEnd; i++) {
				res.add(matrix[i][colEnd]);
			}
			colEnd--;
			//要记得加上if判断
			if(rowStart <= rowEnd) {
				for(int i = colEnd; i >= colStart; i--) {
					res.add(matrix[rowEnd][i]);
				}				
				rowEnd--;
			}
		    if(colStart <= colEnd) {
		    	for(int i = rowEnd; i >= rowStart; i--) {
		    		res.add(matrix[i][colStart]);
		    	}
		    	colStart++;		    	
		    }
		}
		return res;
	}
}
